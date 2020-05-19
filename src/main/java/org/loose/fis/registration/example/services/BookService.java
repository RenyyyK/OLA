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

    private static void checkBookDoesNotAlreadyExists(String title) throws BookAlreadyExistsException
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

    private static void checkAuthorDoesNotAlreadyExists(Author name) throws AuthorAlreadyExistsException
    {
        for(Author author : authors)
        {
            if (Objects.equals(name, author.getName()))
                throw new AuthorAlreadyExistsException(name);
        }
    }

}
