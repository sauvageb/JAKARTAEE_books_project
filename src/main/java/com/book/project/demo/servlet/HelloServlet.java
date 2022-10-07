package com.book.project.demo.servlet;

import com.book.project.demo.dao.PersistenceManager;
import com.book.project.demo.dao.entity.Author;
import com.book.project.demo.dao.entity.Book;
import com.book.project.demo.dao.entity.Illustrator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(value = "/populate")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EntityManagerFactory emf = PersistenceManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        // queries
        et.begin();

        Book book1 = new Book("Les 5 blessures qui empêchent d'être soi-même");
        book1.setAuthor(new Author("Lise", "Bourbeau", LocalDate.of(1941, 2, 14)));
        Illustrator illustrator1 = new Illustrator("Illustrator 1", "Lastname1", "Impressionniste Allemand");
        Illustrator illustrator2 = new Illustrator("Illustrator 2", "Lastname2", "BD");
        book1.addIllustrator(illustrator1);
        book1.addIllustrator(illustrator2);

        em.persist(book1);

        Book book2 = new Book("La voix de la connaissance");
        book2.setAuthor(new Author("Miguel", "Ruiz", LocalDate.of(1952, 8, 27)));
        em.persist(book2);

        et.commit();

        em.close();

        resp.getWriter().println("Populate DB");
    }
}
