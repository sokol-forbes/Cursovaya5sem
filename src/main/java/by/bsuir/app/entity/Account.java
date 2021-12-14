package by.bsuir.app.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Proxy(lazy = false)
public class Account extends BaseEntity{

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name="user_id")
    @NotNull
    User user;

    public Account(Long id, String login, String password){
        this.id =id;
        this.login = login;
        this.password = password;
    }
}
