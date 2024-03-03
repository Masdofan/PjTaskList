package com.taskManager.service;

import com.taskManager.dto.SubtaskDto;
import com.taskManager.dto.TaskDto;
import com.taskManager.dto.TaskUpdateDto;
import com.taskManager.model.SubtaskEntity;
import com.taskManager.model.TaskEntity;
import com.taskManager.model.enums.TaskStatus;

import java.util.List;

public interface TaskService {

    void save(TaskDto task);

    void duplicate(TaskEntity entity);

    List<TaskEntity> getTasks();

    List<TaskEntity> getTasksByExec(Integer id);

    TaskEntity getTaskById(Integer id);

    List<TaskEntity> getTasksByStatus(TaskStatus status);

    List<TaskEntity> getTasksByDescNotEmpty();

    List<TaskEntity> getTasksByDescEmpty();

    void update(Integer id, TaskUpdateDto updateDto);

    void deleteById(Integer id);

    void saveSub(SubtaskDto dto);

    List<SubtaskEntity> getSubsByMainId(Integer id);

}
