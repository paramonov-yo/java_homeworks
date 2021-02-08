package com.JavaDevSpring.service.impl;

import com.JavaDevSpring.model.Book;
import com.JavaDevSpring.repository.BookRepository;
import com.JavaDevSpring.repository.GenreRepository;
import com.JavaDevSpring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    public BookServiceImpl(BookRepository repository) {
        BookServiceImpl.repository = repository;
    }

    public BookRepository getRepository() {
        return repository;
    }

    public void setRepository(BookRepository repository) {
        BookServiceImpl.repository = repository;
    }

    @Autowired
    private static BookRepository repository;

    @Override
    public List<Book> getAll() {
        List<Book> bookList = repository.findAll();
        for (Book book : bookList) {
        System.out.println(book.getBookName());
    }
            return null;
}

    @Override
    public Optional<Book> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    public Book update(int id, Book book) {
        //TODO: ID?
        return repository.save(book);
    }

    @Override
    public void delete(int id) {
        repository.findById(id).ifPresent(Book -> repository.delete(Book));
    }
}
