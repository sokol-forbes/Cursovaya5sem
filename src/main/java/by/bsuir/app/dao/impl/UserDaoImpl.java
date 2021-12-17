package by.bsuir.app.dao.impl;

import by.bsuir.app.dao.UserDao;
import by.bsuir.app.entity.Account;
import by.bsuir.app.entity.User;
import by.bsuir.app.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private static Session session;
    @Override
    public List<User> findAll() {
        List<User> users = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            users = session.createQuery("SELECT a FROM User a", User.class).getResultList();
            session.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
            Optional<User> bs = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                bs = Optional.of(session.load(User.class, id));
                session.close();
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return bs;
    }

    @Override
    public boolean delete(User user) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            session.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<User> user = findById(id);
        try {
            user.ifPresent(this::delete);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean saveOrUpdate(User user) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<User> findAllByCriteria(String field) {
        return null;
    }

    @Override
    public boolean registration(User user) {
        return false;
    }

}
