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
import org.loose.fis.registration.example.Main;
import org.loose.fis.registration.example.classes.Book;

public class BookPageController {
    Stage page = Main.getStage();

    public Book book;
    public Scene scene;

    public BookPageController(Book b){
        book = b;
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
