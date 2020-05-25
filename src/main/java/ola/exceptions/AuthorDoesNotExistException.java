package ola.exceptions;

import ola.classes.Author;

public class AuthorDoesNotExistException extends Exception {

    public AuthorDoesNotExistException(Author name) {
        super(String.format("The author %s does not exist in the database!", name.getName()));
    }
}
