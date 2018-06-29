package ru.itpark.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itpark.service.dto.TaskDto;
import ru.itpark.service.forms.TaskForm;
import ru.itpark.service.models.Task;
import ru.itpark.service.models.TaskStatus;
import ru.itpark.service.repositories.TaskRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TaskServiceImpl implements TaskService {


    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<TaskDto> getAllTask() {
        List<Task> tasks = taskRepository.findAll();

        List<TaskDto> taskDtos = new ArrayList<>();
        for (Task task : tasks) {
            taskDtos.add(TaskDto.builder()
                    .name(task.getTaskName())
                    .createdDate(LocalDateTime.now().toString())
                    .discription(task.getTaskDescription())
                    .deadLine(task.getDeadline().toString())
                    .status(task.getStatus().toString())
                    .build());
        }
        return taskDtos;
    }

    @Override
    public List<TaskDto> findAllByStatus(TaskStatus status) {
        List<Task> tasks = taskRepository.findAllByStatus(status);

        List<TaskDto> taskDtos = new ArrayList<>();
        for(Task task: tasks){
            taskDtos.add(TaskDto.builder()
                    .name(task.getTaskName())
                    .discription(task.getTaskDescription())
                    .createdDate(task.getCreatedDate().toString())
                    .deadLine(task.getDeadline().toString())
                    .status(task.getStatus().toString())
                    .build());
        }
        return taskDtos;
    }

    @Override
    public void addTask(TaskForm taskForm) {
        Task task = Task.builder()
                .taskName(taskForm.getName())
                .taskDescription(taskForm.getDescription())
                .createdDate(LocalDateTime.now())
                .deadline(LocalDate.parse(taskForm.getDeadLine()))
                .status(TaskStatus.ACTIVE)
                .build();
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public TaskDto changeStatus(Long id) {
        Task task = taskRepository.findOne(id);
        if(task.getStatus().equals(TaskStatus.ACTIVE))
            task.setStatus(TaskStatus.CLOSED);
        else task.setStatus(TaskStatus.ACTIVE);

        taskRepository.save(task);
        return TaskDto.builder()
                .status(task.getStatus().toString())
                .build();
    }

    @Override
    public List<TaskDto> findAllWhereDeadlineLess(Date date) {
        List<Task> actualTasks = taskRepository.findAllWhereDeadLineLessThan(date);

        List<TaskDto> taskDtos = new ArrayList<>();
        for(Task task: actualTasks){
            taskDtos.add(TaskDto.builder()
            .name(task.getTaskName())
            .discription(task.getTaskDescription())
                    .createdDate(task.getCreatedDate().toString())
                    .deadLine(task.getDeadline().toString())
                    .status(task.getStatus().toString())
            .build());
        }
        return taskDtos;
    }
}
