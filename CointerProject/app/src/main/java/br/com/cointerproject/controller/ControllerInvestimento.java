package br.com.cointerproject.controller;

import java.util.List;

import br.com.cointerproject.dto.InvestimentoDTO;

import br.com.cointerproject.model.Investimento;

public class ControllerInvestimento {
    private Investimento investimentoModel;



    public void atualizar(InvestimentoDTO investimento){
        investimentoModel.atualizar(investimento);
    }

    public void salvar(InvestimentoDTO investimento){
        investimentoModel.salvar(investimento);
    }

    public void excluir(InvestimentoDTO investimento){
        investimentoModel.excluir(investimento);
    }

    public List buscarPorId(InvestimentoDTO investimento){
        return investimentoModel.buscarPorId(investimento);
    }
}
