package by.bsiur.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonalData extends BaseEntity implements Serializable {
    static final long serialVersionUID = 42L;
    private Long id;
    private String name;
    private String surname;

    private String thirdName;
    private String gender;

    private String phone;
public PersonalData(String name, String surname, String thirdname,String gerder){

}

}
