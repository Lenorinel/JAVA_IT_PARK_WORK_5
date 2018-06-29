package ru.itpark.service.services;

import ru.itpark.service.dto.TaskDto;
import ru.itpark.service.forms.TaskForm;
import ru.itpark.service.models.TaskStatus;

import java.util.Date;
import java.util.List;

public interface TaskService {
    List<TaskDto> getAllTask();
    List<TaskDto> findAllByStatus(TaskStatus status);
    void addTask(TaskForm taskForm);
    void deleteTask(Long id);
    TaskDto changeStatus(Long id);
    List<TaskDto> findAllWhereDeadlineLess(Date date);

}
