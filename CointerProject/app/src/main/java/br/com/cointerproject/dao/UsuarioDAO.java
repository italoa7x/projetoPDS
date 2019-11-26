package br.com.cointerproject.dao;

import android.content.Context;
import android.database.Cursor;

import com.google.firebase.auth.FirebaseAuth;

import br.com.cointerproject.dao.Interfaces.ITUsuarioDAO;
import br.com.cointerproject.dto.UsuarioDTO;
import br.com.cointerproject.model.exceptions.ErroAoLogarException;
import br.com.cointerproject.model.exceptions.UsuarioNaoEncontradoException;

public class UsuarioDAO implements ITUsuarioDAO{

    private Conexao conexao;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener listener;


    public UsuarioDAO(Context context){
        conexao = new Conexao(context);
    }

    @Override
    public boolean salvar(UsuarioDTO u) {
        return true;

    }

    @Override
    public boolean excluir(Integer id) throws UsuarioNaoEncontradoException {
        return false;
    }

    @Override
    public boolean atualizar(UsuarioDTO novo) throws UsuarioNaoEncontradoException {
        return false;
    }

    @Override
    public UsuarioDTO logarNoSistema(UsuarioDTO usuario) throws ErroAoLogarException {
        auth.signInWithEmailAndPassword(usuario.getEmail(),usuario.getSenha());

        return null;

    }

    private UsuarioDTO criarUsuario(Cursor cursor){
        if(cursor.getCount() == 0){
            return null;
        }else{
            UsuarioDTO usuario = new UsuarioDTO();
            usuario.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            usuario.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            usuario.setSenha(cursor.getString(cursor.getColumnIndex("senha")));
            return usuario;
        }
    }
}