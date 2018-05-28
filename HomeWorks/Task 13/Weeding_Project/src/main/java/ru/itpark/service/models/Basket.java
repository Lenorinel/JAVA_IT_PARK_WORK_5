package ru.itpark.service.models;
import lombok.*;

@Data
@AllArgsConstructor
@Builder

public class Basket {
    private Integer id;
    private Good good;
}
