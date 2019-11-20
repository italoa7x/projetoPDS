package br.com.cointerproject.controller;

import br.com.cointerproject.model.*;
import br.com.cointerproject.model.exceptions.*;

public class ControllerUsuario {

    private final Usuario usuario;

    public ControllerUsuario(){
        usuario = new Usuario();
    }
    // Esse metodo recebe o objeto usuario com o email e senha preenchido e manda para o model onde lá é feito a lógica de mandar para a classe responsável
    // de acessar o banco.
    public Usuario logar(Usuario user) throws ErroAoLogarException {
        return usuario.logarNoSistema(user);
    }
}
