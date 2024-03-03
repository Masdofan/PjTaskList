package com.taskManager.dto;

import com.taskManager.model.TaskEntity;
import com.taskManager.model.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubtaskDto {

    private String name;

    private String description;

    private TaskStatus status;

    private TaskEntity mainTask;

}
