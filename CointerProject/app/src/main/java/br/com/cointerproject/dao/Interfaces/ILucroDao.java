package br.com.cointerproject.dao.Interfaces;

import java.util.List;

import br.com.cointerproject.dto.LucroDTO;


public interface ILucroDao {

    public void atualizar(LucroDTO lucro);
    public void salvar(LucroDTO lucro);
    public void excluir(LucroDTO lucro);
    public List buscarPorId(LucroDTO lucro);
    public List listar();
}
