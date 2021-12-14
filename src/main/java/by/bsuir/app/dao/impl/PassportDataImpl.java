package by.bsuir.app.dao.impl;

import by.bsuir.app.dao.PassportDataDao;
import by.bsuir.app.entity.PassportData;
import by.bsuir.app.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class PassportDataImpl implements PassportDataDao {
    private static Session session;

    @Override
    public List<PassportData> findAll() {
        List<PassportData> passportData = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            passportData = session.createQuery("SELECT a FROM PassportData a", PassportData.class).getResultList();
            session.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return passportData;
    }

    @Override
    public Optional<PassportData> findById(Long id) {
        Optional<PassportData> bs = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            bs = Optional.of(session.load(PassportData.class, id));
            session.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return bs;
    }

    @Override
    public boolean delete(PassportData passportData) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(PassportData passportData) {
        return false;
    }
}
