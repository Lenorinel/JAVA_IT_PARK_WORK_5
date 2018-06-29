package ru.itpark.service.services;

import ru.itpark.service.dto.UserDto;
import ru.itpark.service.forms.UserForm;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> getAllUsers();
    void addUser(UserForm user);
    UserDto getUserInfoByLogin(String login);
    UserDto changeStatus(Long userId);

    String sendMail(String email);


}
