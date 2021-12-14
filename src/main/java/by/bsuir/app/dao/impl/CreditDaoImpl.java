package by.bsuir.app.dao.impl;

import by.bsuir.app.dao.CreditDao;
import by.bsuir.app.entity.Credit;
import by.bsuir.app.exception.EmptyObjectException;
import by.bsuir.app.util.HibernateUtil;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import java.util.List;
import java.util.Optional;
@Log4j2
public class CreditDaoImpl implements CreditDao {
    private static Session session;
    @Override
    public List<Credit> findAll() {
        List <Credit> credits = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction();
        credits = session.createQuery("SELECT a FROM Credit a",Credit.class).getResultList();

        session.close();
        return credits;
    }

    @Override
    public Optional<Credit> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Credit credit) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Credit credit) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            if(credit == null)
                throw new EmptyObjectException();
            session.saveOrUpdate(credit);
            session.close();
        }catch (EmptyObjectException e)
        {session.close();
        return false;}
    }

    @Override
    public Credit findByCreditName(String name) {
       Credit credit = null;
       try{
           session = HibernateUtil.getSessionFactory().openSession();
           Criteria criteria = session.createCriteria(Credit.class);
           credit = (Credit) criteria.add(Restrictions.eq("name",name)).uniqueResult();
           session.close();
       } catch (Throwable e) {
           log.error(e.getMessage());
           e.printStackTrace();
       }
       return credit;
    }
}
