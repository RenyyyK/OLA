package ola.controllers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ola.classes.Author;
import ola.classes.Book;
import ola.model.User;

import java.io.IOException;

public class AuthorsProfileController {
    ReaderHomePageController r;
    Author author;
    Stage profile = new Stage();
    User user;

    public AuthorsProfileController(User u, Author a){
        user = u;
        r = new ReaderHomePageController(user);
        author = a;
        profile.setTitle("Author Profile");

        Button follow = new Button("Follow");
        Text name = new Text(author.getName());
        name.setFill(Color.WHITESMOKE);
        name.setFont(Font.font("Castellar", FontWeight.BOLD, 20));

        Text b = new Text("Books:");
        b.setFill(Color.WHITESMOKE);
        b.setFont(Font.font("Castellar", FontWeight.BOLD, 14));
        ListView<Button> bookList = new ListView<>();
        for(Book book:author.getBooks()) {
            Button button = new Button(book.getTitle());
            bookList.getItems().add(button);
            button.setOnAction(e -> {
                try { BookPageController bookPageController = new BookPageController(book, user); }
                catch (IOException ex) { ex.printStackTrace(); }
            });
        }
        Text p = new Text("Posts:");
        p.setFill(Color.WHITESMOKE);
        p.setFont(Font.font("Castellar", FontWeight.BOLD, 14));
        ListView<String> postList = new ListView<>();
        for(String s:author.getPosts())
            postList.getItems().add(s);

        follow.setOnAction(e -> {
            handleFollow();
        });

        VBox bookBox = new VBox(b, bookList);
        VBox postBox = new VBox(p, postList);

        HBox n = new HBox(name, follow);
        n.setSpacing(200);

        BorderPane bp = new BorderPane();
        bp.setLeft(bookBox);
        bp.setRight(postBox);
        bp.setTop(n);

        StackPane layout = new StackPane();
        Image wallpaper_image = new Image("books.jpg");
        BackgroundImage bi = new BackgroundImage(wallpaper_image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(bi);
        layout.setBackground(background);
        layout.getChildren().add(bp);

        Scene scene = new Scene(layout, 500, 500);
        this.profile.setScene(scene);
        this.profile.show();
    }

    public void handleFollow(){
        r.followAuthor(author);
    }
}
