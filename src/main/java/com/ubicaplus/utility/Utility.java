package com.ubicaplus.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Utility {

    public static Session getSession(final SessionFactory sessionFactory) {
        return sessionFactory.getCurrentSession();
    }

    public static Transaction beginTransaction(final SessionFactory sessionFactory) {
        return getSession(sessionFactory).beginTransaction();
    }

    public static void commitTransaction(final SessionFactory sessionFactory) {
        getSession(sessionFactory).getTransaction().commit();
    }

    public static void rollbackTransaction(final SessionFactory sessionFactory) {
        getSession(sessionFactory).getTransaction().rollback();
    }

    public static String getStringFromException(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        String exception = sw.toString();

        return exception;
    }
}
