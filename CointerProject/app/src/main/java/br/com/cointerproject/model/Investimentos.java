package br.com.cointerproject.model;

public class Investimentos {

    private String nome, fonteDeInvestimento;
    private double valor;
    int id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFonteDeInvestimento() {
        return fonteDeInvestimento;
    }

    public void setFonteDeInvestimento(String fonteDeInvestimento) {
        this.fonteDeInvestimento = fonteDeInvestimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
