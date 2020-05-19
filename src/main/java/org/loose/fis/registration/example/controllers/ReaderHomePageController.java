package org.loose.fis.registration.example.controllers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.loose.fis.registration.example.classes.Author;
import org.loose.fis.registration.example.classes.Book;

import java.util.ArrayList;

public class ReaderHomePageController {
    private ArrayList<Book> Favorites;
    private ArrayList<Book> CurrentlyReading;
    private ArrayList<Book> WantToRead;
    private ArrayList<Book> FinishedBooks;
    private ArrayList<Author> followedAuthors;
    private ArrayList<String> quotes;

    Stage homePage = new Stage();

    public ReaderHomePageController() {
        Favorites = new ArrayList<Book>();
        CurrentlyReading = new ArrayList<Book>();
        WantToRead = new ArrayList<Book>();
        FinishedBooks = new ArrayList<Book>();
        followedAuthors = new ArrayList<Author>();
        quotes = new ArrayList<String>();

        StackPane layout = new StackPane();
        Image wallpaper_image = new Image("https://bgwall.net/wp-content/uploads/2014/09/books-at-the-library-wallpaper-picture.jpg");
        BackgroundImage bi = new BackgroundImage(wallpaper_image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(bi);
        layout.setBackground(background);

        Scene scene = new Scene(layout, 500, 500);
        homePage.setScene(scene);
        homePage.show();
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
        this.homePage.setScene(s);
        this.homePage.show();
    }

    public void handleCurrentlyReading(){
        ListView<Button> list = new ListView<Button>();
        for(Book b : CurrentlyReading) {
            ImageView iw = new ImageView(b.getCover());
            Button button = new Button(b.getTitle(), iw);
            list.getItems().add(button);
        }
        Scene s = new Scene(list, 500, 500);
        this.homePage.setScene(s);
        this.homePage.show();
    }

    public void handleWantToRead(){
        ListView<Button> list = new ListView<Button>();
        for(Book b : WantToRead) {
            ImageView iw = new ImageView(b.getCover());
            Button button = new Button(b.getTitle(), iw);
            list.getItems().add(button);
        }
        Scene s = new Scene(list, 500, 500);
        this.homePage.setScene(s);
        this.homePage.show();
    }

    public void handleFinishedReading(){
        ListView<Button> list = new ListView<Button>();
        for(Book b : FinishedBooks) {
            ImageView iw = new ImageView(b.getCover());
            Button button = new Button(b.getTitle(), iw);
            list.getItems().add(button);
        }
        Scene s = new Scene(list, 500, 500);
        this.homePage.setScene(s);
        this.homePage.show();
    }

    public void handleAuthorsList(){
        ListView<Button> list = new ListView<Button>();
        for(Author a : followedAuthors) {
            Button button = new Button(a.getName());
            list.getItems().add(button);
        }
        Scene s = new Scene(list, 500, 500);
        this.homePage.setScene(s);
        this.homePage.show();
    }

    public void handleQuoteList(){
        ListView<String> list = new ListView<String>();
        for(String s : quotes) {
            list.getItems().add(s);
        }
        Scene s = new Scene(list, 500, 500);
        this.homePage.setScene(s);
        this.homePage.show();
    }

    public void followAuthor(Author a){
        if(!followedAuthors.contains(a)) followedAuthors.add(a);
    }
}
