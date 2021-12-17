package by.bsiur.app.entity;

import java.io.Serializable;

public class Credit extends BaseEntity implements Serializable {
    static final long serialVersionUID = 42L;
    private Long id;
    private String name;
    private Double percents;
    private Integer term;
}
