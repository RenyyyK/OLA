package org.loose.fis.registration.example.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.registration.example.classes.Book;

public class BookPageController {
    public Book book;
    public Stage page = new Stage();
    public Scene scene;

    public BookPageController(Book b){
        book = b;

        StackPane layout = new StackPane();
        Image wallpaper_image = new Image("https://bgwall.net/wp-content/uploads/2014/09/books-at-the-library-wallpaper-picture.jpg");
        BackgroundImage bi = new BackgroundImage(wallpaper_image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(bi);
        layout.setBackground(background);

        scene = new Scene(layout, 500, 500);
        this.page.setScene(scene);
        this.page.show();
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

        EventHandler<ActionEvent> submitComment = new EventHandler<ActionEvent>() {
             public void handle(ActionEvent e) {
                 book.addComment(comment.getText());
                 page.setScene(scene);
             }
         };

        ok.setOnAction(submitComment);
    }



}
