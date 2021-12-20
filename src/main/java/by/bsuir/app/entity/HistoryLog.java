package by.bsuir.app.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "history_log")
@Data
public class HistoryLog extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp entrance;

    public HistoryLog() {}

    public HistoryLog(Timestamp entrance) {
        this.entrance = entrance;
    }
}
