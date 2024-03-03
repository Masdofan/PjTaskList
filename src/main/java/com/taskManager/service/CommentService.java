package com.taskManager.service;

import com.taskManager.model.CommentEntity;

import java.util.List;

public interface CommentService {

    List<CommentEntity> getComms();

    List<CommentEntity> getCommsByTaskId(Integer id);

    void save(CommentEntity comment);

}
