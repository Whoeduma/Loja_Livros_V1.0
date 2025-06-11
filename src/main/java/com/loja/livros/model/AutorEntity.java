package com.loja.livros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="autor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Chave primária auto-incrementada

    @Column(nullable = false)
    private String nome; // Campo obrigatório no banco

}
