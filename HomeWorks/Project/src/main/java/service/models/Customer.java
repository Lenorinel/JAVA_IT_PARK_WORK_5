package service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String hashPassword;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phoneNumber;
    private String address;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
