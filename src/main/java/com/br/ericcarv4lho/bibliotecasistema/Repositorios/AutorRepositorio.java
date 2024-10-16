package com.br.ericcarv4lho.bibliotecasistema.Repositorios;

import com.br.ericcarv4lho.bibliotecasistema.Entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Long> {
}
