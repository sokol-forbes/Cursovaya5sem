package by.bsuir.app.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Collection;

@Data
public class CreditInfo extends BaseEntity {

    private Long id;
    private String name;
    private Integer term;
    private BigDecimal percent;
    private Collection<Contract> contractsById;


    public Collection<Contract> getContractsById() {
        return contractsById;
    }

    public void setContractsById(Collection<Contract> contractsById) {
        this.contractsById = contractsById;
    }
}
