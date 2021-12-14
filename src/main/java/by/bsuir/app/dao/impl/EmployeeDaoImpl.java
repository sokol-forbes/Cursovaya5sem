package by.bsuir.app.dao.impl;

import by.bsuir.app.dao.EmployeeDao;
import by.bsuir.app.entity.Employee;
import by.bsuir.app.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class EmployeeDaoImpl implements EmployeeDao {
    private static Session session;

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        Optional<Employee> bs =null;
        try{session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            bs = Optional.of(session.load(Employee.class, id));
            session.close();
        }catch (Throwable e){
            e.printStackTrace();
        }
        return bs;
    }

    @Override
    public boolean delete(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Employee employee) {
        return false;
    }
}
