package com.JavaDevSpring.repository;

import com.JavaDevSpring.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
