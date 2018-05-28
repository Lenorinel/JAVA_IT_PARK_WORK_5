import config.HibernateConnector;
import models.Customer;
import models.Order;
import org.hibernate.Session;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomersRepositoryImpl customersRepository =
                new CustomersRepositoryImpl(HibernateConnector.getConnector().getSessionFactory());



        List<Customer> customers = customersRepository.findAll();
        System.out.println(customers);
        Customer customer = Customer.builder()
                .firstName("Jack")
                .lastName("Sparrow")
                .email("CaptainJackSparrow@yahoo.com")
                .login("Captain")
                .build();

        Order order = Order.builder()
                .name("Rum")
                .build();

    }
}
