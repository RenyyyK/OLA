package org.loose.fis.registration.example.exceptions;

public class WrongPasswordException extends Exception {

    private String username;

    public WrongPasswordException(String username) {
        super(String.format("Wrong password for username %s!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
