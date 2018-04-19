package Home.models;

import java.time.LocalDate;

public class UserHand extends User{
    private int id;

    public UserHand(int id, String firstName, String secondName, LocalDate birthDate) {
        super(firstName,secondName,birthDate);
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
