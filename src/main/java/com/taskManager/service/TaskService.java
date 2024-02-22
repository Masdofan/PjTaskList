package com.taskManager.service;

import com.taskManager.dto.TaskDto;
import com.taskManager.model.TaskEntity;

public interface TaskService {

    void save(TaskDto task);

}
