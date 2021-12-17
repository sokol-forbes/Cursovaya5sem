package by.bsiur.app.entity;

import java.io.Serializable;
import java.util.List;

public class Employee extends BaseEntity implements Serializable {
    static final long serialVersionUID = 42L;
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
