package com.taskManager.service;

import com.taskManager.dto.TaskDto;
import com.taskManager.model.TaskEntity;

import java.util.List;

public interface TaskService {

    void save(TaskDto task);

    List<TaskEntity> getTasks();

}
