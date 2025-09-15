package com.ebac.spring_framework.service;

import com.ebac.spring_framework.entities.Usuario;
import com.ebac.spring_framework.repository.UsuarioRepository;
import com.ebac.spring_framework.requests.UsuarioRequest;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(final UsuarioRepository repository, final  PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = repository.findByNome(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado:" + username));
        return new User(u.getUsername(), u.getPassword(), true, true, true, true, u.getAuthorities());

    }

    public void criarUsuario(UsuarioRequest request){
        Usuario u = new Usuario();
        u.setNome(request.getNome());
        u.setSenha(passwordEncoder.encode(request.getSenha()));
        repository.save(u);
    }

    public void deletarUsuarioPorId(String id){
        repository.deleteById(UUID.fromString(id));
    }
}
