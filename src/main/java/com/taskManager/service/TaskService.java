package com.taskManager.service;

import com.taskManager.dto.TaskDto;
import com.taskManager.dto.TaskUpdateDto;
import com.taskManager.model.CommentEntity;
import com.taskManager.model.TaskEntity;

import java.util.List;

public interface TaskService {

    void save(TaskDto task);

    List<TaskEntity> getTasks();

    List<CommentEntity> getComms();

    TaskEntity getTaskById(Integer id);

    void update(Integer id, TaskUpdateDto updateDto);

}
