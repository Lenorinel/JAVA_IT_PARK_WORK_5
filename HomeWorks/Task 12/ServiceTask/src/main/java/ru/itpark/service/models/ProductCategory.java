package ru.itpark.service.models;

import java.util.List;
import lombok.*;

@Data
@AllArgsConstructor
@Builder

public class ProductCategory {
    private Integer id;
    private String name;
    private List<Product> productList;
}
