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

    @GetMapping("/add_books")
    public String getRedirectAddBooks() {
        return "/add_book";
    }

    @GetMapping("/delete_books")
    public String getRedirectDelBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "/delete_book";
    }

    @GetMapping("/update_books")
    public String getRedirectUpdBooks() {
        return "/update_book";
    }

    @PostMapping("/books")
    public String createBook (@RequestParam (required = false, name = "book") String bookName) {
        System.out.println("bookName: " + bookName);
        bookRepository.save(new Book(++sequenceB, bookName));
        return  "redirect:/books";
    }

    @PostMapping("/delete_books_sel")
    public String deleteBookSelect (@RequestParam(value = "bookIdSel", defaultValue = "0")  Integer bookId /*, Model model*/) {
        System.out.println("bookId: " + bookId);
        try {
            bookRepository.deleteById(bookId);
            System.out.println("(Select) Удалена книга с ID = "  + bookId);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("delete_books(Select): Такого ID еще не существует в таблице");
        }
        return  "redirect:/books";
    }

    @PostMapping("/delete_books")
    public String deleteBook (@RequestParam (required = false, name = "bookID") int bookId) {
        String link = "redirect:/books";
        try {
            if (!bookRepository.existsById(bookId)) {
                link = "redirect:/delete_books";
            }
            bookRepository.deleteById(bookId);
            System.out.println("Удалена книга с ID = " + bookId);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("delete_books: ID = "+ bookId + " на данный момент не существует в таблице");
        }
        return link;
    }

@PutMapping("/update_book")
    public String updateBooks (@RequestParam(required = false, name = "bookIDUpd" ) int bookId,
                               @RequestParam(required = false, name = "book_name" ) String bookName) {
        System.out.println("bookId: " + bookId);
        System.out.println("book_name: " + bookName);
        String link = "redirect:/books";
        if (!bookRepository.existsById(bookId)) {
            link = "redirect:/update_book";
            System.out.println("update_books: ID = "+ bookId + " на данный момент не существует в таблице");
        } else {
            Book book = new Book();
            book.setBookName(bookName);
            book.setId(bookId);
            bookRepository.save(book);
            System.out.println("Обновлена книга с ID = " + bookId);
            System.out.println("Обновленное имя книги: " + book.getBookName());
            System.out.println("ID книги: " + book.getId());
        }
        return link;
    }

}

