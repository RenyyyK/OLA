package org.loose.fis.registration.example.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.registration.example.Main;
import org.loose.fis.registration.example.classes.Author;
import org.loose.fis.registration.example.classes.Book;
import org.loose.fis.registration.example.services.BookService;

import java.io.IOException;
import java.util.ArrayList;

public class ReaderHomePageController {
    Stage stage = Main.getStage();

    @FXML
    private TextField searchForBook;
    @FXML
    private TextField searchForAuthor;

    private ArrayList<Book> Favorites;
    private ArrayList<Book> CurrentlyReading;
    private ArrayList<Book> WantToRead;
    private ArrayList<Book> FinishedBooks;
    private ArrayList<Author> followedAuthors;
    private ArrayList<String> quotes;

    public ReaderHomePageController() {
        Favorites = new ArrayList<Book>();
        CurrentlyReading = new ArrayList<Book>();
        WantToRead = new ArrayList<Book>();
        FinishedBooks = new ArrayList<Book>();
        followedAuthors = new ArrayList<Author>();
        quotes = new ArrayList<String>();
    }

    public void addBookToList(Book b, ArrayList<Book> a){
        a.add(b);
    }

    public ArrayList<Book> getFavorites() {
        return Favorites;
    }

    public ArrayList<Book> getCurrentlyReading() {
        return CurrentlyReading;
    }

    public ArrayList<Book> getWantToRead() {
        return WantToRead;
    }

    public ArrayList<Book> getFinishedBooks() {
        return FinishedBooks;
    }

    public ArrayList<Author> getFollowedAuthors() {
        return followedAuthors;
    }

    public ArrayList<String> getQuotes() {
        return quotes;
    }

    public void handleFavorites(){
        ListView<Button> list = new ListView<Button>();
        for(Book b : Favorites) {
            ImageView iw = new ImageView(b.getCover());
            Button button = new Button(b.getTitle(), iw);
            list.getItems().add(button);
        }
        Scene s = new Scene(list, 500, 500);
        stage.setScene(s);
        stage.show();
    }

    public void handleCurrentlyReading(){
        ListView<Button> list = new ListView<Button>();
        for(Book b : CurrentlyReading) {
            ImageView iw = new ImageView(b.getCover());
            Button button = new Button(b.getTitle(), iw);
            list.getItems().add(button);
        }
        Scene s = new Scene(list, 500, 500);
        stage.setScene(s);
        stage.show();
    }

    public void handleWantToRead(){
        ListView<Button> list = new ListView<Button>();
        for(Book b : WantToRead) {
            ImageView iw = new ImageView(b.getCover());
            Button button = new Button(b.getTitle(), iw);
            list.getItems().add(button);
        }
        Scene s = new Scene(list, 500, 500);
        stage.setScene(s);
        stage.show();
    }

    public void handleFinishedReading(){
        ListView<Button> list = new ListView<Button>();
        for(Book b : FinishedBooks) {
            ImageView iw = new ImageView(b.getCover());
            Button button = new Button(b.getTitle(), iw);
            list.getItems().add(button);
        }
        Scene s = new Scene(list, 500, 500);
        stage.setScene(s);
        stage.show();
    }

    public void handleAuthorsList() throws IOException {
        ListView<Button> list = new ListView<Button>();
        for(Author a : followedAuthors) {
            Button button = new Button(a.getName());
            //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("BookPage.fxml"));
            //button.setOnAction();
            list.getItems().add(button);
        }
        Scene s = new Scene(list, 500, 500);
        this.stage.setScene(s);
        this.stage.show();
    }

    public void handleQuoteList(){
        ListView<String> list = new ListView<String>();
        for(String s : quotes) {
            list.getItems().add(s);
        }
        Scene s = new Scene(list, 500, 500);
        this.stage.setScene(s);
        this.stage.show();
    }

    public void followAuthor(Author a){
        if(!followedAuthors.contains(a)) followedAuthors.add(a);
    }

    public void searchBook(){
        String title = searchForBook.getText();
        Book b = BookService.searchBook(title);
        ListView<Book> book = new ListView<>();
        Scene s = new Scene(book, 500, 500);
        stage.setScene(s);
        stage.show();
    }

    public void searchAuthor(){
        String name = searchForAuthor.getText();
        Author a = BookService.searchAuthorByName(name);
        ListView<Author> author = new ListView<>();
        Scene s = new Scene(author, 500, 500);
        stage.setScene(s);
        stage.show();
    }

    //public void openBookPage(){}
}
