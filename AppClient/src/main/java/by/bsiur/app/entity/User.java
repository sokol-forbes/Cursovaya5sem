package by.bsiur.app.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User extends BaseEntity implements Serializable {
    static final long serialVersionUID = 42L;
    private Long id;
    private PersonalData personalData;
    private PassportData passportData;
    private Account account;
//    private List<Contract> contracts;


    public User(PersonalData personalData,PassportData passportData,Account account){
        this.personalData = personalData;
        this.passportData = passportData;
        this.account = account;
    }

    public User(PersonalData personalData,Account account){
        this.personalData = personalData;

        this.account = account;
    }

    public User(Account account) {
        this.account = account;
    }

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
