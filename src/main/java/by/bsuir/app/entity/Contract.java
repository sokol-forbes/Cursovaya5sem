package by.bsuir.app.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "contract", schema = "bank")
public class Contract extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "date_of_signing")
    Date dateOfSigning;
    String number;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_id")
    @NotNull
    Credit credit;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @NotNull
    User user;
}
