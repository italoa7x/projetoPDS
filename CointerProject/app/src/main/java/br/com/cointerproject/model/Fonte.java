package br.com.cointerproject.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class Fonte {
    @Enumerated(EnumType.STRING)
    protected Mercado atuacao;

    protected String nome;



    public Mercado getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(Mercado atuacao) {
        this.atuacao = atuacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
