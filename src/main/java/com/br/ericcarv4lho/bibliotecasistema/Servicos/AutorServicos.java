package com.br.ericcarv4lho.bibliotecasistema.Servicos;

import com.br.ericcarv4lho.bibliotecasistema.Entidades.Autor;

import com.br.ericcarv4lho.bibliotecasistema.Repositorios.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServicos {
    @Autowired
    private AutorRepositorio autorRepositorio;

    public Autor adicionarAutor(Autor autor) {
        if (autor == null) {
            throw new IllegalArgumentException("O Autor nao pode ser nulo");
        } else {
            return autorRepositorio.save(autor);

        }
    }


}
