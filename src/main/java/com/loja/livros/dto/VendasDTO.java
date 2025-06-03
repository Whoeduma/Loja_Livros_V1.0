package com.loja.livros.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VendasDTO {
    private Integer id;
    private Integer livroId;
    private String nomeLivro;
    private LocalDate dataVenda;
    private Integer quantidade;
    private Double precoTotal;
}
