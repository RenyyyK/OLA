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
import ola.model.User;
import ola.services.BookService;

import java.io.IOException;
import java.util.ArrayList;

public class ReaderHomePageController {
    Stage stage = Main.getStage();
    Stage listStage = new Stage();
    User user;

    @FXML
    private TextField searchForBook;
    @FXML
    private TextField searchForAuthor;

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
        user = SignInController.getUser();
    }

    public ReaderHomePageController(User u) {
        user = u;
    }
    public void handleFavorites(){
        ListView<Button> list = new ListView<>();
        for(Book b : user.getFavorites()) {
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
                int pos = containsBook(user.getFavorites(), title.getText());
                if(pos == -1){
                    Text error = new Text("No such book!");
                    HBox noBox = new HBox(error);
                    Scene noScene = new Scene(noBox, 100, 100);
                    Stage noStage = new Stage();
                    noStage.setScene(noScene);
                    noStage.show();
                }
                else{
                    user.getFavorites().remove(pos);
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
        for(Book b : user.getCurrentlyReading()) {
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
                int pos = containsBook(user.getCurrentlyReading(), title.getText());
                if(pos == -1){
                    Text error = new Text("No such book!");
                    HBox noBox = new HBox(error);
                    Scene noScene = new Scene(noBox, 100, 100);
                    Stage noStage = new Stage();
                    noStage.setScene(noScene);
                    noStage.show();
                }
                else{
                    user.getCurrentlyReading().remove(pos);
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
        for(Book b : user.getWantToRead()) {
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
                int pos = containsBook(user.getWantToRead(), title.getText());
                if(pos == -1){
                    Text error = new Text("No such book!");
                    HBox noBox = new HBox(error);
                    Scene noScene = new Scene(noBox, 100, 100);
                    Stage noStage = new Stage();
                    noStage.setScene(noScene);
                    noStage.show();
                }
                else{
                    user.getWantToRead().remove(pos);
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
        for(Book b : user.getFinishedBooks()) {
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
                int pos = containsBook(user.getFinishedBooks(), title.getText());
                if(pos == -1){
                    Text error = new Text("No such book!");
                    HBox noBox = new HBox(error);
                    Scene noScene = new Scene(noBox, 100, 100);
                    Stage noStage = new Stage();
                    noStage.setScene(noScene);
                    noStage.show();
                }
                else{
                    user.getFinishedBooks().remove(pos);
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
        for(Author a : user.getFollowedAuthors()) {
            Button button = new Button(a.getName());
            button.setOnAction(e -> {
                try {
                    openAuthorProfile(a);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
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
        for(String s : user.getQuotes()) {
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
        if(!user.getFollowedAuthors().contains(a)) user.getFollowedAuthors().add(a);
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
        BookPageController bp = new BookPageController(b, user);
    }

    public void openAuthorProfile(Author a) throws IOException {
        AuthorsProfileController ap = new AuthorsProfileController(a, user);
    }
}
