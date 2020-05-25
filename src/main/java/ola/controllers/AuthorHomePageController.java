package ola.controllers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import ola.classes.Book;

import java.util.ArrayList;

public class AuthorHomePageController extends ReaderHomePageController{
    ArrayList<Book> myBooks;
    ArrayList<String> posts;

    public AuthorHomePageController() {
        super();
        myBooks = new ArrayList<Book>();
        posts = new ArrayList<String>();
    }

    public void handleBooks(){
        ListView<Button> list = new ListView<Button>();
        for(Book b : myBooks) {
            ImageView iw = new ImageView(b.getCover());
            Button button = new Button(b.getTitle(), iw);
            list.getItems().add(button);
        }
        Button add = new Button("Add");
        Button delete = new Button("Delete");

        list.getItems().add(add);
        list.getItems().add(delete);

        Scene s = new Scene(list, 500, 500);
        stage.setScene(s);
        stage.show();
    }

    public void handlePosts(){
        ListView<String> list = new ListView<String>();
        for(String s : posts) {
            list.getItems().add(s);
        }
        Button add = new Button("Add");

        GridPane gp = new GridPane();
        gp.getChildren().add(list);
        gp.getChildren().add(add);

        Scene s = new Scene(gp, 500, 500);
        stage.setScene(s);
        stage.show();
    }
}
