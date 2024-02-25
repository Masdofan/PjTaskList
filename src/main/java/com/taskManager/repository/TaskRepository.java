package com.taskManager.repository;

import com.taskManager.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

    List<TaskEntity> findAll();

    Optional<TaskEntity> findById(Integer id);

    List<TaskEntity> findAllByExecutor_Id(Integer id);

}
