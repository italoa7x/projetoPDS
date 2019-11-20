package br.com.cointerproject.dto;

import java.util.Date;
import java.util.List;


public class LucroDTO {
    private int id;

    private double valor;
    private double percentual;
    private Date data;

    private InvestimentoDTO investimentoDTO;

    private List lucros;


    public LucroDTO(double valor, double percentual, InvestimentoDTO investimentoDTO) {
        this.valor = valor;
        this.percentual = percentual;
        this.investimentoDTO = investimentoDTO;
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

    public InvestimentoDTO getInvestimentoDTO() {
        return investimentoDTO;
    }

    public void setInvestimentoDTO(InvestimentoDTO investimentoDTO) {
        this.investimentoDTO = investimentoDTO;
    }

    public List getLucros() {
        return lucros;
    }

    public void setLucros(List lucros) {
        this.lucros = lucros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
