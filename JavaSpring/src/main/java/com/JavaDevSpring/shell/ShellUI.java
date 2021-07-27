package com.JavaDevSpring.shell;

import com.JavaDevSpring.model.Author;
import com.JavaDevSpring.model.Book;
import com.JavaDevSpring.model.Comment;
import com.JavaDevSpring.model.Genre;
import com.JavaDevSpring.service.impl.AuthorServiceImpl;
import com.JavaDevSpring.service.impl.BookServiceImpl;
import com.JavaDevSpring.service.impl.CommentServiceImpl;
import com.JavaDevSpring.service.impl.GenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;


@ShellComponent
public class ShellUI {

    @Autowired
    public ShellUI(AuthorServiceImpl authorService, BookServiceImpl bookService, CommentServiceImpl commentService, GenreServiceImpl genreService) {

        this.authorService = authorService;
        this.bookService = bookService;
        this.commentService = commentService;
        this.genreService = genreService;
    }

    private final AuthorServiceImpl authorService;
    private final BookServiceImpl bookService;
    private final CommentServiceImpl commentService;
    private final GenreServiceImpl genreService;

    private static int sequenceC = 0;
    private static int sequenceB = 0;
    private static int sequenceA = 0;
    private static int sequenceG = 0;


//Books: AddBook (addB)
    @ShellMethod(value = "Add Book", key = {"addB", "bookName"})
    public String addBook(@ShellOption(defaultValue = "Little Red Riding Hood") String bookName){
        bookService.save(new Book(++sequenceB, bookName));
        return String.format("Вы добавили книгу %s", bookName);
    }
//Books: GetBooks (getB)
    @ShellMethod(value = "Get all Books", key = {"getB"})
    public Object getBooks(){
         if (bookService.getRepository().count() == 0) {
            return String.format("Данные по книгам отсутствуют, добавьте книгу");
        } else {
             bookService.getAll();
             return null;
        }
    }
//Author: AddAuthor(addA)
    @ShellMethod(value = "Add Author", key = {"addA", "AuthorFirstName", "AuthorLastName"})
    public String addAuthor(String authorFirstName, String authorLAstName){
        authorService.save(new Author(++sequenceA, authorFirstName, authorLAstName));
        return String.format("Вы добавили нового автора %s %s", authorFirstName, authorLAstName);
    }
//Author: GetAuthors(getA)
    @ShellMethod(value = "Get all Authors", key = {"getA"})
    public Object getAuthors(){
        if (authorService.getRepository().count() == 0) {
            return String.format("Данные по авторам отсутствуют, добавьте автора");
        } else {
            authorService.getAll();
            return null;
        }
}
//Comment: AddComment (addC)
    @ShellMethod(value = "Add Comment", key = {"addC", "BookName", "Comment"})
    public String addComment(String bookName, String comment){
        commentService.save(new Comment(++sequenceC, bookName, comment));
        return String.format("Вы добавили новый комментарий к книге %s", bookName);
    }
//Comment: GetComments (getC)
    @ShellMethod(value = "Get all Comments", key = {"getC"})
    public Object getComments(){
        if (commentService.getRepository().count() == 0) {
            return String.format("Данные по комментариям отсутствуют, добавьте комментарий");
        } else {
            commentService.getAll();
            return null;
        }
    }
//Genre: AddGenre (addG)
    @ShellMethod(value = "Add Genre", key = {"addG", "GenreName"})
    public String addGenre(String nameOfGenre){
        genreService.save(new Genre(++sequenceG, nameOfGenre));
        return String.format("Вы добавили новый жанр %s", nameOfGenre);
    }
//Genre: GetGenres (getG)
    @ShellMethod(value = "Get all Genres", key = {"getG"})
    public Object getGenres(){
        if (genreService.getRepository().count() == 0) {
            return String.format("Данные по жанрам отсутствуют, добавьте новый жанр");
        } else {
            genreService.getAll();
            return null;
        }
    }
}
