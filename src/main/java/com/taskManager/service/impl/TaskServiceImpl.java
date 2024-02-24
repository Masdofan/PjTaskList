package com.taskManager.service.impl;

import com.taskManager.dto.TaskDto;
import com.taskManager.mapper.TaskMapper;
import com.taskManager.model.TaskEntity;
import com.taskManager.repository.TaskRepository;
import com.taskManager.service.TaskService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;
    private final TaskMapper mapper;

    @Override
    @Transactional
    public void save(TaskDto dto) {
        var entity = mapper.toEntity(dto);

        repository.save(entity);
    }

    @Override
    public List<TaskEntity> getTasks() {
        return repository.findAll();
    }
}
