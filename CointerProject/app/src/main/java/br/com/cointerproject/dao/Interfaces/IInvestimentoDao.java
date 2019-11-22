package br.com.cointerproject.dao.Interfaces;

import java.util.List;

import br.com.cointerproject.dto.InvestimentoDTO;


public interface IInvestimentoDao {

    public void atualizar(InvestimentoDTO investimento);
    public void salvar(InvestimentoDTO investimento);
    public void excluir(InvestimentoDTO investimento);
    public List buscarPorId(InvestimentoDTO investimento);
    public List listar();
}
