package com.leodemetrio.hibernatejpa.dao;

import com.leodemetrio.hibernatejpa.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {

    private EntityManager entityManager;

    public ProdutoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Produto produto){
        this.entityManager.persist(produto);
    }
    public Produto buscarPorId(Long id){
        return entityManager.find(Produto.class, id);
    }
    public List<Produto> buscarTodos(){
        String queryJPQL = "SELECT p FROM Produto as p";
        return  entityManager.createQuery(queryJPQL, Produto.class).getResultList();
    }
    public List<Produto> buscarPorNome(String nome){
        String queryJPQL = "SELECT p FROM Produto as p WHERE p.nome = :nome";
        return  entityManager
                .createQuery(queryJPQL, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }
    public List<Produto> buscarPorNomeDaCategoria(String nome){
        String queryJPQL = "SELECT p FROM Produto as p WHERE p.categoria.nome = :nome";
        return  entityManager
                .createQuery(queryJPQL, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }
    public BigDecimal buscarPrecoPorNome(String nome){
        String queryJPQL = "SELECT p.preco FROM Produto as p WHERE p.nome = :nome";
        return  entityManager
                .createQuery(queryJPQL, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }
}
