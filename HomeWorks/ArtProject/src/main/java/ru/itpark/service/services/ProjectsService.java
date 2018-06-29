package ru.itpark.service.services;

import org.springframework.security.core.Authentication;
import ru.itpark.service.dto.ProjectDto;
import ru.itpark.service.forms.ProjectForm;
import ru.itpark.service.forms.UserForm;

public interface ProjectsService {
    ProjectDto getProject(Long id, Authentication authentication);

    void addUserToProject(Long projectId, UserForm userForm, Authentication authentication);

    void createNewProject(ProjectForm projectForm);
    void addUserInProj(Long projectId, String login);
}
