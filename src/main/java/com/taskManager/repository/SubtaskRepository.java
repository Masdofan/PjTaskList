package com.taskManager.repository;

import com.taskManager.model.SubtaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubtaskRepository extends JpaRepository<SubtaskEntity, Integer> {

    List<SubtaskEntity> findAllByMainTaskId (Integer id);

}
