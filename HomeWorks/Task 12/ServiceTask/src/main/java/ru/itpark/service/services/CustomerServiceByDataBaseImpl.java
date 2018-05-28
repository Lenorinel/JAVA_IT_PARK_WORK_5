package ru.itpark.service.services;

import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itpark.service.forms.UserForm;
import ru.itpark.service.models.Customer;
import ru.itpark.service.repositories.CustomerRepository;
import ru.itpark.service.repositories.CustomerRepositoryImpl;
import javax.sql.DataSource;
import java.util.List;

public class CustomerServiceByDataBaseImpl implements CustomerService  {

   private CustomerRepository customerRepository;
   private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
   public CustomerServiceByDataBaseImpl(DataSource dataSource) {

        this.customerRepository = new CustomerRepositoryImpl(dataSource);
    }

    @Override
    public List<Customer> findAllCustomersFromDatabase() {
        return customerRepository.findAll();
    }

    @Override
    public void registerNewUser(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());
        Customer customer = Customer.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getSecondName())
                .email(userForm.getEmail())
                .address(userForm.getAddress())
                .login(userForm.getLogin())
                .hashPassword(hashPassword)
                .build();
        customerRepository.save(customer);
    }


}
