package com.loja.livros.dto;

public class AutorDTO {
    private Integer id;
    private String nome;

    public AutorDTO() {
    }

    public AutorDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    //Getter e Setter do id
    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //Getter e Setter do nome
    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
