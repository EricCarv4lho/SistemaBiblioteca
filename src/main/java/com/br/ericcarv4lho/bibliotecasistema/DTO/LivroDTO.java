package com.br.ericcarv4lho.bibliotecasistema.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LivroDTO {

    private Long codigo;
    private String titulo;
    private LocalDate data;
    private double preco;
    private AutorDTO autor;


}
