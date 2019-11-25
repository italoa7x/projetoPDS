package br.com.cointerproject.controller;

import android.content.Context;

import br.com.cointerproject.dto.UsuarioDTO;
import br.com.cointerproject.model.exceptions.ErroAoLogarException;
import br.com.cointerproject.model.Usuario;

public class ControllerUsuario {

    private final Usuario usuario;

    public ControllerUsuario(Context context){
        usuario = new Usuario(context);
    }
    // Esse metodo recebe o objeto usuario com o email e senha preenchido e manda para o model onde lá é feito a lógica de mandar para a classe responsável
    // de acessar o banco.
    public UsuarioDTO logar(UsuarioDTO user) throws ErroAoLogarException {
        return usuario.logarNoSistema(user);
    }

    // O método abaixo recebe um objeto DTO popular direto da view e manda para o model.
    public UsuarioDTO salvar(UsuarioDTO user){
        return usuario.salvar(user);
    }
}
