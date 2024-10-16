package com.br.ericcarv4lho.bibliotecasistema.Servicos;

import com.br.ericcarv4lho.bibliotecasistema.DTO.AutorDTO;
import com.br.ericcarv4lho.bibliotecasistema.DTO.LivroDTO;
import com.br.ericcarv4lho.bibliotecasistema.Entidades.Autor;
import com.br.ericcarv4lho.bibliotecasistema.Entidades.Livro;
import com.br.ericcarv4lho.bibliotecasistema.Excecoes.LivrosNaoEncontradosException;
import com.br.ericcarv4lho.bibliotecasistema.Repositorios.LivroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroServicos {
    @Autowired
    private LivroRepositorio livroRepositorio;


    public Livro adicionarLivroComAutor(Autor autor, Livro livro) {
        livro.setAutor(autor); // Associar o autor ao livro
        return livroRepositorio.save(livro);
    }

    public Page<Livro> listarLivrosComPaginacao(Pageable pageable) {
        Page<Livro> livros = livroRepositorio.findAll(pageable);
        if (livros.isEmpty()) {
            throw new LivrosNaoEncontradosException("Livros nao encontrados 1-1");
        } else {
            return livros;
        }

    }

    public List<Livro> listarLivros() {
        return livroRepositorio.findAll();
    }

    public Livro atualizarLivro(Long id, Livro livro) {
        Livro livroExistente = livroRepositorio.findById(id)
                .orElseThrow(() -> new LivrosNaoEncontradosException("Livro não encontrado"));

        livroExistente.setData(livro.getData());
        livroExistente.setPreco(livro.getPreco());
        livroExistente.setTitulo(livro.getTitulo());
        livroExistente.setAutor(livro.getAutor());

        return livroRepositorio.save(livroExistente);
    }

    public void deletarLivro(Long codigo) {
        if (this.livroRepositorio.findById(codigo).isEmpty()) {
            throw new LivrosNaoEncontradosException("Livro nao encontrado com o codigo " + codigo);
        } else {
            this.livroRepositorio.deleteById(codigo);
        }
    }

    public Page<Livro> listarLivrosPorNomeDoAutor(String nome, Pageable pageable) {

        return livroRepositorio.findByAutor_NomeContaining(nome, pageable);


    }

    public LivroDTO toDTO(Livro livro) {
        LivroDTO dto = new LivroDTO();
        dto.setCodigo(livro.getCodigo());
        dto.setTitulo(livro.getTitulo());
        dto.setData(livro.getData());
        dto.setPreco(livro.getPreco());
        dto.setAutor(toDTO(livro.getAutor()));
        return dto;
    }

    public AutorDTO toDTO(Autor autor) {
        AutorDTO dto = new AutorDTO();
        dto.setId(autor.getId());
        dto.setNome(autor.getNome());
        dto.setNacionalidade(autor.getNacionalidade());
        dto.setBiografia(autor.getBiografia());
        return dto;
    }

}
