package br.com.cointerproject.controller;

import br.com.cointerproject.controller.exceptions.ErroAoLogarException;
import br.com.cointerproject.model.Usuario;

public class ControllerUsuario {

    public Usuario logar(String email, String senha) throws ErroAoLogarException {
        Usuario u = new Usuario();
        u.setEmail(email);
        u.setSenha(senha);
        return u;
    }
}
