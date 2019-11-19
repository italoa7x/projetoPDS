package br.com.cointerproject.model;

import java.util.List;

import br.com.cointerproject.dao.ILucroDao;
import br.com.cointerproject.dto.LucroDTO;

public class Lucro {
    private double valor;
    private double percentual;
    private Investimento investimento;
    private ILucroDao iLucroDao;

    public Lucro(double valor, double percentual, Investimento investimento) {
        this.valor = valor;
        this.percentual = percentual;
        this.investimento = investimento;
    }

    public void atualizar(LucroDTO lucro) {iLucroDao.atualizar(lucro);}
    public void salvar(LucroDTO lucro){iLucroDao.salvar(lucro);}
    public void excluir(LucroDTO lucro){iLucroDao.excluir(lucro);}
    public List buscarPorId(LucroDTO lucro){return iLucroDao.buscarPorId(lucro);}
    public List listar(){return iLucroDao.listar();}

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
