package service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Basket {

    @Id
    private Long id;
    private Product products;
    private Double fullPrice;
    private Integer amount;
    private Customer customer;
    }
