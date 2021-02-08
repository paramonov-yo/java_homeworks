package com.JavaDevSpring.model;

import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String bookName;
    private String comment;

    public Comment() {
    }

    public Comment(int id, String bookName, String comment) {
        this.id = id;
        this.bookName = bookName;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
