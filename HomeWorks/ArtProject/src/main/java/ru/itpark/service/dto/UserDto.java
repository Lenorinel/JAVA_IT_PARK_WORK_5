package ru.itpark.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.service.models.Role;
import ru.itpark.service.models.User;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String login;
    private String name;
//    private Date birthDate;
    private String city;
    private String state;
    private Integer age;

    private String role;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .name(user.getName())
                .age(user.getAge())
//                .birthDate(user.getBirthDate())
                .city(user.getCity())
                .role(user.getRole())
                .build();

    }

    public static List<UserDto> from(List<User> users) {
        return users
                .stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}
