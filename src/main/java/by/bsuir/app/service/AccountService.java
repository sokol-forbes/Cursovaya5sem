package by.bsuir.app.service;

import by.bsuir.app.entity.Account;

import java.util.List;

public interface AccountService {
    boolean auth(Account account);
    Account findByLogin(String login);

    List<Account> findAllByCriteria(String field);



    boolean registration(Account account);


}
