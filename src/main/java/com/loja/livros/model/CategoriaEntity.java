package com.loja.livros.model;

import jakarta.persistence.*;
import lombok.*;


// Anotação que indica que essa classe representa uma TABELA do banco de dados
@Entity
@Table(name = "categoria") // Nome da tabela no banco
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class CategoriaEntity {
    // Esse campo será a chave primária (primary key) da tabela

    @Id
    // Gera o valor automaticamente (auto_increment no MySQL)

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Coluna chamada "nome" que não pode ser nula no banco (obrigatória)
    @Column(nullable = false)
    private String nome;

}
