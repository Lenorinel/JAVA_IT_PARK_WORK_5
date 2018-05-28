package ru.itpark.service.services;

import ru.itpark.service.forms.UserForm;
import ru.itpark.service.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomersFromDatabase();

    void registerNewUser(UserForm userForm);
}
