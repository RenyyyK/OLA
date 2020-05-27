package ola.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ola.Main;
import ola.classes.Book;
import ola.model.User;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BookPageController {
    Stage page = Main.getStage();
    Stage bookStage = new Stage();
    User user;

    public Book book;
    public Scene scene;

    public BookPageController(Book b, User u) throws IOException {
        page(b);
        this.user = u;
    }

    public void page(Book b) throws IOException {
        book = b;
        bookStage.setTitle("Book Page");

        ImageView img = new ImageView(book.getCover());
        Text title = new Text(book.getTitle());
        title.setFill(Color.ANTIQUEWHITE);
        title.setFont(Font.font("Broadway", FontWeight.BOLD, 20));
        Button author = new Button(book.getAuthor().getName());
        Text description = book.getDescription();
        description.setFill(Color.ANTIQUEWHITE);
        description.setFont(Font.font("Broadway", FontWeight.BOLD, 14));
        description.setWrappingWidth(200);

        Text c = new Text("Comments from Readers: ");
        c.setFill(Color.ANTIQUEWHITE);
        c.setFont(Font.font("Broadway", FontWeight.BOLD, 12));
        ListView<String> comments = new ListView<>();
        for(String s:book.getComments())
            comments.getItems().add(s);

        Button addComment = new Button("Add a Comment");
        Button read = new Button("Read Book");
        Button download = new Button("Download Book");

        Text addToList = new Text("Add this book to a reading list:");
        addToList.setFill(Color.ANTIQUEWHITE);
        addToList.setFont(Font.font("Broadway", FontWeight.BOLD, 12));
        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.getItems().addAll("Favorites", "Currently Reading", "Want to Read", "Finished Reading");

        /*if(choiceBox.getValue().equals("Favorites")){
            if(!user.getFavorites().contains(book))
                user.getFavorites().add(book);
        }
        else if(choiceBox.getValue().equals("Currently Reading")){
            if(!user.getCurrentlyReading().contains(book))
                user.getCurrentlyReading().add(book);
        }
        else if(choiceBox.getValue().equals("Want to Read")){
            if(!user.getWantToRead().contains(book))
                user.getWantToRead().add(book);
        }
        else if(choiceBox.getValue().equals("Finished Reading")){
            if(!user.getFinishedBooks().contains(book))
                user.getFinishedBooks().add(book);
        }*/

        VBox left = new VBox(img, title, author, description);
        HBox bottom = new HBox(read, download);
        VBox right = new VBox(addToList, choiceBox, c, comments, addComment);
        right.setSpacing(10);
        left.setSpacing(20);
        bottom.setSpacing(10);

        BorderPane grid = new BorderPane();
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

        addComment.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleAddComment();
            }
        });

        author.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AuthorsProfileController a = new AuthorsProfileController(book.getAuthor(), user);
                bookStage.close();
            }
        });

        read.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    handleRead();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        download.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleDownload();
            }
        });
    }

    public void handleRead() throws IOException {
        Stage readStage = new Stage();
        File file = book.getFile();
        Desktop.getDesktop().open(file);
    }

    public void handleDownload(){
        Stage s = new Stage();
        Text t = new Text("File downloading...");
        Button u = new Button("Ok");
        VBox b = new VBox(t, u);
        Scene c = new Scene(b, 50, 50);
        s.setScene(c);
        s.show();
        u.setOnAction(e -> {s.close();});
    }

    public void handleAddComment(){
        Text text = new Text("Write your comment:");
        text.setFill(Color.ANTIQUEWHITE);
        text.setFont(Font.font("Broadway", FontWeight.BOLD, 12));
        TextField comment = new TextField ();
        Button ok = new Button("Send");
        HBox hb = new HBox();
        hb.getChildren().addAll(text, comment, ok);
        hb.setSpacing(20);
        hb.setBackground(new Background(new BackgroundFill(Color.MAROON, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene s = new Scene(hb, 400, 100);
        bookStage.setScene(s);
        bookStage.show();

        EventHandler<ActionEvent> submitComment = e -> {
            String c = "~ " + comment.getText();
            book.addComment(c);
            bookStage.close();
            try {
                page(book);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        };

        ok.setOnAction(submitComment);
    }
}
