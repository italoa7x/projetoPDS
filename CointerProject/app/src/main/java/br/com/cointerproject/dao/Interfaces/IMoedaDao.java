package br.com.cointerproject.dao.Interfaces;

import java.util.List;

import br.com.cointerproject.dto.MoedaDTO;

public interface IMoedaDao {

    public void atualizar(MoedaDTO moeda);
    public void salvar(MoedaDTO moeda);
    public void excluir(MoedaDTO moeda);
    public List buscarPorId(MoedaDTO moeda);
    public List listar();



}
