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
    private static List<Book> books;
    private static List<Author> authors;
    private static final Path BOOKSS_PATH = FileSystemService.getPathToFile("config", "books.json");

    public static void loadBooksFromFile() throws IOException {

        if (!Files.exists(BOOKSS_PATH)) {
            FileUtils.copyURLToFile(BookService.class.getClassLoader().getResource("books.json"), BOOKSS_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        books = objectMapper.readValue(BOOKSS_PATH.toFile(), new TypeReference<List<Book>>() {
        });
    }

    public static void  addBook(String title, Author author, Image cover, Text description, File file, ArrayList<String> comments) throws BookAlreadyExistsException
    {
        checkBookDoesNotAlreadyExists(title);
        books.add(new Book(title, author, cover, description, file, comments));
    }

    private static void checkBookDoesNotAlreadyExists(String title) throws BookAlreadyExistsException
    {
        for(Book book : books)
        {
            if (Objects.equals(title, book.getTitle()))
                throw new BookAlreadyExistsException(title);
        }
    }

    public static void searchBook(String title, Author name) throws AuthorDoesNotExistException, BookDoesNotExistException
    {
        for(Author author : authors)
            if(!Objects.equals(author, name.getName()))
                throw new AuthorDoesNotExistException(name);

        for(Book book : books)
        {
            if(!Objects.equals(title, book.getTitle()))
                throw new BookDoesNotExistException(title);
        }
    }
}
