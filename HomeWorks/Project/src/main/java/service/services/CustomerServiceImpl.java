package service.services;

import service.forms.CustomerForm;
import service.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import service.repositories.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> customers = customerRepository.findAll();

    @Override
    public void addCustomer(CustomerForm customer) {
    Customer newCustomer = Customer.builder()
            .login(customer.getLogin())
            .hashPassword(customer.getPassword())
            .firstName(customer.getFirstName())
            .lastName(customer.getLastName())
            .birthDate(customer.getBirthDate())
            .email(customer.getEmail())
            .address(customer.getAddress())
            .phoneNumber(customer.getPhoneNumber())
            .build();
    customerRepository.save(newCustomer);
            }
}
