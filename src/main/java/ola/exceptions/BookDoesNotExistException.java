package ola.exceptions;

public class BookDoesNotExistException extends Exception {

    public BookDoesNotExistException(String book) {
        super(String.format("The book %s does not exist in the database!", book));
    }
}
