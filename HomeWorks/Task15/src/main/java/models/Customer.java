package models;


import lombok.*;


import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "orders")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String hashPassword;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phoneNumber;
    private String address;

    private List<Order> orders;
}
