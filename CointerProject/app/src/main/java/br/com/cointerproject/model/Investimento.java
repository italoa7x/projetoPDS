package br.com.cointerproject.model;

import java.util.Date;
import java.util.List;

public class Investimento {

    private int id;

    private String nome;
    private double valor;


    private Status status;

    private Date inicio;
    private Date fim;

    private List lucro;

    private Moeda fonte;

    private Usuario usuario;

    private List investimentos;

    public Investimento(String nome, double valor, Usuario usuario) {
        this.nome = nome;
        this.valor = valor;
        this.usuario = usuario;
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

    public void setLucro(List lucroDTO) {
        this.lucro = lucroDTO;
    }

    public Moeda getFonte() {
        return fonte;
    }

    public void setFonte(Moeda fonte) {
        this.fonte = fonte;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List getInvestimentos() {
        return investimentos;
    }

    public void setInvestimentos(List investimentos) {
        this.investimentos = investimentos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
