package ru.itpark.service.Repositories;

import ru.itpark.service.models.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer> {
    @Override
    void delete(String login);

    Customer findByLogin(String login);
}
