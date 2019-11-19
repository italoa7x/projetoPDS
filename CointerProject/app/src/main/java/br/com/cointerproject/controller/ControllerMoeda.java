package br.com.cointerproject.controller;

import java.util.List;

import br.com.cointerproject.dto.MoedaDTO;
import br.com.cointerproject.model.Moeda;

public class ControllerMoeda {
    private Moeda moedaModel;

    public void atualizar(MoedaDTO moeda){moedaModel.atualizar(moeda);};
    public void salvar(MoedaDTO moeda){moedaModel.salvar(moeda);};
    public void excluir(MoedaDTO moeda){moedaModel.excluir(moeda);};
    public List buscarPorId(MoedaDTO moeda){return moedaModel.buscarPorId(moeda);}
    public List listar(){return moedaModel.listar();}
}
