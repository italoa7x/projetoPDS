package br.com.cointerproject.model;

import java.util.Objects;

import br.com.cointerproject.dao.UsuarioDAO;
import br.com.cointerproject.model.exceptions.ErroAoLogarException;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private String dataNasc;
    private Integer id;
    private UsuarioDAO usuarioDAO;

    public Usuario(){
        usuarioDAO = new UsuarioDAO();
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDataNasc(String dataNasc) { this.dataNasc = dataNasc; }

    public String getDataNasc() { return dataNasc; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return "Nome: "+this.getNome()+"\nLogin: "+this.getEmail()+"\nSenha: "+this.getSenha();
    }

    // Criei esse método para poder receber um objeto Usuario populado com email e senha, assim eu passo ele para a classe usuarioDAO e faço a verificação
    // se ele está no banco de dados e o retorno em seguida para a tela de login.
    public Usuario logarNoSistema(Usuario user) throws ErroAoLogarException {
        return usuarioDAO.logarNoSistema(user);
    }


}
