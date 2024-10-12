package com.br.ericcarv4lho.bibliotecasistema.Entidades;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;

@Entity
public class Autor {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String nome;
    private String nacionalidade;
    private String biografia;
    @OneToMany
    private List<Livro> livros = new ArrayList();

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public String getNome() {
        return this.nome;
    }

    @Generated
    public String getNacionalidade() {
        return this.nacionalidade;
    }

    @Generated
    public String getBiografia() {
        return this.biografia;
    }

    @Generated
    public List<Livro> getLivros() {
        return this.livros;
    }

    @Generated
    public void setId(final Long id) {
        this.id = id;
    }

    @Generated
    public void setNome(final String nome) {
        this.nome = nome;
    }

    @Generated
    public void setNacionalidade(final String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Generated
    public void setBiografia(final String biografia) {
        this.biografia = biografia;
    }

    @Generated
    public void setLivros(final List<Livro> livros) {
        this.livros = livros;
    }

    @Generated
    public Autor() {
    }

    @Generated
    public Autor(final Long id, final String nome, final String nacionalidade, final String biografia, final List<Livro> livros) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.biografia = biografia;
        this.livros = livros;
    }
}
