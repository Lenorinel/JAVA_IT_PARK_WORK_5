package ru.itpark.service.services;

import com.sun.glass.ui.EventLoop;
import ru.itpark.service.dto.UserDto;
import ru.itpark.service.forms.UserForm;
import ru.itpark.service.models.Project;
import ru.itpark.service.models.Role;
import ru.itpark.service.models.User;
import ru.itpark.service.models.UserState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itpark.service.repositories.UsersRepository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender javaMailSender;

    private ExecutorService executorService;

    public UserServiceImpl() {
        executorService = Executors.newFixedThreadPool(10);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = usersRepository.findAll();

        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(UserDto.builder()
                    .id(user.getId())
                    .login(user.getLogin())
                    .state(user.getState().toString())
                    .build());
        }
        return userDtos;
    }

    @Override //?? Создать отдельный Optional для Security или обойти этот
    public UserDto getUserInfoByLogin(String login) {
        User userInfo = usersRepository.findByLogin(login);

        UserDto userDto = UserDto.builder()
                .name(userInfo.getName())
                .city(userInfo.getCity())
                .age(userInfo.getAge())
                .role(userInfo.getRole().toString())
                .build();

        return userDto;
    }


    public void addUser(UserForm user) {
        String hashPassword = passwordEncoder.encode(user.getPassword());

        User newUser = User.builder()
                .login(user.getLogin())
                .hashPassword(hashPassword)
//                .birthDate(LocalDate.parse(user.getBirthDate()))
                .name(user.getName())
                //.eMail(user.getEMail())
                .city(user.getCity())
                .role(user.getRole().toString()) //ак задать роль при регистрации через окно выбора роли??
                //.birthDate(user.getBirthDate())
                .state(UserState.ACTIVE)
                .authorities(Collections.singletonList("CAN_VIEW_PROFILE"))
                .build();
              usersRepository.save(newUser);
    }

    @Override
    public UserDto changeStatus(Long userId) {
        User user = usersRepository.findOne(userId);
        if (user.getState().equals(UserState.ACTIVE)) {
            user.setState(UserState.BANNED);
        } else user.setState(UserState.ACTIVE);
        usersRepository.save(user);
        return UserDto.builder()
                .state(user.getState().toString())
                .build();
    }

    @Override
    public String sendMail(String email) {
        executorService.submit(() -> {
            MimeMessage message = javaMailSender.createMimeMessage();
            try {
                message.setContent("Hi, you were invited in our project! ", "text/html");
                MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
                messageHelper.setTo(email);
                messageHelper.setSubject("Вы были приглашены в команду");
                messageHelper.setText("Чтобы присоединиться к проекту, перейдите по ссылке:http://localhost:8080/signUp", true );
            } catch (MessagingException e) {
                throw new IllegalArgumentException(e);
            }
            javaMailSender.send(message);
        });
        return "Отправка успешна";
    }
}
