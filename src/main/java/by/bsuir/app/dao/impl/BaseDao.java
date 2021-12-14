package by.bsuir.app.dao.impl;

import by.bsuir.app.util.HibernateUtil;
import org.hibernate.Session;

public class BaseDao {
    private static Session session;
    private static final String CLEAR_TABLE = "DELETE FROM %s";


    public int hqlTruncate(String myTable){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.createSQLQuery("truncate table bank").executeUpdate();

        session.getTransaction().commit();
        session.close();

        return 1;
    }
}
