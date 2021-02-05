package com.JavaDevSpring.shell;

import com.JavaDevSpring.model.Author;
import com.JavaDevSpring.model.Book;
import com.JavaDevSpring.model.Comment;
import com.JavaDevSpring.model.Genre;
import com.JavaDevSpring.repository.AuthorRepository;
import com.JavaDevSpring.repository.BookRepository;
import com.JavaDevSpring.repository.CommentRepository;
import com.JavaDevSpring.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;


@ShellComponent
public class ShellUI {
    private static final String NULL = null;

    //TODO: убрать в DAO

    @Autowired
	private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
  	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private GenreRepository genreRepository;

    private String bookName;
    private static int sequenceC = 0;
    private static int sequenceB = 0;
    private static int sequenceA = 0;
    private static int sequenceG = 0;

    //BookDAO bookDAO = new BookDAO(bookRepository);
    //BookDAO bookDAO = new BookDAO();

//Books: AddBook (addB)
    @ShellMethod(value = "Add Book", key = {"addB", "bookName"})
    public String addBook(@ShellOption(defaultValue = "Little Red Riding Hood") String bookName){
        bookRepository.save(new Book(++sequenceB, bookName));
        return String.format("Вы добавили книгу %s", bookName);
    }
//Books: GetBooks (getB)
    @ShellMethod(value = "Get all Books", key = {"getB"})
    public Object getBooks(){
         if (bookRepository.count() == 0) {
            return String.format("Данные по книгам отсутствуют, добавьте книгу");
        } else {
            System.out.println("Перечень добавленных книг: ");
             for (Book book : bookRepository.findAll()) {
                 System.out.println(book.getBookName());
             }
             return null;
        }
    }
//Author: AddAuthor(addA)
    @ShellMethod(value = "Add Author", key = {"addA", "AuthorFirstName", "AuthorLastName"})
    public String addAuthor(String authorFirstName, String authorLAstName){
        authorRepository.save(new Author(++sequenceA, authorFirstName, authorLAstName));
        return String.format("Вы добавили нового автора %s %s", authorFirstName, authorLAstName);
    }
//Author: GetAuthors(getA)
    @ShellMethod(value = "Get all Authors", key = {"getA"})
    public Object getAuthors(){
        if (authorRepository.count() == 0) {
            return String.format("Данные по авторам отсутствуют, добавьте автора");
        } else {
            System.out.println("Перечень добавленных авторов: ");
            for (Author author : authorRepository.findAll()) {
                System.out.println(author.getFirstName() + " " + author.getLastName());
            }
            return null;
        }
}
//Comment: AddComment (addC)
    @ShellMethod(value = "Add Comment", key = {"addC", "BookName", "Comment"})
    public String addComment(String bookName, String comment){
        commentRepository.save(new Comment(++sequenceC, bookName, comment));
        return String.format("Вы добавили новый комментарий к книге %s", bookName);
    }
//Comment: GetComments (getC)
    @ShellMethod(value = "Get all Comments", key = {"getC"})
    public Object getComments(){
        if (commentRepository.count() == 0) {
            return String.format("Данные по комментариям отсутствуют, добавьте комментарий");
        } else {
            System.out.println("Перечень добавленных комментариев: ");
            for (Comment comment : commentRepository.findAll()) {
                System.out.println(comment.getComment());
            }
            return null;
        }
    }
//Genre: AddGenre (addG)
    @ShellMethod(value = "Add Genre", key = {"addG", "GenreName"})
    public String addGenre(String nameOfGenre){
        genreRepository.save(new Genre(++sequenceG, nameOfGenre));
        return String.format("Вы добавили новый жанр %s", nameOfGenre);
    }
//Genre: GetGenres (getG)
    @ShellMethod(value = "Get all Genres", key = {"getG"})
    public Object getGenres(){
        if (genreRepository.count() == 0) {
            return String.format("Данные по жанрам отсутствуют, добавьте новый жанр");
        } else {
            System.out.println("Перечень добавленных жанров: ");
            for (Genre genre : genreRepository.findAll()) {
                System.out.println(genre.getNameOfGenre());
            }
            return null;
        }
    }
}
