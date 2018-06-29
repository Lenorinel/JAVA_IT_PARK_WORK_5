package ru.itpark.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import ru.itpark.service.dto.ProjectDto;
import ru.itpark.service.forms.ProjectForm;
import ru.itpark.service.forms.UserForm;
import ru.itpark.service.models.Project;
import ru.itpark.service.models.TaskStatus;
import ru.itpark.service.models.User;
import ru.itpark.service.repositories.ProjectsRepository;
import ru.itpark.service.repositories.UsersRepository;

import java.time.LocalDateTime;

@Component
public class ProjectsServiceImpl implements ProjectsService {
    @Autowired
    ProjectsRepository projectsRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    AuthenticationService authenticationService;

    @Override
    public ProjectDto getProject(Long id, Authentication authentication) {
        Project project = projectsRepository.findOne(id);

        return ProjectDto.from(project);
    }

    @Override
    public void addUserToProject(Long projectId, UserForm userForm, Authentication authentication) {

    }

    @Override
    public void createNewProject(ProjectForm projectForm) {
        Project project = Project.builder()
                .name(projectForm.getProjectName())
                .description(projectForm.getProjectDescription())
                .createDate(LocalDateTime.now().toString())
                .releaseDate(projectForm.getReleaseDate())
                .projectStatus(TaskStatus.ACTIVE)
                .build();
        projectsRepository.save(project);

    }

    @Override
    public void addUserInProj(Long projectId, String login) {
        User user = usersRepository.findByLogin(login);
        projectsRepository.ChainUserWithProjects(projectId, user.getId());
    }
}
