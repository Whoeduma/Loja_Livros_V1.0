package com.loja.livros.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity // Indica que essa classe é uma entidade (tabela) do banco de dados
@Table(name = "livros") // Nome da tabela no banco será 'livros'
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivrosEntity {

    @Id //identifica a chave primaria da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incremento no banco
    private Long id;

    @Column(nullable = false)
    private String nome; //Nome do livro

    @Column(nullable = false, name = "valor_unitario")
    private BigDecimal vlrUnitario; // preco do livro

    @ManyToOne // Muitos livros podem ter o mesmo autor
    @JoinColumn(name = "id_autor") //Nome da coluna no banco que faz referência ao autor
    private AutorEntity autor;

    @ManyToOne //Muitos livros podem ter a mesma categoria
    @JoinColumn(name = "id_categoria") //Nome da coluna no banco que faz referência à categoria
    private CategoriaEntity categoriaEntity;


}
