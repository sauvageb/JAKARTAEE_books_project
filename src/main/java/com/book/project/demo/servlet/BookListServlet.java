package com.book.project.demo.servlet;

import com.book.project.demo.dao.BookDao;
import com.book.project.demo.dao.entity.Book;
import com.book.project.demo.dao.entity.DaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/book-list")
public class BookListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDao dao = DaoFactory.getBookDao();
        List<Book> bookList = dao.findAll();

        req.setAttribute("books", bookList);
        req.getRequestDispatcher("/WEB-INF/book_list.jsp").forward(req, resp);
    }
}
