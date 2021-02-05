package com.JavaDevSpring.dao;


import com.JavaDevSpring.model.Book;
import com.JavaDevSpring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@Component
public class BookDAO {

    private static int sequence;
    private Book book;
    String bookName;

    @Autowired
    private BookRepository bookRepository;

//    @Autowired
//    public BookDAO (BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

//    public void addBook(Book book){
//        this.book = book;
//        System.out.println(this.book.getBookName());
//        System.out.println(this.book.getId());
//        bookRepository.save(book);
//        //new Book(++sequence, bookName)
//    }

    public void addBook(String bookName){
        this.bookName = bookName;
        System.out.println(this.bookName);
        System.out.println(bookName);
        bookRepository.save(new Book(++sequence, bookName));
        //new Book(++sequence, bookName)
    }

}
