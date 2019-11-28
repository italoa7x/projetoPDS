package br.com.cointerproject.model;

import java.util.List;


import br.com.cointerproject.model.Fonte;
import br.com.cointerproject.model.Mercado;
import br.com.cointerproject.model.TipoMoeda;
public class Moeda extends Fonte {

    private double preco;

    private TipoMoeda tipoMoeda;
    private String nome;
    private List moedas;

    public Moeda(String nome, double preco, TipoMoeda tipoMoeda, Mercado atuacao) {
        this.setNome(nome);
        this.preco = preco;
        this.tipoMoeda = tipoMoeda;
        this.atuacao = atuacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public TipoMoeda getTipoMoeda() {
        return tipoMoeda;
    }

    public void setTipoMoeda(TipoMoeda tipoMoeda) {
        this.tipoMoeda = tipoMoeda;
    }

    public List getMoedas() {
        return moedas;
    }

    public void setMoedas(List moedas) {
        this.moedas = moedas;
    }


    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
}
