package br.com.cointerproject.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "lucro")
public class LucroDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double valor;
    private double percentual;
    @Temporal(TemporalType.DATE)
    private Date data;

    @ManyToOne(fetch = FetchType.EAGER)
    private InvestimentoDTO investimentoDTO;

    @Transient
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
