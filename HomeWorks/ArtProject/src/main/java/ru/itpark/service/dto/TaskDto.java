package ru.itpark.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.service.models.Task;
import ru.itpark.service.models.TaskStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {
    private Long id;
    private String name;
    private String discription;
    private String createdDate;
    private String deadLine;
    private String status;

    public static TaskDto from(Task model) {
        return TaskDto.builder()
                .id(model.getId())
                .name(model.getTaskName())
                .discription(model.getTaskDescription())
                .createdDate(model.getCreatedDate().toString())
                .deadLine(model.getDeadline().toString())
                .status(model.getStatus().toString())
                .build();
    }

    public static List<TaskDto> from(List<Task> models){
        return models
                .stream()
                .map(TaskDto::from)
                .collect(Collectors.toList());
    }
}
