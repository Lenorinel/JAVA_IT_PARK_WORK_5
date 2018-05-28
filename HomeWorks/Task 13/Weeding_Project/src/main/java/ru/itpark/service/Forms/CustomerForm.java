package ru.itpark.service.Forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder

public class CustomerForm {

        private Integer id;
        private String login;
        private String password;
        private String firstName;
        private String secondName;
        private String email;
        private Date birthDate;
        private String address;
        private String phoneNumber;
}
