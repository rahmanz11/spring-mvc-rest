package com.ubicaplus.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Utility class to handle database sessions
 */
public class Utility {

    /**
     * Gets/Initiates the database session
     * @param sessionFactory
     * @return
     */
    public static Session getSession(final SessionFactory sessionFactory) {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Begins a transaction
     * @param sessionFactory
     * @return
     */
    public static Transaction beginTransaction(final SessionFactory sessionFactory) {
        return getSession(sessionFactory).beginTransaction();
    }

    /**
     * Commits the transaction
     * @param sessionFactory
     */
    public static void commitTransaction(final SessionFactory sessionFactory) {
        getSession(sessionFactory).getTransaction().commit();
    }

    /**
     * Rollbacks the transactions
     * @param sessionFactory
     */
    public static void rollbackTransaction(final SessionFactory sessionFactory) {
        getSession(sessionFactory).getTransaction().rollback();
    }

    /**
     * Graceful way to print exception stacktrace message
     * @param e
     * @return
     */
    public static String getStringFromException(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        String exception = sw.toString();

        return exception;
    }
}
