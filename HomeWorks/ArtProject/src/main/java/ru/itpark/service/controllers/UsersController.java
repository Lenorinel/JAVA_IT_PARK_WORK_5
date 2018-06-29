package ru.itpark.service.controllers;

import org.springframework.stereotype.Controller;
import ru.itpark.service.dto.UserDto;
import ru.itpark.service.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.service.services.UserService;

import java.util.List;
import java.util.Optional;

@Controller
public class UsersController {
    @Autowired
    private UserService service;

    @GetMapping("/users")
    public String getUsersPage(ModelMap model) {
        List<UserDto> users = service.getAllUsers();
        model.addAttribute("users", users);
        return "Users_page";
    }

    @PostMapping("/signUp")
    public String addUser(UserForm user) {

        service.addUser(user);
        //service.addUserInProj(projectId, user.getLogin());
        return "redirect:/project";
    }

    //    @PostMapping("/profile")
//    public String viewInfo(ModelMap model) {
//
//        Optional<UserDto> user = service.getUserInfoByLogin(mod)
//    } как вытащить инфу залогиневшегося пользователя?
    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "SignUp_page";
    }


    @GetMapping("/login")
    public String getLoginPage() {
        return "Login_page";
    }

//    @PostMapping("/login")
//    public

    @PostMapping("/users/{user-id}")
    @ResponseBody
    public ResponseEntity<UserDto> changeStatus(
            @PathVariable("user-id") Long userId, @RequestParam("action") String action) {
        if (action.equals("change_status")) {
            UserDto userDto = service.changeStatus(userId);
            return ResponseEntity.ok(userDto);
        } else return ResponseEntity.notFound().build();
    }


}
