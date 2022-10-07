package com.book.project.demo.dao;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class PersistenceManager {

    private static EntityManagerFactory EMF;

    private PersistenceManager() {
    }

    public static EntityManagerFactory getEMF() {
        if (EMF == null) {
            EMF = Persistence.createEntityManagerFactory("PU");
        }

        return EMF;
    }

    public static void close() {
        if (EMF != null && EMF.isOpen()) {
            EMF.close();
        }
    }
}
