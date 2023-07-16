package xyz.r0r5chach.csy2061_assignment_2_resit.db.entities;

import java.time.LocalDate;

public class User extends NamedEntity {
    private String email, password, doorNumber, address, postCode;
    private LocalDate dateRegistered;
    private LocalDate dateUpdated;
    private UserType type;

    public User() {
        super("");
    }

    public User(String name, String email, String password, String doorNumber, String postCode, LocalDate dateRegistered, UserType type) {
        super(name);
        this.email = email;
        this.password = password;
        this.doorNumber = doorNumber;
        this.postCode = postCode;
        this.dateRegistered = dateRegistered;
        this.type = type;
    }

    public User(String name, String email, String password, String doorNumber, String postCode, LocalDate dateRegistered, UserType type, String address, LocalDate dateUpdated) {
        this(name, email, password, doorNumber, postCode, dateRegistered, type);
        this.address = address;
        this.dateUpdated = dateUpdated;
    }

    public User(String name, String email, String password, String doorNumber, String postCode, LocalDate dateRegistered, UserType type, String address) {
        this(name, email, password, doorNumber, postCode, dateRegistered, type, address, null);
    }

    public User(String name, String email, String password, String doorNumber, String postCode, LocalDate dateRegistered, UserType type, LocalDate dateUpdated) {
        this(name, email, password, doorNumber, postCode, dateRegistered, type, null, dateUpdated);
    }

    public User(String email, String password) {
        super(null);
        this.email = email;
        this.password = password;
    }

    public String getString(StringType type) {
        return switch(type) {
            case EMAIL -> email;
            case PASSWORD -> password;
            case DOOR_NUMBER -> doorNumber;
            case ADDRESS -> address;
            case POST_CODE -> postCode;
            case NAME -> name;
        };
    }

    public UserType getType() {
        return type;
    }

    public LocalDate getDate(DateType type) {
        return switch (type) {
            case REGISTERED -> dateRegistered;
            case UPDATED -> dateUpdated;
            case CREATED -> null;
        };
    }

    public void setString(String string, StringType type) {
        switch(type) {
            case EMAIL -> email = string;
            case PASSWORD -> password = string;
            case DOOR_NUMBER -> doorNumber = string;
            case ADDRESS -> address = string;
            case POST_CODE -> postCode = string;
            case NAME -> name = string;
        }
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
