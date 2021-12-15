package by.bsiur.app.entity.enums;

public enum Role {
    USER(2),
    ADMIN(1),
    EMPLOYEE(0);

    private final int id;


    Role(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
