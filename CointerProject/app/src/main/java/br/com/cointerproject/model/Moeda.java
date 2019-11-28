package br.com.cointerproject.model;

import java.util.List;

import br.com.cointerproject.dao.Interfaces.IMoedaDao;
import br.com.cointerproject.dto.MoedaDTO;

public class Moeda extends Fonte {
    private double preco;
    private TipoMoeda tipoMoeda;
    private IMoedaDao iMoedaDao;

    public Moeda(String nome, double preco, TipoMoeda tipoMoeda, Mercado atuacao) {
        this.nome = nome;
        this.preco = preco;
        this.tipoMoeda = tipoMoeda;
        this.atuacao = atuacao;
    }

    //CRUD das moedas
    public void atualizar(MoedaDTO moeda){iMoedaDao.atualizar(moeda);};
    public void salvar(MoedaDTO moeda){iMoedaDao.salvar(moeda);};
    public void excluir(MoedaDTO moeda){iMoedaDao.excluir(moeda);};
    public List buscarPorId(MoedaDTO moeda){return iMoedaDao.buscarPorId(moeda);}
    public List listar(){return iMoedaDao.listar();}


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
}
