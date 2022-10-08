package com.ubicaplus.dao;

import com.ubicaplus.model.UbicaDetail;
import com.ubicaplus.utility.Utility;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * Data Access Object
 */
@Repository("ubicaDao")
public class UbicaDao {

    private final SessionFactory sessionFactory;

    public UbicaDao(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(final UbicaDetail detail) {
        try {
            Utility.beginTransaction(sessionFactory);
            Utility.getSession(sessionFactory).persist(detail);
            Utility.commitTransaction(sessionFactory);
        } catch (final Throwable t) {
            t.printStackTrace();
            Utility.rollbackTransaction(sessionFactory);
            throw t;
        }
    }
}
