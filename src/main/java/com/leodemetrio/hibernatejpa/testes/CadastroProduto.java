package com.leodemetrio.hibernatejpa.testes;

import com.leodemetrio.hibernatejpa.dao.ProdutoDao;
import com.leodemetrio.hibernatejpa.modelo.Produto;
import com.leodemetrio.hibernatejpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroProduto {
    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Sansung");
        celular.setDescricao("Celular Top");
        celular.setPreco(new BigDecimal("900.00"));


        EntityManager entityManager = JPAUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(entityManager);

        entityManager.getTransaction().begin();
        produtoDao.cadastrar(celular);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
