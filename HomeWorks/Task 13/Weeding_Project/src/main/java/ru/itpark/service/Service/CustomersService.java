package ru.itpark.service.Service;

import ru.itpark.service.Forms.CustomerForm;
import ru.itpark.service.models.Customer;

import java.util.List;

public interface CustomersService {
    List<Customer> getAllCustomers();
    void registerNewCustomer(CustomerForm customerForm);
    Customer login(CustomerForm customerForm);
}
