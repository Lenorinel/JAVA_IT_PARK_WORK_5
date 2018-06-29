package ru.itpark.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itpark.service.dto.ProjectDto;
import ru.itpark.service.forms.ProjectForm;
import ru.itpark.service.forms.UserForm;
import ru.itpark.service.services.ProjectsService;

@Controller
public class ProjectsController {

    @Autowired
    private ProjectsService service;

    @GetMapping("/createNewProject")
    public String getCreatingPage(){
        return "CreateProject_Page";
    }
    @PostMapping("/createNewProject")
    public String createNewProject(ProjectForm project){
        service.createNewProject(project);
        service.addUserToProject();
        return "redirect:/sendMail";
    }

    @GetMapping("/project/{poject-id}")
    public String getProjectPage(){
        return "project_page";
    }

    @GetMapping("/projects/{project-id}")
    public String getTeamPage(ModelMap model, @PathVariable("project-id") Long projectId, Authentication authentication) {
        ProjectDto projectDto = service.getProject(projectId, authentication);
        model.addAttribute("project", projectDto);
        return "project_page";
    }

    @PostMapping("/projects/{project-id}/users")
    public String addUserToProject(@PathVariable("project-id") Long projectId, UserForm userForm, Authentication authentication) {
        service.addUserToProject(projectId, userForm, authentication);
        return "redirect:/projects/" + projectId;
    }
}
