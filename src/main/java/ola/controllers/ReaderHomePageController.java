package ola.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ola.Main;
import ola.classes.Author;
import ola.classes.Book;
import ola.services.BookService;

import java.util.ArrayList;

public class ReaderHomePageController {
    Stage stage = Main.getStage();
    Stage listStage = new Stage();

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
        Favorites = new ArrayList<>();
        CurrentlyReading = new ArrayList<>();
        WantToRead = new ArrayList<>();
        FinishedBooks = new ArrayList<>();
        followedAuthors = new ArrayList<>();
        quotes = new ArrayList<>();
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
        ListView<Button> list = new ListView<>();
        for(Book b : Favorites) {
            ImageView iw = new ImageView(b.getCover());
            Button button = new Button(b.getTitle(), iw);
            list.getItems().add(button);
        }
        list.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        list.setMaxSize(200, 300);
        BorderPane bp = new BorderPane();
        bp.setCenter(list);
        bp.setBackground(new Background(new BackgroundFill(Color.DARKGOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene s = new Scene(bp, 400, 400);
        listStage.setScene(s);
        listStage.show();
    }

    public void handleCurrentlyReading(){
        ListView<Button> list = new ListView<>();
        for(Book b : CurrentlyReading) {
            ImageView iw = new ImageView(b.getCover());
            Button button = new Button(b.getTitle(), iw);
            list.getItems().add(button);
        }
        list.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        list.setMaxSize(200, 300);
        BorderPane bp = new BorderPane();
        bp.setCenter(list);
        bp.setBackground(new Background(new BackgroundFill(Color.DARKGOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene s = new Scene(bp, 400, 400);
        listStage.setScene(s);
        listStage.show();
    }

    public void handleWantToRead(){
        ListView<Button> list = new ListView<>();
        for(Book b : WantToRead) {
            ImageView iw = new ImageView(b.getCover());
            Button button = new Button(b.getTitle(), iw);
            list.getItems().add(button);
        }
        list.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        list.setMaxSize(200, 300);
        BorderPane bp = new BorderPane();
        bp.setCenter(list);
        bp.setBackground(new Background(new BackgroundFill(Color.DARKGOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene s = new Scene(bp, 400, 400);
        listStage.setScene(s);
        listStage.show();
    }

    public void handleFinishedReading(){
        ListView<Button> list = new ListView<>();
        for(Book b : FinishedBooks) {
            ImageView iw = new ImageView(b.getCover());
            Button button = new Button(b.getTitle(), iw);
            list.getItems().add(button);
        }
        list.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        list.setMaxSize(200, 300);
        BorderPane bp = new BorderPane();
        bp.setCenter(list);
        bp.setBackground(new Background(new BackgroundFill(Color.DARKGOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene s = new Scene(bp, 400, 400);
        listStage.setScene(s);
        listStage.show();
    }

    public void handleAuthorsList() {
        ListView<Button> list = new ListView<>();
        for(Author a : followedAuthors) {
            Button button = new Button(a.getName());
            //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("BookPage.fxml"));
            //button.setOnAction();
            list.getItems().add(button);
        }
        list.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        list.setMaxSize(200, 300);
        BorderPane bp = new BorderPane();
        bp.setCenter(list);
        bp.setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene s = new Scene(bp, 400, 400);
        listStage.setScene(s);
        listStage.show();
    }

    public void handleQuoteList(){
        ListView<String> list = new ListView<>();
        for(String s : quotes) {
            list.getItems().add(s);
        }
        list.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        list.setMaxSize(200, 300);
        BorderPane bp = new BorderPane();
        bp.setCenter(list);
        bp.setBackground(new Background(new BackgroundFill(Color.INDIANRED, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene s = new Scene(bp, 400, 400);
        listStage.setScene(s);
        listStage.show();
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
