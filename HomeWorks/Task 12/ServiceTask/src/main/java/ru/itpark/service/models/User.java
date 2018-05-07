package ru.itpark.service.models;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    private Integer id;
    private String first_name;
    private String second_name;
//    private birth_date  ???
    private Integer phone_number;
    }
