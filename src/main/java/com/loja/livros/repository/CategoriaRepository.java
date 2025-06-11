package com.loja.livros.repository;

import com.loja.livros.model.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
    // Não precisamos escrever nada aqui agora,
    // porque o JpaRepository já oferece vários métodos prontos,
    // como: findAll(), findById(), save(), deleteById(), etc.
}
