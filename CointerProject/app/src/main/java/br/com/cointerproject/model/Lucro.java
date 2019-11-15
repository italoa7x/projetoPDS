package br.com.cointerproject.model;

public class Lucro {
    private double valor;
    private double percentual;
    private Investimento investimento;

    public Lucro(double valor, double percentual, Investimento investimento) {
        this.valor = valor;
        this.percentual = percentual;
        this.investimento = investimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }

    public Investimento getInvestimento() {
        return investimento;
    }

    public void setInvestimento(Investimento investimento) {
        this.investimento = investimento;
    }
}
