package com.br.ericcarv4lho.bibliotecasistema.Entidades;


import jakarta.persistence.*;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(
        name = "livros"
)
@Getter
@Setter

@NoArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotBlank
    private String titulo;

    private LocalDate data;

    @NotNull(message = "Preço não pode ser nulo")
    @DecimalMin(value = "0.0", message = "Preço deve ser um valor igual ou maior que zero")
    private double preco;

    @NotNull(message = "Autor não pode ser nulo")
    @ManyToOne
    private Autor autor;


    public Livro(String titulo, LocalDate data, double preco, Autor autor) {
        this.titulo = titulo;
        this.data = data;
        this.preco = preco;
        this.autor = autor;
    }


}
