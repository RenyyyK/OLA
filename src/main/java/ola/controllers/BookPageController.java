package ola.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ola.Main;
import ola.classes.Book;
import ola.services.UserService;

import java.io.IOException;
import java.util.Objects;

public class BookPageController {
    Stage page = Main.getStage();
    Stage bookStage = new Stage();

    public Book book;
    public Scene scene;

    public BookPageController(Book b) throws IOException {
        book = b;
        bookStage.setTitle("Book Page");

        ImageView img = new ImageView(book.getCover());
        Text title = new Text(book.getTitle());
        Button author = new Button(book.getAuthor().getName());
        Text description = book.getDescription();
        ListView<String> comments = book.getComments();
        Button addComment = new Button("Add a Comment");
        Button read = new Button("Read Book");
        Button download = new Button("Download Book");

        Text addToList = new Text("Add this book to a reading list:");
        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.getItems().addAll("Favorites", "Currently Reading", "Want to Read", "Finished Reading");

        VBox left = new VBox(img, read, download);
        VBox center = new VBox(title, author, description);
        HBox bottom = new HBox(comments, addComment);
        VBox right = new VBox(addToList, choiceBox);

        BorderPane grid = new BorderPane();
        grid.setCenter(center);
        grid.setBottom(bottom);
        grid.setLeft(left);
        grid.setRight(right);

        StackPane layout = new StackPane();
        Image wallpaper_image = new Image("books.jpg");
        BackgroundImage bi = new BackgroundImage(wallpaper_image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(bi);
        layout.setBackground(background);
        layout.getChildren().add(grid);

        Scene scene = new Scene(layout, 500, 500);
        bookStage.setScene(scene);
        bookStage.show();
    }

    public void handleRead(){
        //file load --> scene --> stage
    }

    public void handleDownload(){
        System.out.println("Book downloaded!");
    }

    public void handleAddComment(){
        TextField comment = new TextField ();
        Button ok = new Button("Submit");
        HBox hb = new HBox();
        hb.getChildren().addAll(comment, ok);
        hb.setSpacing(20);
        Scene s = new Scene(hb, 400, 400);
        page.setScene(s);
        page.show();

        EventHandler<ActionEvent> submitComment = e -> {
            book.addComment(comment.getText());
            page.setScene(scene);
        };

        ok.setOnAction(submitComment);
    }



}
