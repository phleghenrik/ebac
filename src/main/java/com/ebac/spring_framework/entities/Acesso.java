package com.ebac.spring_framework.entities;

import com.ebac.spring_framework.enums.TipoAcesso;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.UUID;

@Entity(name = "acesso")
@Table(name = "acessos")
public class Acesso implements Serializable, GrantedAuthority {

    private static final long serializableVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idAcesso;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoAcesso tipoAcesso;

    @Override
    public String getAuthority() {
        return this.tipoAcesso.toString();
    }

    public UUID getIdAcesso() {
        return idAcesso;
    }

    public void setIdAcesso(UUID idAcesso) {
        this.idAcesso = idAcesso;
    }

    public TipoAcesso getTipoAcesso() {
        return tipoAcesso;
    }

    public void setTipoAcesso(TipoAcesso tipoAcesso) {
        this.tipoAcesso = tipoAcesso;
    }
}
