package by.bsuir.app.service.impl;


import by.bsuir.app.dao.AccountDao;
import by.bsuir.app.dao.UserDao;
import by.bsuir.app.entity.Account;
import by.bsuir.app.entity.User;
import by.bsuir.app.entity.enums.Role;
import by.bsuir.app.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private AccountDao accDao;
    public UserServiceImpl(UserDao userDao){this.userDao=userDao;}


    @Override
    public User findByAccount(Account account) {

        User user = new User();
        user.setAccount(accDao.findByLogin(account.getLogin()));

        return user;
    }

    @Override
    public List<User> findAllByCriteria(String field) {
        return null;
    }

    @Override
    public boolean registration(User user) {
        User u = findByAccount(user.getAccount());
        if(u.getAccount().getId() == null){
            user.getAccount().setRole(Role.USER.toString());
            userDao.saveOrUpdate(user);
            return true;
        }
        return false;
    }
}
