package br.com.cointerproject.dto;

import java.util.List;

import br.com.cointerproject.model.Fonte;
import br.com.cointerproject.model.Mercado;
import br.com.cointerproject.model.TipoMoeda;

public class MoedaDTO extends Fonte {

    private double preco;
    private TipoMoeda tipoMoeda;

    private List moedas;

    public MoedaDTO(String nome, double preco, TipoMoeda tipoMoeda, Mercado atuacao) {
        this.nome = nome;
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
}
