package com.JavaDevSpring.service;

import com.JavaDevSpring.model.Author;

import java.util.List;

public interface AuthorQueryService {
	
	List<Author> getAll();

	List<Author> getAuthorByFirstName(String firstName);

	Author getAuthorByLastName(String lastName);

	Author save(Author author);

	Author update(int id, Author author);

	void delete(int id);

}
