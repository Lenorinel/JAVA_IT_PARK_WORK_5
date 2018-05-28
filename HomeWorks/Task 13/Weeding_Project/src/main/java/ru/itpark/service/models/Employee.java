package ru.itpark.service.models;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder

public class Employee {
    private Integer id;
    private String login;
    private String hashPassword;
    private String firstName;
    private String secondName;
    private LocalDate birthDate;
    private String activity;
    private String phoneNumber;
}
