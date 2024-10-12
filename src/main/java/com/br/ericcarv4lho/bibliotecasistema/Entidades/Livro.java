package com.br.ericcarv4lho.bibliotecasistema.Entidades;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Generated;

@Entity
@Table(
        name = "livros"
)
public class Livro {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long Codigo;
    private String titulo;
    private LocalDate data;
    private double preco;

    @Generated
    public Long getCodigo() {
        return this.Codigo;
    }

    @Generated
    public String getTitulo() {
        return this.titulo;
    }

    @Generated
    public LocalDate getData() {
        return this.data;
    }

    @Generated
    public double getPreco() {
        return this.preco;
    }

    @Generated
    public void setCodigo(final Long Codigo) {
        this.Codigo = Codigo;
    }

    @Generated
    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }

    @Generated
    public void setData(final LocalDate data) {
        this.data = data;
    }

    @Generated
    public void setPreco(final double preco) {
        this.preco = preco;
    }

    @Generated
    public Livro(final Long Codigo, final String titulo, final LocalDate data, final double preco) {
        this.Codigo = Codigo;
        this.titulo = titulo;
        this.data = data;
        this.preco = preco;
    }

    @Generated
    public Livro() {
    }
}
