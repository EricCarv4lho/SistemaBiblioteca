package com.br.ericcarv4lho.bibliotecasistema.Excecoes;




public class LivrosNaoEncontradosException extends RuntimeException {
    public LivrosNaoEncontradosException(String mensagem) {

        super(mensagem);
    }
}
