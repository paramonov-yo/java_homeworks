package com.JavaDevSpring.service;

import com.JavaDevSpring.model.Genre;

import java.util.List;

public interface GenreService {

    List<?> findAll();

    Genre findById(Integer id);

    Genre save(Genre genre);

    Genre update(Genre genre);

    void delete(Integer id);
}
