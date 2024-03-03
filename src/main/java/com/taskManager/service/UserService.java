package com.taskManager.service;

import com.taskManager.dto.UserDto;
import com.taskManager.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    void save(UserDto userDto);

    UserDetails loadUserByUsername(String username);

    List<UserEntity> getUsers();

    UserEntity getById(Integer id);

}
