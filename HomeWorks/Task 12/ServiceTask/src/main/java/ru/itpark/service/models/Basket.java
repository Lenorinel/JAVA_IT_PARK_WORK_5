package ru.itpark.service.models;

import lombok.*;

@Data
@AllArgsConstructor
@Builder

public class Basket {
    private Integer id; //id который создается при добавлении товара в корзину
    private Product product; // товар, добавленный в корзину
    private Integer amount; //количество товаров
}
