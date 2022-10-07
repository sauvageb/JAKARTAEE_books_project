package com.book.project.demo.dao;

import com.book.project.demo.dao.entity.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll();
}
