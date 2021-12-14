package by.bsuir.app.dao;


import by.bsuir.app.entity.Credit;

public interface CreditDao extends BaseDao<Long, Credit>{
    Credit findByCreditName(String name);
}
