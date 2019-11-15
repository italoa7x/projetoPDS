package br.com.cointerproject.model;

public class Moeda extends Fonte {
    private double preco;
    private TipoMoeda tipoMoeda;

    public Moeda(String nome, double preco, TipoMoeda tipoMoeda, Mercado atuacao) {
        this.nome = nome;
        this.preco = preco;
        this.tipoMoeda = tipoMoeda;
        this.atuacao = atuacao;
    }
}
