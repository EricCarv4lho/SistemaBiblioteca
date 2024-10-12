package com.br.ericcarv4lho.bibliotecasistema.Servicos;





import com.br.ericcarv4lho.bibliotecasistema.Entidades.Livro;
import com.br.ericcarv4lho.bibliotecasistema.Repositorios.LivroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LivroServicos {
    @Autowired
    private LivroRepositorio livroRepositorio;

    public LivroServicos() {
    }

    public Livro adicionarLivro(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("O Livro nao pode ser nulo");
        } else {
            return (Livro)this.livroRepositorio.save(livro);
        }
    }

    public Page<Livro> listarLivros(Pageable pageable) {
        Page<Livro> listaLivros = this.livroRepositorio.findAll(pageable);
        return listaLivros;
    }

    public Livro atualizarLivro(Livro livro) {
        Livro livroAtualizado = null;
        ((Livro)livroAtualizado).setTitulo(livro.getTitulo());
        ((Livro)livroAtualizado).setData(livro.getData());
        ((Livro)livroAtualizado).setPreco(livro.getPreco());
        return (Livro)this.livroRepositorio.save(livroAtualizado);
    }

    public void deletarLivro(Long codigo) {
        if (this.livroRepositorio.findById(codigo).isEmpty()) {
            throw new IllegalArgumentException("Livro nao encontrado com o codigo " + codigo);
        } else {
            this.livroRepositorio.deleteById(codigo);
        }
    }
}
