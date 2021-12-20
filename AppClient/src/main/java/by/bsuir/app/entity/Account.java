package by.bsuir.app.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Account extends BaseEntity {

    static final long serialVersionUID = 42L;

    private Long id;
    private String login;
    private String password;
    private String email;
    private String role;
    private boolean isBlocked;

    private PersonalData personalDataByPassportId;
    private List<HistoryLog> logs;


    public Account() {
    }

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Account(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public void addLog(HistoryLog log) {
        if (logs == null)
            logs = new ArrayList<>();

        logs.add(log);
    }


}
