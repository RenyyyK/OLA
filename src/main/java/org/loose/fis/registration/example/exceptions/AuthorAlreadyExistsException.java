package org.loose.fis.registration.example.exceptions;

import org.loose.fis.registration.example.classes.Author;

public class AuthorAlreadyExistsException extends Exception {

    public AuthorAlreadyExistsException(Author author) {
        super(String.format("The author %s already exists in the database!", author.getName()));
    }
}
