package br.com.cointerproject.dao;

import java.util.Collection;

import br.com.cointerproject.dao.Interfaces.ITUsuarioDAO;
import br.com.cointerproject.model.Usuario;
import br.com.cointerproject.model.exceptions.ErroAoLogarException;
import br.com.cointerproject.model.exceptions.UsuarioNaoEncontradoException;

public class UsuarioDAO implements ITUsuarioDAO {

    @Override
    public Usuario salvar(Usuario u) {
        return null;
    }

    @Override
    public Collection<Usuario> listar() {
        return null;
    }

    @Override
    public Usuario excluir(Integer id) throws UsuarioNaoEncontradoException {
        return null;
    }

    @Override
    public Usuario atualizar(Usuario novo) throws UsuarioNaoEncontradoException {
        return null;
    }

    @Override
    public Usuario logarNoSistema(Usuario usuario) throws ErroAoLogarException {
        return null;
    }
}