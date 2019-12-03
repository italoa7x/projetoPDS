package br.com.cointerproject.model;

import java.util.List;



public class Moeda  {
    private TipoMoeda tipoMoeda;
    private String nome;


    public Moeda(String nome, TipoMoeda tipoMoeda) {
        this.nome = nome;
        this.tipoMoeda = tipoMoeda;

    }



    public TipoMoeda getTipoMoeda() {
        return tipoMoeda;
    }

    public void setTipoMoeda(TipoMoeda tipoMoeda) {
        this.tipoMoeda = tipoMoeda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
