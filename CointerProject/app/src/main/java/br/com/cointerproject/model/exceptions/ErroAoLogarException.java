package br.com.cointerproject.model.exceptions;

public class ErroAoLogarException extends Exception {
    public ErroAoLogarException() {
        super("Usuário não encontrado!");
    }
}
