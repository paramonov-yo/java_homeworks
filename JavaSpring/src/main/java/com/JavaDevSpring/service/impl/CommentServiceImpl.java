package com.JavaDevSpring.service.impl;

import com.JavaDevSpring.model.Comment;
import com.JavaDevSpring.repository.CommentRepository;
import com.JavaDevSpring.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {


    public CommentServiceImpl(CommentRepository repository) {
        CommentServiceImpl.repository = repository;
    }

    public CommentRepository getRepository() {
        return repository;
    }

    public void setRepository(CommentRepository repository) {
        CommentServiceImpl.repository = repository;
    }

    @Autowired
    private static CommentRepository repository;

    @Override
    public List<Comment> getAll() {
        List<Comment> commentList = repository.findAll();
        for (Comment comment : commentList) {
            System.out.println(comment.getComment());
        }
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
    public Comment update(int id, Comment comment) {
        //TODO: ID?
        return repository.save(comment);
    }

    @Override
    public void delete(int id) {

    }
}
