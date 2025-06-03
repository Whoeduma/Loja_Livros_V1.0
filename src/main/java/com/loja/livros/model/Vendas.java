package com.loja.livros.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "vendas") // Nome da tabela no banco
@Getter
@Setter

public class Vendas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //ID gerado automaticamente
    private Integer id;

    //relacionamento com livro vendido
    @ManyToOne
    @JoinColumn(name = "id_livro") //FK para o livro
    private Livros livro;

    @Column(name = "data_venda")
    private LocalDate dataVenda;//data da venda

    @Column(name = "qtd")
    private Integer qtd; //quantos livros foram vendidos

    @Column (name = "valor_total")
    private Double precoTotal;//Preco total da venda

}
