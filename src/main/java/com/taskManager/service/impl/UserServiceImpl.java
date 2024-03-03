package com.taskManager.service.impl;

import com.taskManager.dto.UserDto;
import com.taskManager.mapper.UserMapper;
import com.taskManager.model.UserEntity;
import com.taskManager.repository.UserRepository;
import com.taskManager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserMapper mapper;
    private final UserRepository repository;

    @Override
    public void save(UserDto userDto) {
        UserEntity entity = mapper.toEntity(userDto);

        repository.save(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElse(null);
    }

    @Override
    public List<UserEntity> getUsers() {
        return repository.findAll();
    }

    @Override
    public UserEntity getById(Integer id) {
        Optional<UserEntity> byId = repository.findById(id);
        return byId.get();
    }
}
