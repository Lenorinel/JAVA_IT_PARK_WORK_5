package ru.itpark.service.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskForm {
    private String name;
    private String description;
    private String deadLine;
    private String status; //при создании таска автоматич. присваивает статус "Активен"
}
