package br.com.cointerproject.dao.Interfaces;

import java.util.Collection;

import br.com.cointerproject.dto.UsuarioDTO;
import br.com.cointerproject.model.Usuario;
import br.com.cointerproject.model.exceptions.ErroAoLogarException;
import br.com.cointerproject.model.exceptions.UsuarioNaoEncontradoException;

public interface ITUsuarioDAO {

    public boolean salvar(UsuarioDTO u);

    public boolean excluir(Integer id) throws UsuarioNaoEncontradoException;

    public boolean atualizar(UsuarioDTO novo) throws UsuarioNaoEncontradoException;

    public UsuarioDTO logarNoSistema(UsuarioDTO usuario) throws ErroAoLogarException;
}
