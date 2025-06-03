package com.loja.livros.dto;

public class LivrosDTO {
    private Integer id; // ID do livro (usado para edição e leitura)
    private String nome; // Nome do livro (ex: "Dom Casmurro")
    private  Integer categoriaId; //ID da categoria (FOREIGN KEY)
    private Integer autorId; // ID do autor (chave estrangeira)
    private Double preco;

    //getters e setters
    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCategoriaId(){
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
