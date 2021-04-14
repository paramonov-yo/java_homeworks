package com.JavaDevSpring.controller;
import com.JavaDevSpring.model.Author;
import com.JavaDevSpring.model.Genre;
import com.JavaDevSpring.repository.GenreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GenresController {

    public GenresController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    private final GenreRepository genreRepository;
    private static int sequenceG = 0;


    @GetMapping("/genres")
    public String getGenres(Model model) {
        List<Genre> genres = genreRepository.findAll();
        model.addAttribute("genres", genres);
        return "/genres_page";
    }

    @PostMapping("/genres")
    public String createGenre (@RequestParam (required = false, name = "genre") String genreName) {
        System.out.println("genreName: " + genreName);
        genreRepository.save(new Genre(++sequenceG, genreName));
        return  "redirect:/genres";
    }


    @PostMapping("/delete_genres_sel")
    public String deleteGenreSelect (@RequestParam(value = "genreIdSel")  Integer genreId) {
        System.out.println("genreId: " + genreId);
        if (!genreRepository.existsById(genreId)) {
            System.out.println("Такого ID еще не существует в таблице");
        } else {
            genreRepository.deleteById(genreId);
            System.out.println("Удален жанр с ID = " + genreId);        }
        return  "redirect:/genres";
    }

    @PostMapping("/delete_genres")
    public String deleteGenre (@RequestParam (required = false, name = "genreID") int genreId) {
        if (!genreRepository.existsById(genreId)) {
            System.out.println("Такого ID еще не существует в таблице");
        } else {
            genreRepository.deleteById(genreId);
            System.out.println("Удален жанр с ID = " + genreId);
        }
        return  "redirect:/genres";
    }

    @PutMapping("/update_genre")
    public String updateGenres (@RequestParam(required = false, name = "genreIDUpd" ) int genreId,
                                 @RequestParam(required = false, name = "genreName" ) String genreName)
    {
        System.out.println("genreId: " + genreId);
        System.out.println("genreName: " + genreName);

        if (!genreRepository.existsById(genreId)) {
            System.out.println("Такого ID еще не существует в таблице");
        } else {
            Genre genre = new Genre();
            genre.setNameOfGenre(genreName);
            genre.setId(genreId);
            genreRepository.save(genre);
            System.out.println("Обновлен автор с ID = " + genreId);
            System.out.println("Обновленное название жанра: " + genre.getNameOfGenre());
        }
        return  "redirect:/genres";
    }
}
