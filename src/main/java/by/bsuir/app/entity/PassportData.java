package by.bsuir.app.entity;

import lombok.*;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "passport_data", schema = "bank")
public class PassportData extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String code_OfIssuingState;
    String passport_number;
    Date dateOfBirth;
    String identificationNumber;
    String placeOfBirth;
    Date dateOfIssue;
    Date dateOfExpiry;
    String authority;



}
