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

    @GetMapping("/add_authors")
    public String getRedirectAddAuthors() {
        return "/add_author";
    }

    @GetMapping("/delete_authors")
    public String getRedirectDelAuthors(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "/delete_author";
    }

    @GetMapping("/update_authors")
    public String getRedirectUpdAuthors() {
        return "/update_author";
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
    public String deleteAuthorSelect (@RequestParam(value = "authorIdSel", defaultValue = "0")  Integer authorId) {
        System.out.println("authorId: " + authorId);
        try {
            authorRepository.deleteById(authorId);
            System.out.println("delete_authors: (Select) Удален автор с ID = "  + authorId);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("delete_authors: (Select) Такого ID еще не существует в таблице");
        }
        return  "redirect:/authors";
    }

    @PostMapping("/delete_authors")
    public String deleteAuthor (@RequestParam (required = false, name = "authorID") int authorId) {
        String link = "redirect:/authors";
        try {
            if (!authorRepository.existsById(authorId)) {
                link = "redirect:/delete_authors";
            }
            authorRepository.deleteById(authorId);
            System.out.println("delete_authors: Удален автор с ID = "  + authorId);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("delete_authors: ID = "+ authorId + " на данный момент не существует в таблице");
        }
        return link;
    }

    @PutMapping("/update_author")
    public String updateAuthors (@RequestParam(required = false, name = "authorIDUpd" ) int authorId,
                               @RequestParam(required = false, name = "author_fist_name" ) String firstName,
                               @RequestParam(required = false, name = "author_last_name" ) String lastName)
    {
        String link = "redirect:/authors";
        System.out.println("authorId: " + authorId);
        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);

        if (!authorRepository.existsById(authorId)) {
            link = "redirect:/update_author";
            System.out.println("update_authors: ID = "+ authorId + " на данный момент не существует в таблице");
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
        return link;
    }
}
