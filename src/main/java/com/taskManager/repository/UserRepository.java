package com.taskManager.repository;

import com.taskManager.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByUsername (String username);

    List<UserEntity> findAll();

    Optional<UserEntity> findById(Integer id);

}
