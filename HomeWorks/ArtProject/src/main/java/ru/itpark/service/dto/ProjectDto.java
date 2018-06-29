package ru.itpark.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.service.models.Project;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDto {
    private Long id;
    private String name;
    private String discription;
    private String createdDate;
    private String status;
//    List<Object> фоткиОтВизажистов;
//    List<Object> фоткиОтХудожников;

    public static ProjectDto from(Project model) {
        return ProjectDto.builder()
                .id(model.getId())
                .name(model.getName())
                .discription(model.getDescription())
                .createdDate(model.getCreateDate().toString())
                .status(model.getProjectStatus().toString())
                .build();
    }
}
