package ru.itpark.service.models;
import lombok.*;

@Data
@AllArgsConstructor
@Builder

public class OrderProduct {
    private Order order;
    private Good good;
}
