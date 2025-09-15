package com.ebac.spring_framework.repository;

import com.ebac.spring_framework.entities.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

}
