package by.bsuir.app.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class Contract extends BaseEntity {

    private Long id;
    private BigDecimal amount;
    private Date dateOfSigning;
    private Account accountByResponsibleId;
    private CreditInfo creditInfoByCreditInfoId;
    private Account accountByUserId;
    private Currency currencyByCurrencyId;

    public Account getAccountByResponsibleId() {
        return accountByResponsibleId;
    }

    public void setAccountByResponsibleId(Account accountByResponsibleId) {
        this.accountByResponsibleId = accountByResponsibleId;
    }

    public CreditInfo getCreditInfoByCreditInfoId() {
        return creditInfoByCreditInfoId;
    }

    public void setCreditInfoByCreditInfoId(CreditInfo creditInfoByCreditInfoId) {
        this.creditInfoByCreditInfoId = creditInfoByCreditInfoId;
    }

    public Account getAccountByUserId() {
        return accountByUserId;
    }

    public void setAccountByUserId(Account accountByUserId) {
        this.accountByUserId = accountByUserId;
    }

    public Currency getCurrencyByCurrencyId() {
        return currencyByCurrencyId;
    }

    public void setCurrencyByCurrencyId(Currency currencyByCurrencyId) {
        this.currencyByCurrencyId = currencyByCurrencyId;
    }
}
