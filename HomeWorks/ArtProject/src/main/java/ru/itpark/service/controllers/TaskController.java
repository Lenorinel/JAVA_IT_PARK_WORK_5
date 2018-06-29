package ru.itpark.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itpark.service.dto.TaskDto;
import ru.itpark.service.forms.TaskForm;
import ru.itpark.service.models.TaskStatus;
import ru.itpark.service.services.TaskService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping("/profile/{user-id}") //выводит на страницу профиля юзера список активных задач
    public String getTaskPage (ModelMap model){
        List<TaskDto> tasks = service.findAllByStatus(TaskStatus.ACTIVE);
        model.addAttribute("tasks", tasks);
        return "Profile_Page";
    }

    @GetMapping("/tasks/{user-id}")//выводит все таски и позволяет добавить новый таск
    public String getAllTasks(ModelMap model){
        List<TaskDto> tasks = service.getAllTask();
        model.addAttribute("tasks",tasks);
        return "Tasks_Page.ftl";
    }

    @PostMapping("/tasks/{user-id}")//хз туда ли .. изменяет статус таска
    ResponseEntity<TaskDto> changeStatus(
            @PathVariable("task-id") Long taskId, @RequestParam("action") String action) {
        if(action.equals("change-status")){
            TaskDto taskDto = service.changeStatus(taskId);
            return ResponseEntity.ok(taskDto);
        }else return ResponseEntity.notFound().build();
    }

    @PostMapping("/tasks")//??? позволяет создать(добавить в бд) новый таск
    public String addTask(TaskForm taskForm){
        service.addTask(taskForm);
        return "redirect:/tasks/{user-id}";
    }
//    @PostMapping("/tasks")//??? удаление таска
//    public String deleteTask(Long id) {
//        service.deleteTask(id);
//        return  "redirect:/tasks/{user-id}";
//    }
}
