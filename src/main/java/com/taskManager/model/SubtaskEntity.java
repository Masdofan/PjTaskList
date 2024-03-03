package com.taskManager.model;

import com.taskManager.model.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Subtasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubtaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    @Enumerated(value = EnumType.STRING)
    private TaskStatus status;

    @ManyToOne
    private TaskEntity mainTask;

}
