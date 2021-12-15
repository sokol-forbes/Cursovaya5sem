package by.bsuir.app.dao.impl;

import by.bsuir.app.dao.ContractDao;
import by.bsuir.app.dao.CreditDao;
import by.bsuir.app.entity.Contract;

import by.bsuir.app.exception.DAOException;
import by.bsuir.app.exception.EmptyObjectException;
import by.bsuir.app.util.HibernateUtil;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Optional;
@Log4j2
public class ContractDaoImpl implements ContractDao {
    private  static Session session;
    private static final String FIND_ALL_CONTRACTS_GROUPED_BY_QUANTITY = "SELECT contract_name as contract, sum(quantity) as " +
            "quantity FROM contract group " +
            "by contract_name";

    @Override
    public List<Contract> findAll() {
        List<Contract> contracts = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        contracts = session.createQuery("SELECT a FROM Contract a",Contract.class).getResultList();
        session.close();
        return contracts;
    }

    @Override
    public Optional<Contract> findById(Long id) {
        Optional<Contract> bs = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            bs = Optional.of(session.load(Contract.class,id));
            session.close();
        }catch (Throwable e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Contract contract) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Contract contract) {
        try {
            if(contract == null)
                throw new EmptyObjectException();
            if(contract.getCredit().getId() == null){
                CreditDao creditDao = new CreditDaoImpl();

                contract.setCredit(creditDao.findByCreditName(contract.getCredit().getName()));
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(contract);
            session.getTransaction().commit();
            session.close();
        }catch (EmptyObjectException e){
            return false;
        }
        return true;
    }

    @Override
    public List<Contract> findAllByField(String field) throws DAOException {
        return null;
    }

    @Override
    public List<Object[]> findAllGroupedByQuantity() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery(FIND_ALL_CONTRACTS_GROUPED_BY_QUANTITY);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public boolean deleteByUserId(Long id) {
        Optional<Contract> contract = findByUserId(id);
        try{
            if(contract.isEmpty())
                throw new EmptyObjectException();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(contract);
            session.close();
        }catch (EmptyObjectException e){
            return false;
        }
        return true;
    }

    @Override
    public Optional<Contract> findByUserId(Long id) {
        Optional <Contract> contract = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Contract.class);
            contract = Optional.ofNullable((Contract) criteria.add(Restrictions.eq("user_id",id)).uniqueResult());
            session.close();
        }catch (Throwable e){
            log.error(e.getMessage());
            e.printStackTrace();
            return contract;
        }
        return contract;
    }

    @Override
    public boolean save(Contract contract) {
        try{
            if(contract ==null)throw new EmptyObjectException();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(contract);
            session.getTransaction().commit();
            session.close();
        }catch (EmptyObjectException e) {
            return false;
        }
        return true;
    }
}
