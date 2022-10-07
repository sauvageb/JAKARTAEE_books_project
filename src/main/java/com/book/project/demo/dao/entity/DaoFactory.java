package com.book.project.demo.dao.entity;

import com.book.project.demo.dao.BookDao;
import com.book.project.demo.dao.JpaBookDao;

public final class DaoFactory {

    private DaoFactory() {
    }

    public static BookDao getBookDao(){
        return new JpaBookDao();
    }
}
