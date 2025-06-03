package com.loja.livros.model;

import jakarta.persistence.*;


@Entity
@Table(name="autor")

public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(nullable = false)
    private String nome;

    //construtor vazio (spring precisa disso)
    public Autor() {}

    //construtor com nome
    public Autor(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    //Getters e Setters (para acessar os dados)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
