package com.JavaDevSpring.service.impl;

import com.JavaDevSpring.model.Comment;
import com.JavaDevSpring.repository.CommentRepository;
import com.JavaDevSpring.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository repository;

    @Override
    public List<Comment> getAll() {
        return null;
    }

    @Override
    public Comment getCommentById(int commId) {
        return repository.findById(commId).orElse(new Comment());
    }

    @Override
    public Comment save(Comment comment) {
        return repository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
        return repository.save(comment);
    }

    @Override
    public void delete(int id) {

    }
}
