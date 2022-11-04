package com.leodemetrio.hibernatejpa.dao;

import com.leodemetrio.hibernatejpa.modelo.Produto;

import javax.persistence.EntityManager;

public class ProdutoDao {

    private EntityManager entityManager;

    public ProdutoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Produto produto){
        this.entityManager.persist(produto);
    }
}
