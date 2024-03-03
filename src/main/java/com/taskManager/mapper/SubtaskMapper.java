package com.taskManager.mapper;

import com.taskManager.dto.SubtaskDto;
import com.taskManager.model.SubtaskEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubtaskMapper {

    SubtaskEntity toEntity(SubtaskDto dto);

    SubtaskDto toDto(SubtaskEntity entity);

}
