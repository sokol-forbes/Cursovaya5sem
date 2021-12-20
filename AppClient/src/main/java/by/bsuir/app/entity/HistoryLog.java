package by.bsuir.app.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class HistoryLog extends BaseEntity {

    private Long id;
    private Timestamp entrance;
    private Account accountByAccountId;

    public HistoryLog(Timestamp entrance) {
        this.entrance = entrance;
    }

    public HistoryLog() {}

    public Account getAccountByAccountId() {
        return accountByAccountId;
    }

    public void setAccountByAccountId(Account accountByAccountId) {
        this.accountByAccountId = accountByAccountId;
    }
}
