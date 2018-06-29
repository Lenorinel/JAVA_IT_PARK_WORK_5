package ru.itpark.service.repositories;

import ru.itpark.service.models.Task;
import ru.itpark.service.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findAllByStatus(TaskStatus status);
    Optional<Task> findOneByTaskName(String name);
    Optional<Task> deleteById(Long id);

    @Query(nativeQuery = true, value = "SELECT * from user_tasks ut where ut.deadline < ? AND ut.status ='ACTIVE'")
    List<Task> findAllWhereDeadLineLessThan(Date date);
}
