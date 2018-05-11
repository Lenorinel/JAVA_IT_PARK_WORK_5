package ru.itpark.service.models;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {
    private Integer id;
    private String login;
    private String hashPassword;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phoneNumber;
    private String address;
    private List<Order> orders;
    }
