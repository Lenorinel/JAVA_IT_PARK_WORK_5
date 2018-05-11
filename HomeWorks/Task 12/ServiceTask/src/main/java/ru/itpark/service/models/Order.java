package ru.itpark.service.models;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Order {
    private Integer id;
    private Date dateCreated;
    private Customer customer;
    private List<Basket> finalBasket;
    private Integer price;
    }
