package ru.itpark.service.forms;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserForm {
    private String login;
    private String password;
    private String firstName;
    private String secondName;
    private String email;
    private Integer phoneNumber;
    private String address;
}
