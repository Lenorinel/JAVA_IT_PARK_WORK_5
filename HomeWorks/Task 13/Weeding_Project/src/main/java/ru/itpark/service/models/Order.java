package ru.itpark.service.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder

public class Order {
    private Integer id;
    private Date dateCreated;
    private Customer customer;
    private List<Good> finalOrder;
    private Double finalPrice;
}
