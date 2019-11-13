package br.com.cointerproject.controller.exceptions;

public class ErroAoLogarException extends Exception {
    public ErroAoLogarException() {
        super("Usuário não encontrado!");
    }
}
