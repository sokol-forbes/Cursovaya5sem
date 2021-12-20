package by.bsuir.app.entity;

import lombok.Data;

import java.sql.Date;
import java.util.Collection;

@Data
public class PersonalData extends BaseEntity {

    private Long id;
    private String name;
    private String surname;
    private String thirdname;
    private Integer age;
    private String gender;
    private String passNumber;
    private String idenNumber;
    private Date dateOfBirth;
    private Date dateOfIssue;
    private Date dateOfExpirity;
    private Collection<Account> accountsById;


    public Collection<Account> getAccountsById() {
        return accountsById;
    }

    public void setAccountsById(Collection<Account> accountsById) {
        this.accountsById = accountsById;
    }
}
