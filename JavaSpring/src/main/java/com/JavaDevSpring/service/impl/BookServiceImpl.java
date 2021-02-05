package com.JavaDevSpring.service.impl;

import com.JavaDevSpring.model.Book;
import com.JavaDevSpring.repository.BookRepository;
import com.JavaDevSpring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> findAll() {
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

//    @Override
//    public Book findById(int id) {
//        return repository.findById(id);
//    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    public Book update(int id, Book book) {
        return repository.save(book);
    }

    @Override
    public void delete(int id) {
        repository.findById(id).ifPresent(Book -> repository.delete(Book));
    }
}
