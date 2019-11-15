package br.com.cointerproject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.cointerproject.dao.IInvestimentoDao;
import br.com.cointerproject.dto.InvestimentoDTO;

public class Investimento {
    private String nome;
    private double valor;
    private Status status;
    private Date inicio;
    private Date fim;
    private List lucro;
    private Fonte fonte;
    private Usuario usuario;
    private IInvestimentoDao investimentoDao;
    public Investimento(String nome, double valor, Usuario usuario) {
        this.nome = nome;
        this.valor = valor;
        this.usuario = usuario;
    }



    public void atualizar(InvestimentoDTO investimento){
        investimentoDao.atualizar(investimento);
    }

    public void salvar(InvestimentoDTO investimento){
        investimentoDao.salvar(investimento);
    }

    public void excluir(InvestimentoDTO investimento){
        investimentoDao.excluir(investimento);
    }

    public List buscarPorId(InvestimentoDTO investimento){
        return investimentoDao.buscarPorId(investimento);
    }

    public List listar(){
        return investimentoDao.listar();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public List getLucro() {
        return lucro;
    }

    public void setLucro(List lucro) {
        this.lucro = lucro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Fonte getFonte() {
        return fonte;
    }

    public void setFonte(Fonte fonte) {
        this.fonte = fonte;
    }
}
