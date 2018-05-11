package ru.itpark.service.models;
import lombok.*;

@Data
@AllArgsConstructor
@Builder

public class Product {
    private Integer id;
    private String productName;
    private Double priceProduct;
    private String description;
    private ProductCategory category;

}
