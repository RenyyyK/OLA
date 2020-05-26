package ola.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ola.Main;
import ola.classes.Author;
import ola.classes.Book;
import ola.services.BookService;

import java.io.IOException;
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

    public int containsBook(ArrayList<Book> list, String title){
        int i=0;
        for(Book b:list){
            if(b.getTitle().equals(title))
                return i;
            i++;
        }
        return -1;
    }

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

        Button remove = new Button("Remove a Book from the list");
        bp.setBottom(remove);

        EventHandler<ActionEvent> removeBook = e -> {
            Text t = new Text("Write title of the Book you want to remove from list:");
            t.setFont(Font.font("Cooper", FontWeight.BOLD, 12));
            t.setFill(Color.GHOSTWHITE);
            TextField title = new TextField();
            Button ok = new Button("Remove Book");
            ok.setOnAction(event -> {
                int pos = containsBook(Favorites, title.getText());
                if(pos == -1){
                    Text error = new Text("No such book!");
                    HBox noBox = new HBox(error);
                    Scene noScene = new Scene(noBox, 100, 100);
                    Stage noStage = new Stage();
                    noStage.setScene(noScene);
                    noStage.show();
                }
                else{
                    Favorites.remove(pos);
                    listStage.close();
                    handleFavorites();
                }
            });
            HBox box1 = new HBox(t, title, ok);
            box1.setBackground(new Background(new BackgroundFill(Color.MEDIUMSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            Scene deleteScene = new Scene(box1, 500, 30);
            listStage.setScene(deleteScene);
            listStage.show();
        };

        remove.setOnAction(removeBook);
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

        Button remove = new Button("Remove a Book from the list");
        bp.setBottom(remove);

        EventHandler<ActionEvent> removeBook = e -> {
            Text t = new Text("Write title of the Book you want to remove from list:");
            t.setFont(Font.font("Cooper", FontWeight.BOLD, 12));
            t.setFill(Color.GHOSTWHITE);
            TextField title = new TextField();
            Button ok = new Button("Remove Book");
            ok.setOnAction(event -> {
                int pos = containsBook(CurrentlyReading, title.getText());
                if(pos == -1){
                    Text error = new Text("No such book!");
                    HBox noBox = new HBox(error);
                    Scene noScene = new Scene(noBox, 100, 100);
                    Stage noStage = new Stage();
                    noStage.setScene(noScene);
                    noStage.show();
                }
                else{
                    CurrentlyReading.remove(pos);
                    listStage.close();
                    handleCurrentlyReading();
                }
            });
            HBox box1 = new HBox(t, title, ok);
            box1.setBackground(new Background(new BackgroundFill(Color.MEDIUMSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            Scene deleteScene = new Scene(box1, 500, 30);
            listStage.setScene(deleteScene);
            listStage.show();
        };

        remove.setOnAction(removeBook);
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

        Button remove = new Button("Remove a Book from the list");
        bp.setBottom(remove);

        EventHandler<ActionEvent> removeBook = e -> {
            Text t = new Text("Write title of the Book you want to remove from list:");
            t.setFont(Font.font("Cooper", FontWeight.BOLD, 12));
            t.setFill(Color.GHOSTWHITE);
            TextField title = new TextField();
            Button ok = new Button("Remove Book");
            ok.setOnAction(event -> {
                int pos = containsBook(WantToRead, title.getText());
                if(pos == -1){
                    Text error = new Text("No such book!");
                    HBox noBox = new HBox(error);
                    Scene noScene = new Scene(noBox, 100, 100);
                    Stage noStage = new Stage();
                    noStage.setScene(noScene);
                    noStage.show();
                }
                else{
                    WantToRead.remove(pos);
                    listStage.close();
                    handleWantToRead();
                }
            });
            HBox box1 = new HBox(t, title, ok);
            box1.setBackground(new Background(new BackgroundFill(Color.MEDIUMSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            Scene deleteScene = new Scene(box1, 500, 30);
            listStage.setScene(deleteScene);
            listStage.show();
        };

        remove.setOnAction(removeBook);
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

        Button remove = new Button("Remove a Book from the list");
        bp.setBottom(remove);

        EventHandler<ActionEvent> removeBook = e -> {
            Text t = new Text("Write title of the Book you want to remove from list:");
            t.setFont(Font.font("Cooper", FontWeight.BOLD, 12));
            t.setFill(Color.GHOSTWHITE);
            TextField title = new TextField();
            Button ok = new Button("Remove Book");
            ok.setOnAction(event -> {
                int pos = containsBook(FinishedBooks, title.getText());
                if(pos == -1){
                    Text error = new Text("No such book!");
                    HBox noBox = new HBox(error);
                    Scene noScene = new Scene(noBox, 100, 100);
                    Stage noStage = new Stage();
                    noStage.setScene(noScene);
                    noStage.show();
                }
                else{
                    FinishedBooks.remove(pos);
                    listStage.close();
                    handleFinishedReading();
                }
            });
            HBox box1 = new HBox(t, title, ok);
            box1.setBackground(new Background(new BackgroundFill(Color.MEDIUMSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            Scene deleteScene = new Scene(box1, 500, 30);
            listStage.setScene(deleteScene);
            listStage.show();
        };

        remove.setOnAction(removeBook);
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
        listStage.setScene(s);
        listStage.show();
    }

    public void searchAuthor(){
        String name = searchForAuthor.getText();
        Author a = BookService.searchAuthorByName(name);
        ListView<Author> author = new ListView<>();
        Scene s = new Scene(author, 500, 500);
        listStage.setScene(s);
        listStage.show();
    }

    public void openBookPage(Book b) throws IOException {
        BookPageController bp = new BookPageController(b);
    }
}
