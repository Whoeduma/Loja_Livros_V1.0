package com.loja.livros.dto;


import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LivrosDTO {
    private Long id; // ID do livro (usado para edição e leitura)
    private String nome; // Nome do livro (ex: "Dom Casmurro")
    private  Long categoriaId; //ID da categoria (FOREIGN KEY)
    private Long autorId; // ID do autor (chave estrangeira)
    private BigDecimal vlrUnitario;
}
