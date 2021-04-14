package com.JavaDevSpring.controller;

import com.JavaDevSpring.model.Book;
import com.JavaDevSpring.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class BooksController {
    public BooksController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private final BookRepository bookRepository;
    private static int sequenceB = 0;


    @GetMapping("/books")
    public String getBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "/books_page";
    }

    @PostMapping("/books")
    public String createBook (@RequestParam (required = false, name = "book") String bookName) {
        System.out.println("bookName: " + bookName);
        bookRepository.save(new Book(++sequenceB, bookName));
        return  "redirect:/books";
    }

    @PostMapping("/delete_books_sel")
    public String deleteBookSelect (@RequestParam(value = "bookIdSel")  Integer bookId /*, Model model*/) {
        System.out.println("bookId: " + bookId);
        if (!bookRepository.existsById(bookId)) {
                System.out.println("Такого ID еще не существует в таблице");
        } else {
            bookRepository.deleteById(bookId);
            System.out.println("Удалена книга с ID = " + bookId);
        }
        return  "redirect:/books";
    }

    @PostMapping("/delete_books")
    public String deleteBook (@RequestParam (required = false, name = "bookID") int bookId) {
            if (!bookRepository.existsById(bookId)) {
                System.out.println("Такого ID еще не существует в таблице");
        } else {
            bookRepository.deleteById(bookId);
            System.out.println("Удалена книга с ID = " + bookId);
        }
        return  "redirect:/books";
    }

@PutMapping("/update_book")
    public String updateBooks (@RequestParam(required = false, name = "bookIDUpd" ) int bookId,
                               @RequestParam(required = false, name = "book_name" ) String bookName) {
        System.out.println("bookId: " + bookId);
        System.out.println("book_name: " + bookName);

        if (!bookRepository.existsById(bookId)) {
            System.out.println("Такого ID еще не существует в таблице");
        } else {
            Book book = new Book();
            book.setBookName(bookName);
            book.setId(bookId);
            bookRepository.save(book);
            System.out.println("Обновлена книга с ID = " + bookId);
            System.out.println("Обновленное имя книги: " + book.getBookName());
            System.out.println("ID книги: " + book.getId());
        }
        return  "redirect:/books";
    }

}

