package service.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerForm {
    private String login;
    private String Password;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phoneNumber;
    private String address;
}
