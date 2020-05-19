package org.loose.fis.registration.example.exceptions;

public class UserDoesNotExistException extends Exception {

    private String username;

    public UserDoesNotExistException(String username) {
        super(String.format("There is no account with the username %s!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}