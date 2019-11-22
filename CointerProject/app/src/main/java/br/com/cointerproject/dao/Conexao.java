package br.com.cointerproject.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class Conexao extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "cointer.db";
    private  static final int VERSAO_BANCO = 1;

    public Conexao(@Nullable Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_usuario = "CREATE TABLE usuario (nome VARCHAR(100), email VARCHAR(50), senha VARCHAR(50), id INTEGER PRIMARY KEY AUTOINCREMENT)";
        db.execSQL(sql_usuario);
        /**
        String sql_moeda = "CREATE TABLE moeda (valor DOUBLE, nome VARCHAR(100), tipo INTEGER, id INTEGER PRIMARY KEY AUTOINCREMENT )";

        db.execSQL(sql_moeda);

        String sql_investimento = "CREATE TABLE investimento (nome VARCHAR(50),  valor DOUBLE, status INTEGER NOT NULL," +
                "id_fonte INTEGER NOT NULL, data_inicio DATETIME DEFAULT (datetime('now','localtime')), data_fim DATETIME , id_usuario INTEGER NOT NULL," +
                "FOREIGN KEY (id_fonte) REFERENCES moeda (id), FOREIGN KEY (id_usuario) REFERENCES usuario(id))";
        db.execSQL(sql_investimento);

        System.out.println("Banco criado!");
         */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
