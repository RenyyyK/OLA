package org.loose.fis.registration.example.exceptions;

public class BookDoesNotExistException extends Exception {

    public BookDoesNotExistException(String book) {
        super(String.format("The book %s does not exist exist in the database!", book));
    }
}
