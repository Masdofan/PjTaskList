package com.taskManager.dto;

import com.taskManager.model.TaskEntity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private List<TaskEntity> tasks;

}
