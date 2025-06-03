package com.loja.livros.repository;

import com.loja.livros.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livros, Integer> {
    // O JpaRepository  traz métodos prontos como:
    // - findAll()
    // - findById()
    // - save()
    // - deleteById()
}
