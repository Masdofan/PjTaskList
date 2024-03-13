package com.taskManager.model;


import com.taskManager.model.enums.TaskStatus;
import com.taskManager.model.enums.TaskType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Entity(name = "Tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @ManyToOne
    private TaskEntity parentTask;

    private String name;

    private String summary;

    private String description;

    private LocalDate expDate;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    private TaskType type;

    @ManyToOne
    private UserEntity executor;

    @ToString.Exclude
    @OneToMany(mappedBy = "task")
    private List<CommentEntity> comments;

    @ToString.Exclude
    @OneToMany(mappedBy = "parentTask")
    private List<TaskEntity> subtasks;

}
