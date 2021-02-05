package com.JavaDevSpring.repository;

import com.JavaDevSpring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
//    Book findById(int id);
//
    //List<Book> getBooks(String bookName);
}

//@Repository
//public interface BookRepository extends JpaRepository<String, Integer> {
////    Book findById(int id);
////
//    //List<Book> getBooks(String bookName);
//}
