package com.loja.livros.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// DTO simples com apenas id e nome da categoria
public class CategoriaDTO {
    private Long id;
    private String nome;
}
