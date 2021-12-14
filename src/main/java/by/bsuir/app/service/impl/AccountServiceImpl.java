package by.bsuir.app.service.impl;

import by.bsuir.app.dao.AccountDao;
import by.bsuir.app.entity.Account;
import by.bsuir.app.entity.enums.Role;
import by.bsuir.app.service.AccountService;

import java.util.List;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {
    private AccountDao accDao;

    public AccountServiceImpl(AccountDao accDao){this.accDao=accDao;}


    @Override
    public boolean auth(Account account) {
        Role role = accDao.auth(account);
        return role != null;
    }

    @Override
    public Account findByLogin(String login) {
        Optional<Account> account = Optional.of(accDao.findByLogin(login));
        return account.orElse(null);
    }

    @Override
    public List<Account> findAllByCriteria(String field) {
        return accDao.findAllByCriteria(field);
    }




    @Override
    public boolean registration(Account account) {
        Account a = accDao.findByLogin(account.getLogin());
        if (a.getId() == null) {
            account.setRole(Role.USER.toString());
            accDao.saveOrUpdate(account);
            return true;
        }
        return false;
    }


}
