package com.loja.livros.model;

import jakarta.persistence.*;

// Anotação que indica que essa classe representa uma TABELA do banco de dados
@Entity
@Table(name = "categoria") // Nome da tabela no banco

public class Categoria {
    // Esse campo será a chave primária (primary key) da tabela

    @Id
    // Gera o valor automaticamente (auto_increment no MySQL)

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Coluna chamada "nome" que não pode ser nula no banco (obrigatória)
    @Column(nullable = false)
    private String nome;

    // ---------- Getters e Setters ----------

    //Pega o valor do ID (usado para leitura)
    public Integer getId(){
        return id;
    }

    //Define o valor do ID (usado apenas internamente pelo JPA)
    public void setId(Integer id) {
        this.id = id;
    }

    // Pega o nome da categoria (ex: "Romance", "Fantasia")
    public String getNome(){
        return nome;
    }

    // Define o nome da categoria
    public void setNome(String nome) {
        this.nome = nome;
    }
}
