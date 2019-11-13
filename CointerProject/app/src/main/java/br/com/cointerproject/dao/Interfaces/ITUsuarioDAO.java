package br.com.cointerproject.dao.Interfaces;

import java.util.Collection;

import br.com.cointerproject.model.Usuario;
import br.com.cointerproject.model.exceptions.ErroAoLogarException;
import br.com.cointerproject.model.exceptions.UsuarioNaoEncontradoException;

public interface ITUsuarioDAO {

    public Usuario salvar(Usuario u);

    public Collection<Usuario> listar();

    public Usuario excluir(Integer id) throws UsuarioNaoEncontradoException;

    public Usuario atualizar(Usuario novo) throws UsuarioNaoEncontradoException;

    public Usuario logarNoSistema(Usuario usuario) throws ErroAoLogarException;
}
