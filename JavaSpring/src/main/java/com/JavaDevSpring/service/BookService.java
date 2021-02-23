package com.JavaDevSpring.service;

import com.JavaDevSpring.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<?> getAll();

    Optional<Book> findById(int id);

    Book save(Book book);

    Book update(int id, Book book);

    void delete(int id);
}
