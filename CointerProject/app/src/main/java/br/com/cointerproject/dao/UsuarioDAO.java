package br.com.cointerproject.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.Collection;

import br.com.cointerproject.connectionFactory.Conexao;
import br.com.cointerproject.dao.Interfaces.ITUsuarioDAO;
import br.com.cointerproject.dto.UsuarioDTO;
import br.com.cointerproject.model.Usuario;
import br.com.cointerproject.model.exceptions.ErroAoLogarException;
import br.com.cointerproject.model.exceptions.UsuarioNaoEncontradoException;

public class UsuarioDAO implements ITUsuarioDAO {

    private SQLiteDatabase db;
    private Conexao conexao;

    public UsuarioDAO(Context context){
        conexao = new Conexao(context);
        db = conexao.getWritableDatabase();
    }

    @Override
    public UsuarioDTO salvar(UsuarioDTO u) {
        ContentValues valores = new ContentValues();
        valores.put("nome", u.getNome());
        valores.put("email", u.getEmail());
        valores.put("senha", u.getSenha());

        Long retorno = db.insert(conexao.TBL_USUARIO, null, valores);
        if(retorno != -1){
            return u;
        }else{
            return null;
        }
    }

    @Override
    public UsuarioDTO excluir(Integer id) throws UsuarioNaoEncontradoException {
        return null;
    }

    @Override
    public UsuarioDTO atualizar(UsuarioDTO novo) throws UsuarioNaoEncontradoException {
        return null;
    }

    @Override
    public UsuarioDTO logarNoSistema(UsuarioDTO usuario) throws ErroAoLogarException {
        return null;
    }
}