package com.taskManager.repository;

import com.taskManager.model.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

    List<CommentEntity> findAllByTaskId(Integer id);

}
