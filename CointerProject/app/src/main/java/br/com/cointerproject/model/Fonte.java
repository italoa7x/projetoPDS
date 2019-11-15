package br.com.cointerproject.model;

public abstract class Fonte {
    protected Mercado atuacao;
    protected String nome;



    public Mercado getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(Mercado atuacao) {
        this.atuacao = atuacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
