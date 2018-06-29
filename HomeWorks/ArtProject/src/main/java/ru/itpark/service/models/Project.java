package ru.itpark.service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    private String createDate;
    private String releaseDate;

    private String name;
    @Column(length = 1000)
    private String description;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

    @Enumerated(value = EnumType.STRING)
    private TaskStatus projectStatus;

    @ManyToMany
    @JoinTable(name = "user_project",
    joinColumns = @JoinColumn(name = "project_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<User> userList;

}
