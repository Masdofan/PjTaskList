package com.taskManager.repository;

import com.taskManager.model.TaskEntity;
import com.taskManager.model.UserEntity;
import com.taskManager.model.enums.TaskStatus;
import com.taskManager.model.enums.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

    Optional<TaskEntity> findById(Integer id);

    List<TaskEntity> findAllByExecutor_Id (Integer id);

    List<TaskEntity> findAllByStatus (TaskStatus status);

    List<TaskEntity> findAllByDescriptionEquals(String string);

    List<TaskEntity> findAllByDescriptionNotLike(String string);

    @Modifying
    @Query(value = "update Tasks set name = :name where id = :id")
    void updateName(Integer id, String name);

    @Modifying
    @Query(value = "update Tasks set summary = :summary where id = :id")
    void updateSummary(Integer id, String summary);

    @Modifying
    @Query(value = "update Tasks set description = :description where id = :id")
    void updateDescription(Integer id, String description);

    @Modifying
    @Query(value = "update Tasks set type = :type where id = :id")
    void updateType(Integer id, TaskType type);

    @Modifying
    @Query(value = "update Tasks set status = :status where id = :id")
    void updateStatus(Integer id, TaskStatus status);

    @Modifying
    @Query(value = "update Tasks set expDate = :expDate where id = :id")
    void updateExpDate(Integer id, LocalDate expDate);

    @Modifying
    @Query(value = "update Tasks set executor = :executor where id = :id")
    void updateExecutor(Integer id, UserEntity executor);

    void deleteById(Integer id);

}
