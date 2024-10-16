package com.br.ericcarv4lho.bibliotecasistema.Repositorios;

import com.br.ericcarv4lho.bibliotecasistema.Entidades.Livro;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepositorio extends JpaRepository<Livro, Long> {

    Page<Livro> findByAutor_NomeContaining(String nome, Pageable pageable);


    Page<Livro> findByAutorNacionalidadeContaining(String nacionalidade, Pageable pageable);

}
