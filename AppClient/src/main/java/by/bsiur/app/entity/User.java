package by.bsiur.app.entity;

import java.util.List;

public class User extends BaseEntity {
    private Long id;
    private PersonalData personalData;
    private PassportData passportData;
    private Account account;
    private List<Contract> contracts;


    public PassportData getPassportData() {
        if (passportData == null)
            passportData = new PassportData();
        return passportData;
    }

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
