package com.loja.livros.repository;

import com.loja.livros.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    // Não precisamos escrever nada aqui agora,
    // porque o JpaRepository já oferece vários métodos prontos,
    // como: findAll(), findById(), save(), deleteById(), etc.
}
