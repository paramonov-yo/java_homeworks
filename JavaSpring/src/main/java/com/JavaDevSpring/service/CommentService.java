package com.JavaDevSpring.service;


import com.JavaDevSpring.model.Comment;

import java.util.List;

public interface CommentService {
	
	List<Comment> getAll();

	Comment getCommentById(int CommId);

	Comment save(Comment comment);

	Comment update(int id, Comment comment);

	void delete(int id);
}
