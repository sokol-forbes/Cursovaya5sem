package by.bsiur.app.entity;

import java.util.List;

public class Employee extends BaseEntity{
    private Long id;
    private List<Contract> contracts;
    private PersonalData personalData;
    private Account account;
    public PersonalData getPersonalData() {
        if (personalData == null)
            personalData = new PersonalData();
        return personalData;
    }

    public Account getAccount() {
        if (account == null)
            account = new Account();
        return account;
    }

}
