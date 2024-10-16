package com.br.ericcarv4lho.bibliotecasistema.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorDTO {
    private Long id;
    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;
    private String nacionalidade;
    private String biografia;


}
