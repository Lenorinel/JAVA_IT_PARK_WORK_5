package ru.itpark.service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itpark.service.Forms.CustomerForm;
import ru.itpark.service.Repositories.CustomerRepository;
import ru.itpark.service.models.Customer;

import java.util.List;

@Component
public class CustomersServiceImpl implements CustomersService {
    private CustomerRepository customerRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public CustomersServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void registerNewCustomer(CustomerForm customerForm) {
        String hashPassword = passwordEncoder.encode(customerForm.getPassword());
        Customer newCustomer = Customer.builder()
                .login(customerForm.getLogin())
                .hashPassword(hashPassword)
                .firstName(customerForm.getFirstName())
                .secondName(customerForm.getSecondName())
                .email(customerForm.getEmail())
                .birthDate(customerForm.getBirthDate())
                .address(customerForm.getAddress())
                .phoneNumber(customerForm.getPhoneNumber())
                .build();
        customerRepository.save(newCustomer);
    }

    @Override
    public Customer login(CustomerForm customerForm) {
        Customer customerCandidate = customerRepository.findByLogin(customerForm.getLogin());
        if (customerCandidate == null) {
            return null;
        } else if (passwordEncoder.matches(customerForm.getPassword(), customerCandidate.getHashPassword())) {
            return customerCandidate;
        } else return null;

    };
}
