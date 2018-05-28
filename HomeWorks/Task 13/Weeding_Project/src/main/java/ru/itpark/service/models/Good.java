package ru.itpark.service.models;
import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class Good {
    private Integer id;
    private String type;
    private String name;
    private String composition; //состав
    private String description; //описание
    private Double price;
}
