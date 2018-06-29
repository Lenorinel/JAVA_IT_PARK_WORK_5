package ru.itpark.service.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.service.models.Role;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserForm {
    private String name;
    private String login;
    // private String eMail;
//    private String birthDate;
    private String password;
   //    @Enumerated(value = EnumType.STRING)
    private String role;

    private String city;
}
