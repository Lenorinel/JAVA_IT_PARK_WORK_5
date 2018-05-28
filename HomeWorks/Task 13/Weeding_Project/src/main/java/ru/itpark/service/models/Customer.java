package ru.itpark.service.models;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder

public class Customer {
    private Integer id;
    private String login;
    private String hashPassword;
    private String firstName;
    private String secondName;
    private String email;
    private Date birthDate;
    private String address;
    private String phoneNumber;
    private List<Order> orders; //Список заказов
}
