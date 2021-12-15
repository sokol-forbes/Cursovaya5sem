package by.bsiur.app.entity.enums;

public enum Gerder {
    MALE("Мужской"),
    FEMALE("Женский"),
    UNDEFINED("Неизвестно");

    private String gender;

    Gerder(String gender){this.gender = gender;}

    public String getGender() {
        return gender;
    }
}
