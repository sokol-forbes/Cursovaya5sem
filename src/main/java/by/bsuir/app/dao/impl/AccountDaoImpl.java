package by.bsuir.app.dao.impl;

import by.bsuir.app.dao.AccountDao;
import by.bsuir.app.entity.Account;
import by.bsuir.app.entity.enums.Role;
import by.bsuir.app.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class AccountDaoImpl implements AccountDao {
    private static Session session;

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Optional<Account> findById(Long id) {
        Optional<Account> bs = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            bs = Optional.of(session.load(Account.class, id));
            session.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return bs;
    }

    @Override
    public boolean delete(Account account) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Account account) {
        return false;
    }


    @Override
    public Role auth(Account account) {
        return null;
    }

    @Override
    public Account findByLogin(String login) {
        return null;
    }

    @Override
    public List<Account> findAllByCriteria(String field) {
        return null;
    }


    @Override
    public boolean registration(Account account) {
        return false;
    }
}
