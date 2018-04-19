package Home.models;

import java.time.LocalDate;

public class User {
    private int id;
    private String firstName;
    private String secondName;
    private LocalDate birthDate;

    public User(String firstName, String secondName, LocalDate birthDate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
