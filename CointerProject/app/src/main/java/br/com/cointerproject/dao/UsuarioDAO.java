package br.com.cointerproject.dao;

import javax.persistence.EntityManager;

import br.com.cointerproject.dto.UsuarioDTO;

public class UsuarioDAO extends FactoryEntity{

    private EntityManager entidade;

    public boolean salvar(UsuarioDTO obj) throws Exception {
        entidade = super.getIntity();
        entidade.getTransaction().begin();
        try {
            entidade.persist(obj);
            entidade.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entidade.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            entidade.close();
        }
    }
}
