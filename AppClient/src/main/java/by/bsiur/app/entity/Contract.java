package by.bsiur.app.entity;

import java.io.Serializable;
import java.sql.Date;

public class Contract extends BaseEntity implements Serializable {
    static final long serialVersionUID = 42L;
    private Long id;
    private Credit credit;
    private Date dateOfSigning;
    private String number;
}
