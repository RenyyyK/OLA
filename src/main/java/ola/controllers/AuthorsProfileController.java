package ola.controllers;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import ola.classes.Author;

public class AuthorsProfileController {
    ReaderHomePageController r = new ReaderHomePageController();
    Author author;
    Stage profile = new Stage();

    public AuthorsProfileController(Author a){
        author = a;
        StackPane layout = new StackPane();
        Image wallpaper_image = new Image("books.jpg");
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
