package com.JavaDevSpring.service.impl;

import com.JavaDevSpring.model.Genre;
import com.JavaDevSpring.repository.GenreRepository;
import com.JavaDevSpring.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository repository;

    @Override
    public List<Genre> findAll() {
        return repository.findAll();
    }

    @Override
    public Genre findById(Integer id) {
        return repository.findById(id).orElse(new Genre());
    }

    @Override
    public Genre save(Genre genre) {
        return repository.save(genre);
    }

    @Override
    public Genre update(Genre genre) {
        return repository.save(genre);
    }

    @Override
    public void delete(Integer id) {
        repository.findById(id).ifPresent(Book -> repository.delete(Book));
    }
}
