package br.com.cointerproject.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.cointerproject.dao.Interfaces.ITUsuarioDAO;
import br.com.cointerproject.dto.UsuarioDTO;
import br.com.cointerproject.model.exceptions.ErroAoLogarException;
import br.com.cointerproject.model.exceptions.UsuarioNaoEncontradoException;

public class UsuarioDAO implements ITUsuarioDAO{

    private SQLiteDatabase db;
    private static final String TBL = "usuario";
    private Conexao conexao;

    public UsuarioDAO(Context context){
        conexao = new Conexao(context);
    }

    @Override
    public boolean salvar(UsuarioDTO u) {
        db = conexao.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nome", u.getNome());
        valores.put("email", u.getEmail());
        valores.put("senha", u.getSenha());

        Long retorno = db.insert(TBL, null, valores);
        if(retorno == -1){
            return false;
        }else{
            return true;
        }
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
        db = conexao.getWritableDatabase();
        String sql = "SELECT *FROM "+TBL+ " WHERE email = ? AND senha = ?";
        String[] args = new String[]{usuario.getEmail(), usuario.getSenha()};
        Cursor cursor = db.rawQuery(sql, args);
        cursor.moveToFirst();
        return criarUsuario(cursor);
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