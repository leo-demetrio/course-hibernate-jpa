package com.leodemetrio.hibernatejpa.testes;

import com.leodemetrio.hibernatejpa.dao.CategoriaDao;
import com.leodemetrio.hibernatejpa.dao.ProdutoDao;
import com.leodemetrio.hibernatejpa.modelo.Categoria;
import com.leodemetrio.hibernatejpa.modelo.Produto;
import com.leodemetrio.hibernatejpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class CadastroProduto {
    public static void main(String[] args) {
        cadastroProduto();
        Long id = 1L;
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        Produto p = produtoDao.buscarPorId(id);
        System.out.println(p.getDescricao());
        List<Produto> ps = produtoDao.buscarTodos();
        ps.forEach(pr -> System.out.println(pr.getNome()));
        List<Produto> porNome = produtoDao.buscarPorNome("Sansung");
        porNome.forEach(pn -> System.out.println(pn.getDescricao() + "*********************************"));
        List<Produto> porNomeDaCategoria = produtoDao.buscarPorNomeDaCategoria("celulares");
        System.out.println("=====================================");
        System.out.println(porNomeDaCategoria);
        porNomeDaCategoria.forEach(pnc -> System.out.println(pnc.getDescricao() + "*********************************"));
        BigDecimal b = produtoDao.buscarPrecoPorNome("Sansung");
        System.out.println(b);
    }

    private static void cadastroProduto() {
        Categoria cel = new Categoria("Celular");
        Produto celular = new Produto("Sansung","Celular Top",new BigDecimal("900.00"), cel);
        celular.setNome("Sansung");
        celular.setDescricao("Celular Top");
        celular.setPreco(new BigDecimal("900.00"));


        EntityManager entityManager = JPAUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(cel);
        produtoDao.cadastrar(celular);
        cel.setNome("celulares");
        categoriaDao.atualizar(cel);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
