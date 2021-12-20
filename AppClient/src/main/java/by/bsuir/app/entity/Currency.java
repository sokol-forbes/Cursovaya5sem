package by.bsuir.app.entity;

import lombok.Data;

import java.util.Collection;

@Data
public class Currency extends BaseEntity {

    private Long id;
    private String name;
    private String genericSymbol;
    private String symbol;
    private Collection<Contract> contractsById;


    public Collection<Contract> getContractsById() {
        return contractsById;
    }

    public void setContractsById(Collection<Contract> contractsById) {
        this.contractsById = contractsById;
    }
}
