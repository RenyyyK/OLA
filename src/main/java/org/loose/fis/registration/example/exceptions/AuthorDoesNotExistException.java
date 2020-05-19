package org.loose.fis.registration.example.exceptions;

import org.loose.fis.registration.example.classes.Author;

public class AuthorDoesNotExistException extends Exception {

    public AuthorDoesNotExistException(Author name) {
        super(String.format("The author %s does not exist in the database!", name.getName()));
    }
}
