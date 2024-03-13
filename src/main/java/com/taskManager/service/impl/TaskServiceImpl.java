package com.taskManager.service.impl;

import com.taskManager.dto.TaskDto;
import com.taskManager.dto.TaskUpdateDto;
import com.taskManager.mapper.TaskMapper;
import com.taskManager.model.TaskEntity;
import com.taskManager.model.enums.TaskStatus;
import com.taskManager.repository.TaskRepository;
import com.taskManager.service.TaskService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper mapper;

    @Override
    @Transactional
    public void save(TaskDto dto) {
        var entity = mapper.toEntity(dto);

        taskRepository.save(entity);
    }

    @Override
    public void duplicate(TaskEntity entity) {
        TaskDto dto = mapper.toDto(entity);
        TaskEntity taskEntity = mapper.toEntity(dto);
        taskRepository.save(taskEntity);
    }

    @Override
    public List<TaskEntity> getTasks() {
        return taskRepository.findTaskEntitiesByParentTaskIsNull();
    }

    @Override
    public List<TaskEntity> getTasksByExec(Integer id) {
        return taskRepository.findAllByExecutor_Id(id);
    }

    @Override
    public TaskEntity getTaskById(Integer id) {
        Optional<TaskEntity> byId = taskRepository.findById(id);
        return byId.get();
    }

    @Override
    public List<TaskEntity> getTasksByStatus(TaskStatus status) {
        return taskRepository.findAllByStatus(status);
    }

    @Override
    public List<TaskEntity> getTasksByDescNotEmpty() {
        return taskRepository.findAllByDescriptionNotLike("");
    }

    @Override
    public List<TaskEntity> getTasksByDescEmpty() {
        return taskRepository.findAllByDescriptionEquals("");
    }

    @Override
    public List<TaskEntity> getTasksByParentId(Integer id) {
        return taskRepository.findAllByParentTaskId(id);
    }

    @Override
    @Transactional
    public void update(Integer id, TaskUpdateDto updateDto) {
        taskRepository.updateName(id, updateDto.getUpName());
        taskRepository.updateSummary(id , updateDto.getUpSummary());
        taskRepository.updateDescription(id, updateDto.getUpDescription());
        taskRepository.updateType(id, updateDto.getUpType());
        taskRepository.updateStatus(id, updateDto.getUpStatus());
        taskRepository.updateExpDate(id, updateDto.getUpExpDate());
        taskRepository.updateExecutor(id, updateDto.getUpExecutor());

    }

    @Override
    public void deleteById(Integer id) {
        taskRepository.deleteById(id);
    }

}
