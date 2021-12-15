package by.bsiur.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonalData extends BaseEntity{
    private Long id;
    private String name;
    private String surname;

    private String thirdName;
    private String gender;

    private String phone;


}
