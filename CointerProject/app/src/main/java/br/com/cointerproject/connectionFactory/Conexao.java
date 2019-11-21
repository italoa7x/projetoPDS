package br.com.cointerproject.connectionFactory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class Conexao extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "base/db_cointer.db";
    private  static final int VERSAO_BANCO = 1;
    public static final String TBL_USUARIO= "usuario";
    public static final String TBL_INVESTIMENTO = "investimento";
    public static final String TBL_MOEDA = "moeda";


    public Conexao(@Nullable Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_usuario = "CREATE TABLE " + TBL_USUARIO +
                " ( nome text, email text, senha text, id integer autoincrement, primary key(id));";
        db.execSQL(sql_usuario);

        String sql_moeda = "CREATE TABLE " + TBL_MOEDA +
                " ( nome text, tipo integer, valor double, id integer autoincrement, primary key(id))";

        db.execSQL(sql_moeda);

        String sql_investimento = "CREATE TABLE " + TBL_INVESTIMENTO +
                " (nome text, id integer autoincrement, id_usuario integer not null, id_moeda integer not null, primary key(id)," +
                "foreign key(id_usuario) references usuario(id), foreign key(id_moeda) references moeda(id))";
        db.execSQL(sql_investimento);

        Toast.makeText(null, "Banco criado com sucesso!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
