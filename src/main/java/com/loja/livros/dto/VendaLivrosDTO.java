package com.loja.livros.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VendaLivrosDTO {
    private Long id;
    private Long idLivro;
    private Long idVenda;
    private Integer qtd;
}
