package com.JavaDevSpring.model;

import javax.persistence.*;

@Entity
@Table
public class Genre {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String NameOfGenre;

    public Genre() {
    }

    public Genre(int id, String nameOfGenre) {
        this.id = id;
        this.NameOfGenre = nameOfGenre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfGenre() {
        return NameOfGenre;
    }

    public void setNameOfGenre(String nameOfGenre) {
        NameOfGenre = nameOfGenre;
    }
}
