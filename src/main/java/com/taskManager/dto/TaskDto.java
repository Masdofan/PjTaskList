package com.taskManager.dto;

import com.taskManager.model.TaskEntity;
import com.taskManager.model.UserEntity;
import com.taskManager.model.enums.TaskStatus;
import com.taskManager.model.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private TaskEntity parentTask;

    private String name;

    private String summary;

    private String description;

    private LocalDate expDate;

    private TaskStatus status;

    private TaskType type;

    private UserEntity executor;

}
