package ru.itpark.service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "project_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;

    @Column(name = "hash_password")
    private String hashPassword;
    private String name;
    private String city;
    private String eMail;
//    private LocalDate birthDate;
    private Integer age;
    @ElementCollection
    private List<String> authorities;
    private String role;


    @Enumerated(value = EnumType.STRING)
    private UserState state;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

    @ManyToMany(mappedBy = "userList")
    private List<Project> projects;
    //private String command;
    @OneToMany(mappedBy = "creator")
    private List<Project> createdProjects;
}
