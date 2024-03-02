package com.taskManager.service.impl;

import com.taskManager.dto.TaskDto;
import com.taskManager.dto.TaskUpdateDto;
import com.taskManager.mapper.TaskMapper;
import com.taskManager.model.CommentEntity;
import com.taskManager.model.TaskEntity;
import com.taskManager.model.enums.TaskStatus;
import com.taskManager.model.enums.TaskType;
import com.taskManager.repository.CommentRepository;
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
    private final CommentRepository commentRepository;
    private final TaskMapper mapper;

    @Override
    @Transactional
    public void save(TaskDto dto) {
        var entity = mapper.toEntity(dto);

        taskRepository.save(entity);
    }

    @Override
    public List<TaskEntity> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<CommentEntity> getComms() {
        return commentRepository.findAll();
    }

    @Override
    public TaskEntity getTaskById(Integer id) {
        Optional<TaskEntity> byId = taskRepository.findById(id);
        return byId.get();
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

}
