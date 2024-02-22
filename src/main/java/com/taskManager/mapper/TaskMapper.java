package com.taskManager.mapper;

import com.taskManager.dto.TaskDto;
import com.taskManager.model.TaskEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

        TaskEntity toEntity(TaskDto dto);

        TaskDto toDto(TaskEntity entity);

}
