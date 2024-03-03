package com.taskManager.service.impl;

import com.taskManager.model.CommentEntity;
import com.taskManager.repository.CommentRepository;
import com.taskManager.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public List<CommentEntity> getComms() {
        return commentRepository.findAll();
    }

    @Override
    public List<CommentEntity> getCommsByTaskId(Integer id) {
        return commentRepository.findAllByTaskId(id);
    }

    @Override
    public void save(CommentEntity comment) {
        commentRepository.save(comment);
    }

}
