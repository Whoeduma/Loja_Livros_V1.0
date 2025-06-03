package com.loja.livros.dto;

// DTO simples com apenas id e nome da categoria
public class CategoriaDTO {
    private Integer id;
    private String nome;

    //getters e Setters

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
