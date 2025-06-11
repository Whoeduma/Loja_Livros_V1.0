package com.loja.livros.dto;

import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VendasDTO {
    private Long id;
    private LocalDate dataVenda;
    private BigDecimal valorTotal;
    private List<VendaLivrosDTO> itens;
}
