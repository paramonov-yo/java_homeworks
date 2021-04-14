package com.JavaDevSpring.controller;

import com.JavaDevSpring.model.Author;
import com.JavaDevSpring.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@Controller
public class AuthorsController {

    public AuthorsController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private final AuthorRepository authorRepository;
    private static int sequenceA = 0;


    @GetMapping("/authors")
    public String getAuthors(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "/authors_page";
    }

    @PostMapping("/authors")

        public String createAuthor (@RequestParam(required = false, name = "first_name" ) String authorFirstName,
                                    @RequestParam(required = false, name = "last_name" ) String authorLastName) {
        System.out.println("authorName: " + authorFirstName);
        System.out.println("authorLastName: " + authorLastName);
        authorRepository.save(new Author(++sequenceA, authorFirstName, authorLastName));
        return  "redirect:/authors";
    }

    @PostMapping("/delete_authors_sel")
    public String deleteAuthorSelect (@RequestParam(value = "authorIdSel")  Integer authorId) {
        System.out.println("authorId: " + authorId);
        if (!authorRepository.existsById(authorId)) {
            System.out.println("Такого ID еще не существует в таблице");
        } else {
            authorRepository.deleteById(authorId);
            System.out.println("Удален автор с ID = " + authorId);        }
        return  "redirect:/authors";
    }

    @PostMapping("/delete_authors")
    public String deleteAuthor (@RequestParam (required = false, name = "authorID") int authorId) {
        if (!authorRepository.existsById(authorId)) {
            System.out.println("Такого ID еще не существует в таблице");
        } else {
            authorRepository.deleteById(authorId);
            System.out.println("Удален автор с ID = " + authorId);
        }
        return  "redirect:/authors";
    }

    @PutMapping("/update_author")
    public String updateAuthors (@RequestParam(required = false, name = "authorIDUpd" ) int authorId,
                               @RequestParam(required = false, name = "author_fist_name" ) String firstName,
                               @RequestParam(required = false, name = "author_last_name" ) String lastName)
    {
        System.out.println("authorId: " + authorId);
        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);

        if (!authorRepository.existsById(authorId)) {
            System.out.println("Такого ID еще не существует в таблице");
        } else {
            Author author = new Author();
            author.setFirstName(firstName);
            author.setLastName(lastName);
            author.setId(authorId);
            authorRepository.save(author);
            System.out.println("Обновлен автор с ID = " + authorId);
            System.out.println("Обновленное имя автора: " + author.getFirstName());
            System.out.println("Обновленная фамилия автора: " + author.getLastName());
        }
        return  "redirect:/authors";
    }
}
