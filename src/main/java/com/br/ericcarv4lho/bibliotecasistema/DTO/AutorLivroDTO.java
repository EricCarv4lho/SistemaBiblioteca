package com.br.ericcarv4lho.bibliotecasistema.DTO;

import com.br.ericcarv4lho.bibliotecasistema.Entidades.Autor;
import com.br.ericcarv4lho.bibliotecasistema.Entidades.Livro;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutorLivroDTO {
    @NotNull(message = "Autor não pode ser nulo")

    private Autor autor;
    @NotNull(message = "Livro não pode ser nulo")

    private Livro livro;


}
