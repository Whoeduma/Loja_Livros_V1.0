package com.loja.livros.repository;

import com.loja.livros.model.LivrosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrosRepository extends JpaRepository<LivrosEntity, Long> {
    // O JpaRepository  traz métodos prontos como:
    // - findAll()
    // - findById()
    // - save()
    // - deleteById()
}
