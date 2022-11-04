package com.leodemetrio.hibernatejpa.testes;

import com.leodemetrio.hibernatejpa.modelo.Produto;

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

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(celular);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
