package com.JavaDevSpring.model;


import javax.persistence.*;


@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String bookName;

    public Book() {
    }

    public Book(int id, String bookName) {
        this.id = id;
        this.bookName = bookName;
    }

    public Book(String bookName) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
