package org.loose.fis.registration.example.classes;

import java.util.ArrayList;

public class Author {
    private String name;
    public ArrayList<Book> books;
    public ArrayList<String> posts;

    public Author(String name) {
        this.name = name;
        books = new ArrayList<Book>();
        posts = new ArrayList<String>();
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

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
