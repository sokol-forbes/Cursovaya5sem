package by.bsuir.app.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Proxy(lazy = false)
public class User extends BaseEntity implements Serializable {
    static final long serialVersionUID = 42L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_data_id")
    @NotNull
    PersonalData personalData;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_data_id")
    @NotNull
    PassportData passportData;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name="account_id")
    @NotNull
    Account account;
//    @Transient
//    @OneToMany(cascade = CascadeType.REFRESH)
//    @LazyCollection(LazyCollectionOption.FALSE)
//    @JoinColumn(name = "contract_id")
//    List<Contract> contracts;

public User(Account account){
    this.account= account;
}
}
