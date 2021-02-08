package com.JavaDevSpring.service.impl;

import com.JavaDevSpring.model.Author;
import com.JavaDevSpring.model.Book;
import com.JavaDevSpring.repository.AuthorRepository;
import com.JavaDevSpring.repository.GenreRepository;
import com.JavaDevSpring.service.AuthorQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorQueryService {

	public AuthorServiceImpl(AuthorRepository repository) {
		AuthorServiceImpl.repository = repository;
	}

	List<Author> authors;
	private Author localAuthor;
	//TODO:  скорректировать
//	Author localAuthor;

	@Autowired
	private static AuthorRepository repository;

	public void setRepository(AuthorRepository repository) {
		AuthorServiceImpl.repository = repository;
	}

	public AuthorRepository getRepository() {
		return repository;
	}

	@Override
	public List<Author> getAll() {
		List<Author> authorList = repository.findAll();
		for (Author author : authorList) {
			System.out.println(author.getFirstName() + " " + author.getFirstName());
		}
		return null;
	}

	@Override
	public List<Author> getAuthorByFirstName(String firstName) {
		authors = repository.findAll();
		localAuthor = null;
		for (Author author : authors) {
			if (author.getFirstName().equalsIgnoreCase(firstName))
				localAuthor = author;
		}
		return authors;
	}

	@Override
	public Author getAuthorByLastName(String lastName) {
		authors = repository.findAll();
		localAuthor = null;
		for (Author author : authors) {
			if (author.getLastName().equalsIgnoreCase(lastName))
				localAuthor = author;
		}
		return localAuthor;
	}

	@Override
	public Author save(Author author) {
		return repository.save(author);
	}

	@Override
	public Author update(int id, Author author) {
		//TODO: ID?
		return repository.save(author);
	}

	@Override
	public void delete(int id) {
		repository.findById(id).ifPresent(Author -> repository.delete(Author));
	}
}
