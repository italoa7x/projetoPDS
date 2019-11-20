package br.com.cointerproject.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.cointerproject.model.Status;

@Entity
@Table(name = "investimento")
public class InvestimentoDTO {
    @Id //notação responsável pelo ID e auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private double valor;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Temporal(TemporalType.DATE) //Notação para data
    private Date inicio;
    @Temporal(TemporalType.DATE)
    private Date fim;

    @OneToMany(mappedBy =  "investimento",cascade = CascadeType.ALL,orphanRemoval = true) // cardinalidade 1 para n
    private List lucro;

    @ManyToOne // cardinalidade n para 1
    private MoedaDTO fonte;

    @ManyToOne
    private UsuarioDTO usuario;

    @Transient //Atributo a ser ignorado
    private List investimentos;

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

    public List getLucro() {
        return lucro;
    }

    public void setLucro(List lucroDTO) {
        this.lucro = lucroDTO;
    }

    public MoedaDTO getFonte() {
        return fonte;
    }

    public void setFonte(MoedaDTO fonte) {
        this.fonte = fonte;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
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
