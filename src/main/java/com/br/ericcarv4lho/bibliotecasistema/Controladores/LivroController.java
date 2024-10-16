package com.br.ericcarv4lho.bibliotecasistema.Controladores;


import com.br.ericcarv4lho.bibliotecasistema.DTO.AutorLivroDTO;
import com.br.ericcarv4lho.bibliotecasistema.DTO.LivroDTO;
import com.br.ericcarv4lho.bibliotecasistema.Entidades.Autor;
import com.br.ericcarv4lho.bibliotecasistema.Entidades.Livro;
import com.br.ericcarv4lho.bibliotecasistema.Servicos.AutorServicos;
import com.br.ericcarv4lho.bibliotecasistema.Servicos.LivroServicos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping({"/livros"})
public class LivroController {
    @Autowired
    private LivroServicos livroServicos;
    @Autowired
    private AutorServicos autorServicos;

    private AutorLivroDTO autorLivroDTO;



    @GetMapping({"/listar"})
    public ResponseEntity<List<LivroDTO>> listarLivros(){
        List<Livro> livros = livroServicos.listarLivros();
        List<LivroDTO> livroDTOs = livros.stream()
                .map(livro -> livroServicos.toDTO(livro))
                .collect(Collectors.toList());
        return ResponseEntity.ok(livroDTOs);
    }


    @GetMapping({"/listarComPaginacao"})
    public ResponseEntity<Page<LivroDTO>> listarLivrosComPaginacao(Pageable pageable) {
        Page<Livro> livros = livroServicos.listarLivrosComPaginacao(pageable);
        Page<LivroDTO> livrosDTO = livros.map(livroServicos::toDTO);
        return ResponseEntity.ok(livrosDTO);
    }

    @GetMapping({"/listarPorAutor"})
    public ResponseEntity<Page<Livro>> listarLivrosPorNomeDoAutor(String nome, Pageable pageable) {
        Page<Livro> livros = livroServicos.listarLivrosPorNomeDoAutor(nome, pageable);
        return ResponseEntity.ok(livros);
    }





    @PostMapping("/adicionar")
    public ResponseEntity<LivroDTO> criarAutorELivro(@RequestBody AutorLivroDTO autorLivroDTO) {
        Autor novoAutor = autorServicos.adicionarAutor(autorLivroDTO.getAutor());
        Livro livro = autorLivroDTO.getLivro();
        Livro novoLivro = livroServicos.adicionarLivroComAutor(novoAutor, livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroServicos.toDTO(novoLivro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro livro) {

       Livro livroAtualizado = livroServicos.atualizarLivro(id,livro);
        return ResponseEntity.status(HttpStatus.OK).body(livroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        livroServicos.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }
}