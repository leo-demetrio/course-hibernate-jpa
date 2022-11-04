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
}
