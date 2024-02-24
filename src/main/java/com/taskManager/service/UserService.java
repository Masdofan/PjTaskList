package com.taskManager.service;

import com.taskManager.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    void save(UserDto userDto);

    public UserDetails loadUserByUsername(String username);

}
