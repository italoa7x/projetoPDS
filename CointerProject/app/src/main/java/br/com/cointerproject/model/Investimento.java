package br.com.cointerproject.model;


import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
@IgnoreExtraProperties
public class Investimento implements Serializable {

    private String id;
    private String nome;
    private double valor;
    private String status;
    private String inicio;
    private String fim;
    private String moeda;
    private double lucro;


    public Investimento(){ }

    public Investimento(String nome, double valor, String moeda) {
        this.nome = nome;
        this.valor = valor;
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        inicio = form.format(data);
        this.status = Status.ATIVO.name();
        this.moeda = moeda;


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }
}
