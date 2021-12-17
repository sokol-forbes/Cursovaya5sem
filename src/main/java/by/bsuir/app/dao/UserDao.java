package by.bsuir.app.dao;

import by.bsuir.app.entity.Account;
import by.bsuir.app.entity.User;

import java.util.List;

public interface UserDao extends BaseDao<Long, User>{
    List<User> findAllByCriteria(String field);

    boolean registration(User user);
}
