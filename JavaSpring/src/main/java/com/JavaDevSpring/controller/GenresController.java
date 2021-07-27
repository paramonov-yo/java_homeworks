package com.JavaDevSpring.controller;
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

    @GetMapping("/add_genres")
    public String getRedirectAddGenres() {
        return "/add_genre";
    }

    @GetMapping("/delete_genres")
    public String getRedirectDelGenres(Model model) {
        List<Genre> genres = genreRepository.findAll();
        model.addAttribute("genres", genres);
        return "/delete_genre";
    }

    @GetMapping("/update_genres")
    public String getRedirectUpdGenres() {
        return "/update_genre";
    }

    @PostMapping("/add_genre_act")
    public String createGenre (@RequestParam (required = false, name = "genre") String genreName) {
        System.out.println("genreName: " + genreName);
        genreRepository.save(new Genre(++sequenceG, genreName));
        return  "redirect:/genres";
    }

    @PostMapping("/delete_genres_sel")
    public String deleteGenreSelect (@RequestParam(value = "genreIdSel", defaultValue = "0")  Integer genreId) {

        System.out.println("(Select) genreId: " + genreId);
        try {
            genreRepository.deleteById(genreId);
            System.out.println("delete_genres: (Select) Удален жанр с ID = "  + genreId);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("delete_genres: (Select) Такого ID еще не существует в таблице");
        }
            return  "redirect:/genres";
    }

    @PostMapping("/delete_genres")
    public String deleteGenre (@RequestParam (required = false, name = "genreID") int genreId) {
        String link = "redirect:/genres";
        try {
            if (!genreRepository.existsById(genreId)) {
                link = "redirect:/delete_genres";
            }
            genreRepository.deleteById(genreId);
            System.out.println("delete_genres: Удален жанр с ID = " + genreId);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("delete_genres: ID = "+ genreId + " на данный момент не существует в таблице");
        }
        return link;
    }

    @PutMapping("/update_genre")
    public String updateGenres (@RequestParam(required = false, name = "genreIDUpd" ) int genreId,
                                 @RequestParam(required = false, name = "genreName" ) String genreName)
    {
        String link = "redirect:/genres";
        System.out.println("genreId: " + genreId);
        System.out.println("genreName: " + genreName);

        if (!genreRepository.existsById(genreId)) {
            link = "redirect:/update_genre";
            System.out.println("update_genre: ID = "+ genreId + " на данный момент не существует в таблице");
        } else {
            Genre genre = new Genre();
            genre.setNameOfGenre(genreName);
            genre.setId(genreId);
            genreRepository.save(genre);
            System.out.println("Обновлен автор с ID = " + genreId);
            System.out.println("Обновленное название жанра: " + genre.getNameOfGenre());
        }
        return link;
    }
}
