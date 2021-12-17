package by.bsiur.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PassportData extends BaseEntity implements Serializable {
    static final long serialVersionUID = 42L;
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
