package org.loose.fis.registration.example.controllers;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.loose.fis.registration.example.classes.Author;
import org.loose.fis.registration.example.classes.Book;

import java.io.IOException;
import java.util.ArrayList;

public class AuthorsProfileController {
    ReaderHomePageController r = new ReaderHomePageController();
    Author author;
    Stage profile = new Stage();

    public AuthorsProfileController(Author a){
        author = a;
        StackPane layout = new StackPane();
        Image wallpaper_image = new Image("https://bgwall.net/wp-content/uploads/2014/09/books-at-the-library-wallpaper-picture.jpg");
        BackgroundImage bi = new BackgroundImage(wallpaper_image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(bi);
        layout.setBackground(background);

        Scene scene = new Scene(layout, 500, 500);
        this.profile.setScene(scene);
        this.profile.show();
    }

    public void handleFollow(){
        r.followAuthor(author);
    }
}
