package com.br.ericcarv4lho.bibliotecasistema.Repositorios;

import com.br.ericcarv4lho.bibliotecasistema.Entidades.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepositorio extends JpaRepository<Livro,Long> {
}
