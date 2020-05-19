package org.loose.fis.registration.example.classes;

import java.util.ArrayList;

public class Author {
    private String name;
    public ArrayList<Book> books;

    public Author(String name) {
        this.name = name;
        books = new ArrayList<Book>();
    }

    public Author(){
        books = new ArrayList<>();
    }

    public void addBook(Book b){
        books.add(b);
    }

    public void deleteBook(Book b){
        books.remove(b);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
