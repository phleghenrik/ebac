package com.ebac.spring_framework.repository;

import com.ebac.spring_framework.entities.Campeonato;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato, Integer> {
    List<Campeonato> findByNome(String nome);
    List<Campeonato> findByAnoGreaterThan(Integer ano);
    Campeonato findFirstByOrderByAno();
    long countByAno(Integer ano);
    @Transactional
    void deleteByNome(String nome);
}
