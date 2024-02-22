package com.taskManager.mapper;

import com.taskManager.dto.UserDto;
import com.taskManager.model.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(UserDto dto);

    UserDto toDto(UserEntity entity);

}
