package by.bsuir.app.dao;

import by.bsuir.app.entity.User;

import java.util.List;

public interface UserDao extends BaseDao<Long, User>{
    List<User> findAllByCriteria(String field);


}
