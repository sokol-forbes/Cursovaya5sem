package by.bsuir.app.service;

import by.bsuir.app.entity.Account;
import by.bsuir.app.entity.User;

import java.util.List;

public interface UserService {

    User findByAccount(Account account);

    List<User> findAllByCriteria(String field);



    boolean registration(User user);
}
