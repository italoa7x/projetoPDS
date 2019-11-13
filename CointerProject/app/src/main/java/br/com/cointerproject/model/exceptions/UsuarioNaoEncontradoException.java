package br.com.cointerproject.model.exceptions;

public class UsuarioNaoEncontradoException extends Exception {
    public UsuarioNaoEncontradoException(){
        super("Usuário não encontrado.");
    }
}
