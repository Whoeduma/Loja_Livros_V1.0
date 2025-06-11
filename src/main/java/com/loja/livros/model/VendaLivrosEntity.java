package com.loja.livros.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rel_venda_livro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VendaLivrosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rel_venda_livro")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_livro", nullable = false)
    private LivrosEntity livro;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_venda", nullable = false)

    private VendasEntity venda;

    @Column(nullable = false)
    private Integer qtd;
}
