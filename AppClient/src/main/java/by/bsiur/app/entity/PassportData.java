package by.bsiur.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PassportData extends BaseEntity {

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
