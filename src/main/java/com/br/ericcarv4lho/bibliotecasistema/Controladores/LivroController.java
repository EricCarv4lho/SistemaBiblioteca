package com.br.ericcarv4lho.bibliotecasistema.Controladores;




import com.br.ericcarv4lho.bibliotecasistema.Entidades.Livro;
import com.br.ericcarv4lho.bibliotecasistema.Excecoes.LivrosNaoEncontradosException;
import com.br.ericcarv4lho.bibliotecasistema.Servicos.LivroServicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/livros"})
public class LivroController {
    @Autowired
    private LivroServicos livroServicos;

    public LivroController() {
    }

    @GetMapping({"/listar"})
    public ResponseEntity<Page<Livro>> ListarLivros(Pageable pageable) {
        Page<Livro> livros = this.livroServicos.listarLivros(pageable);
        if (livros.isEmpty()) {
            throw new LivrosNaoEncontradosException("Livros nao encontrados 1-1");
        } else {
            return ResponseEntity.ok(livros);
        }
    }

    @PostMapping({"/adicionar"})
    public ResponseEntity<Livro> adicionarLivro(@RequestBody Livro livro) {
        Livro novoLivro = this.livroServicos.adicionarLivro(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }
}