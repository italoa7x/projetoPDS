package br.com.cointerproject.controller;

import java.util.List;

import br.com.cointerproject.dto.LucroDTO;
import br.com.cointerproject.model.Lucro;

public class ControllerLucro {
    private Lucro lucroModel;

    public void atualizar(LucroDTO lucro) {lucroModel.atualizar(lucro);}
    public void salvar(LucroDTO lucro){lucroModel.salvar(lucro);}
    public void excluir(LucroDTO lucro){lucroModel.excluir(lucro);}
    public List buscarPorId(LucroDTO lucro){return lucroModel.buscarPorId(lucro);}
    public List listar(){return lucroModel.listar();}

}
