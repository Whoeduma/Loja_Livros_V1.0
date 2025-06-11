package com.loja.livros.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_vendas") // Nome da tabela no banco
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class VendasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //ID gerado automaticamente
    private Long id;


    @Column(name = "data_venda")
    private LocalDate dataVenda;//data da venda


    @Column (name = "valor_total", nullable = false)
    private BigDecimal valorTotal;//Preco total da venda

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<VendaLivrosEntity> itens;

}
