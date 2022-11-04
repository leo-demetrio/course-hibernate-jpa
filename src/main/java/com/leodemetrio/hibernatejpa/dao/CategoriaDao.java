package com.leodemetrio.hibernatejpa.dao;

import com.leodemetrio.hibernatejpa.modelo.Categoria;
import com.leodemetrio.hibernatejpa.modelo.Produto;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria){
        this.entityManager.persist(categoria);
    }
    public void atualizar(Categoria categoria){
        this.entityManager.merge(categoria);
    }
    public void delete(Categoria categoria){
        Categoria cat = this.entityManager.merge(categoria);
        this.entityManager.remove(cat);
    }
}
