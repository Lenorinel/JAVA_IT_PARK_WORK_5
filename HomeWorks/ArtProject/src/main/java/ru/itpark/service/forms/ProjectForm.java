package ru.itpark.service.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectForm {
    private String projectName;
    private String projectDescription;
    private String releaseDate;
    private String description;
    private List<String> participant; //хз как передать в форме список участников
  }
