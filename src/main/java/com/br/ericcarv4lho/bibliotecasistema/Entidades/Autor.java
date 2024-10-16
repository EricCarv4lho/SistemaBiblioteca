package com.br.ericcarv4lho.bibliotecasistema.Entidades;




import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "autores")
@Getter
@Setter
@NoArgsConstructor
public class Autor {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String nome;
    private String nacionalidade;
    private String biografia;

    @OneToMany(mappedBy = "autor", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)

    private List<Livro> livros = new ArrayList<>();


    public Autor(String nome, String nacionalidade, String biografia) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.biografia = biografia;

    }
}
