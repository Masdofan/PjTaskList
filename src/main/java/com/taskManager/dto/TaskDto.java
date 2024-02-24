package com.taskManager.dto;

import com.taskManager.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private String name;

    private String summary;

    private String description;

    private Date expDate;

    private UserEntity executor;

}
