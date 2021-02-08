package com.JavaDevSpring.service.impl;

import com.JavaDevSpring.model.Comment;
import com.JavaDevSpring.model.Genre;
import com.JavaDevSpring.repository.GenreRepository;
import com.JavaDevSpring.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    public GenreServiceImpl(GenreRepository repository) {
        GenreServiceImpl.repository = repository;
    }

    public GenreRepository getRepository() {
        return repository;
    }

    public void setRepository(GenreRepository repository) {
        GenreServiceImpl.repository = repository;
    }

    @Autowired
    private static GenreRepository repository;

    @Override
    public List<Genre> getAll() {
        List<Genre> genresList = repository.findAll();
        for (Genre genres : genresList) {
            System.out.println(genres.getNameOfGenre());
        }
        return null;
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
    public Genre update(int id, Genre genre) {
        //TODO: ID?
        return repository.save(genre);
    }

    @Override
    public void delete(Integer id) {
        repository.findById(id).ifPresent(Book -> repository.delete(Book));
    }
}
