package by.bsuir.app.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Proxy(lazy = false)
public class Account extends BaseEntity implements Serializable {
    static final long serialVersionUID = 42L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, length = 45)
    String login;
    @Column(nullable = false, length = 45)
    String password;
    @Column(nullable = false, length = 45)
    String email;

    String role;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn (name="user_id")
//    @NotNull
//    User user;

    public Account(Long id, String login, String password){
        this.id =id;
        this.login = login;
        this.password = password;
    }

    public Account(String  login) {

        super();
        this.login=login;
    }
}
