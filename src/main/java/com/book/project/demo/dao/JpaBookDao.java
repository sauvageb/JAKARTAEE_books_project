package com.book.project.demo.dao;

import com.book.project.demo.dao.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class JpaBookDao implements BookDao {

    @Override
    public List<Book> findAll() {
        EntityManagerFactory emf = PersistenceManager.getEMF();
        EntityManager em = emf.createEntityManager();
        List<Book> bookList = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        em.close();
        return bookList;
    }


}
