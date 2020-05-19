package org.loose.fis.registration.example.exceptions;

public class BookAlreadyExistsException extends Exception {

    public BookAlreadyExistsException(String book) {
        super(String.format("The book %s already exists in the database!", book));
    }
}
