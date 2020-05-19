package org.loose.fis.registration.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import org.apache.commons.io.FileUtils;
import org.loose.fis.registration.example.classes.Author;
import org.loose.fis.registration.example.classes.Book;
import org.loose.fis.registration.example.exceptions.*;
import org.loose.fis.registration.example.model.User;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookService {
    private static List<Author> authors;
    private static final Path BOOKS_PATH = FileSystemService.getPathToFile("config", "books.json");

    public static void loadAuthorsFromFile() throws IOException {

        if (!Files.exists(BOOKS_PATH)) {
            FileUtils.copyURLToFile(BookService.class.getClassLoader().getResource("books.json"), BOOKS_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        authors = objectMapper.readValue(BOOKS_PATH.toFile(), new TypeReference<List<Author>>() {
        });
    }

    private static void persistAuthors() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(BOOKS_PATH.toFile(), authors);
        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }

    private static void checkBooktAlreadyExists(String title) throws BookAlreadyExistsException
    {
        for(Author author : authors)
        {
            ArrayList<Book> books=author.getBooks();
            for(Book book : books)
            {
                if (Objects.equals(title, book.getTitle()))
                    throw new BookAlreadyExistsException(title);
            }
        }
    }

    private static void checkAuthorAlreadyExists(Author name) throws AuthorAlreadyExistsException
    {
        for(Author author : authors)
        {
            if (Objects.equals(name, author.getName()))
                throw new AuthorAlreadyExistsException(name);
        }
    }

    private static void checkBookDoesNotExist(String title) throws BookDoesNotExistException
    {
        int count=0;
        for(Author author : authors)
        {
            ArrayList<Book> books=author.getBooks();
            for(Book book : books)
            {
                if (Objects.equals(title, book.getTitle()))
                    count++;
            }
        }
        if(count==0)
            throw new BookDoesNotExistException(title);
    }

    private static void checkAuthorDoesNotExist(Author name) throws AuthorDoesNotExistException
    {
        int count=0;
        for(Author author : authors)
        {
            if (Objects.equals(name, author.getName()))
                count++;
        }
        if(count==0)
            throw new AuthorDoesNotExistException(name);
    }

    public static void  addBook(String title, Author author) throws BookAlreadyExistsException
    {
        checkBooktAlreadyExists(title);
        author.getBooks().add(new Book(title, author));
    }

    public static void  addBook(String title, Author author, Image cover) throws BookAlreadyExistsException
    {
        checkBooktAlreadyExists(title);
        author.getBooks().add(new Book(title, author, cover));
    }

    public static void  addBook(String title, Author author, Text description) throws BookAlreadyExistsException
    {
        checkBooktAlreadyExists(title);
        author.getBooks().add(new Book(title, author, description));
    }

    public static void  addBook(String title, Author author, File file) throws BookAlreadyExistsException
    {
        checkBooktAlreadyExists(title);
        author.getBooks().add(new Book(title, author, file));
    }

    public static void  addBook(String title, Author author, Image cover, Text description) throws BookAlreadyExistsException
    {
        checkBooktAlreadyExists(title);
        author.getBooks().add(new Book(title, author, cover, description));
    }

    public static void  addBook(String title, Author author, Image cover, File file) throws BookAlreadyExistsException
    {
        checkBooktAlreadyExists(title);
        author.getBooks().add(new Book(title, author, cover, file));
    }

    public static void  addBook(String title, Author author, Text description, File file) throws BookAlreadyExistsException
    {
        checkBooktAlreadyExists(title);
        author.getBooks().add(new Book(title, author, description, file));
    }

    public static void  addBook(String title, Author author, Image cover, Text description, File file) throws BookAlreadyExistsException
    {
        checkBooktAlreadyExists(title);
        author.getBooks().add(new Book(title, author, cover, description, file));
    }

    public static void addAuthor(Author author) throws AuthorAlreadyExistsException
    {
        checkAuthorAlreadyExists(author);
        authors.add(author);
    }

    public static void deleteBook(String title, Author author) throws BookDoesNotExistException
    {
        checkBookDoesNotExist(title);
        ArrayList<Book> books=author.getBooks();
        for(Book book : books)
            if(book.getTitle().equals(title)) {
                Book b = book;
                books.remove(b);
            }
    }

    public static void deleteBook(String title) throws  BookDoesNotExistException
    {
        checkBookDoesNotExist(title);
        for(Author author : authors)
        {
            ArrayList<Book> books=author.getBooks();
            for(Book book : books)
                if(book.getTitle().equals(title)) {
                    Book b = book;
                    books.remove(b);
                }
        }
    }

    public static  void deleteAuthor(Author name) throws AuthorDoesNotExistException, BookDoesNotExistException
    {
        checkAuthorDoesNotExist(name);
        for(Author author : authors)
            if(author.getName().equals(name.getName()))
            {
                ArrayList<Book> books=author.getBooks();
                for(Book book : books)
                    deleteBook(book.getTitle(), author);
                authors.remove(author);
            }
    }

    public static Book searchBook(String title, Author name) //throws AuthorDoesNotExistException, BookDoesNotExistException
    {
        //checkBookDoesNotExist(title);
        ArrayList<Book> books=name.getBooks();
        for(Book book : books)
            if(book.getTitle().equals(title))
                return book;
        return null;
    }

    public static Book searchBook(String title) //throws AuthorDoesNotExistException, BookDoesNotExistException
    {
        //checkBookDoesNotExist(title);
        for(Author author : authors)
        {
            ArrayList<Book> books=author.getBooks();
            for(Book book : books)
                if(book.getTitle().equals(title))
                    return book;
        }
        return null;
    }

    public static Author searchAuthor(Author name) //throws AuthorDoesNotExistException
    {
        //checkAuthorDoesNotExist(name);
        for(Author author : authors)
            if(author.getName().equals(name.getName()))
                return author;
        return null;
    }

    public static Author searchAuthorByName(String name) //throws AuthorDoesNotExistException
    {
        //checkAuthorDoesNotExist(name);
        for(Author author : authors)
            if(author.getName().equals(name))
                return author;
        return null;
    }
}
