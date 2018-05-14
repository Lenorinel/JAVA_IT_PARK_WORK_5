package ru.itpark.service.repositories;

import ru.itpark.service.models.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer> {
Customer findByLogin(String login);
}
