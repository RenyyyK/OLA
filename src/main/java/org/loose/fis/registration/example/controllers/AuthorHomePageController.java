package org.loose.fis.registration.example.controllers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import org.loose.fis.registration.example.classes.Book;

import java.util.ArrayList;

public class AuthorHomePageController extends ReaderHomePageController{
    private ArrayList<Book> myBooks;
    private ArrayList<String> posts;

    public AuthorHomePageController() {
        super();
        myBooks = new ArrayList<Book>();
        posts = new ArrayList<String>();

        StackPane layout = new StackPane();
        Image wallpaper_image = new Image("https://bgwall.net/wp-content/uploads/2014/09/books-at-the-library-wallpaper-picture.jpg");
        BackgroundImage bi = new BackgroundImage(wallpaper_image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(bi);
        layout.setBackground(background);

        Scene scene = new Scene(layout, 500, 500);
        this.homePage.setScene(scene);
        this.homePage.show();
    }

    public void handleBooks(){
        ListView<Button> list = new ListView<Button>();
        for(Book b : myBooks) {
            ImageView iw = new ImageView(b.getCover());
            Button button = new Button(b.getTitle(), iw);
            list.getItems().add(button);
        }
        Scene s = new Scene(list, 500, 500);
        this.homePage.setScene(s);
        this.homePage.show();
    }

    public void handlePosts(){
        ListView<String> list = new ListView<String>();
        for(String s : posts) {
            list.getItems().add(s);
        }
        Scene s = new Scene(list, 500, 500);
        this.homePage.setScene(s);
        this.homePage.show();
    }
}
