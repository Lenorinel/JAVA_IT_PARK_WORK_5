package ru.itpark.service.Repositories;

import java.util.List;

public interface CrudRepository<T> {
    T find(int id);
    List<T> findAll();
    void save(T model);
    void delete(String name);
}
