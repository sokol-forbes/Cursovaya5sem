package by.bsuir.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "passport_data", schema = "bank")
public class PassportData extends BaseEntity implements Serializable {
    static final long serialVersionUID = 42L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "code_of_issuing_state")
    String codeOfIssuingState;
    @Column(name = "passport_number")
    String passportNumber;
    @Column(name = "date_of_birth")
    Date dateOfBirth;
    @Column(name = "identification_number")
    String identificationNumber;
    @Column(name = "place_of_birth")
    String placeOfBirth;
    @Column(name = "date_of_issue")
    Date dateOfIssue;
    @Column(name = "date_of_expiry")
    Date dateOfExpiry;
    String authority;



}
