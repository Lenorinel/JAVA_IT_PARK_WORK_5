package ru.itpark.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itpark.service.services.UserService;

@Controller
public class MailController {

    @Autowired
    UserService service;

    @GetMapping("/sendMail")
    public String getEmailpage(){
        return "Mail_Page";
    }
    @PostMapping("/sendMail")
    public String sendMail(@RequestParam("email") String email) {
       ResponseEntity.ok(service.sendMail(email));
       return "redirect:/sendMail";
    }
}
