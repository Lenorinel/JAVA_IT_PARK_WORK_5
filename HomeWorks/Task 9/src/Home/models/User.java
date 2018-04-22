package Home.models;

import java.time.LocalDate;

public class User {
    public int id;
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

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return this.firstName + " " + this.secondName +" " + this.birthDate;
    }
}
