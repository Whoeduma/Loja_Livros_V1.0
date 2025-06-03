package com.loja.livros.model;

import jakarta.persistence.*;


@Entity // Indica que essa classe é uma entidade (tabela) do banco de dados
@Table(name = "livros") // Nome da tabela no banco será 'livros'
public class Livros {

    @Id //identifica a chave primaria da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incremento no banco
    private Integer id;

    @Column(nullable = false)
    private String nome; //Nome do livro
    private Double preco; // preco do livro

    @ManyToOne // Muitos livros podem ter o mesmo autor
    @JoinColumn(name = "id_autor") //Nome da coluna no banco que faz referência ao autor
    private Autor autor;

    @ManyToOne //Muitos livros podem ter a mesma categoria
    @JoinColumn(name = "id_categoria") //Nome da coluna no banco que faz referência à categoria
    private Categoria categoria;

    //Getters e Setters
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
