package br.com.cointerproject.dto;

import java.util.Date;
import java.util.List;

import br.com.cointerproject.model.Fonte;
import br.com.cointerproject.model.Status;
import br.com.cointerproject.model.Usuario;

public class InvestimentoDTO {

    private String nome;
    private double valor;
    private Status status;
    private Date inicio;
    private Date fim;
    private List lucroDTO;
    private Fonte fonte;
    private UsuarioDTO usuario;

    public InvestimentoDTO(String nome, double valor, UsuarioDTO usuario) {
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

    public List getLucroDTO() {
        return lucroDTO;
    }

    public void setLucroDTO(List lucroDTO) {
        this.lucroDTO = lucroDTO;
    }

    public Fonte getFonte() {
        return fonte;
    }

    public void setFonte(Fonte fonte) {
        this.fonte = fonte;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
}
