package com.taskManager.dto;

import com.taskManager.model.UserEntity;
import com.taskManager.model.enums.TaskStatus;
import com.taskManager.model.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskUpdateDto {

    private String upName;

    private String upSummary;

    private String upDescription;

    private LocalDate upExpDate;

    private TaskStatus upStatus;

    private TaskType upType;

    private UserEntity upExecutor;

}
