package ru.itpark.service.repositories;

import org.springframework.data.jpa.repository.Query;
import ru.itpark.service.models.Project;
import ru.itpark.service.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectsRepository extends JpaRepository<Project, Long> {
//    List<Project> findAllByStatus(String status);
@Query(nativeQuery = true, value = "INSERT INTO TABLE user_project VALUES (?,?)")
void ChainUserWithProjects(Long projectId,Long userId);
}
