package ru.itpark.service.repositories;

import org.springframework.data.jpa.repository.Query;
import ru.itpark.service.models.Role;
import ru.itpark.service.models.Task;
import ru.itpark.service.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    List<User> findAllByRole(Role role);

    Optional<User> findOneByName(String name);

    Optional<User> findOneByLogin(String login);

    User findByLogin(String login);

    @Query(nativeQuery = true, value = "INSERT INTO TABLE user_project VALUES (?)")
    void saveInProjTable(long id);
}
