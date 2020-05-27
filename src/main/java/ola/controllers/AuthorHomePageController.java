package ola.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ola.classes.Author;
import ola.classes.Book;
import ola.model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class AuthorHomePageController extends ReaderHomePageController{
    File selectedFile;
    File selectedImage;
    Book newBook;

    public AuthorHomePageController() {
        super();
    }

    public AuthorHomePageController(User u) {
        super(u);
    }

    public void handleBooks(){
        ListView<Button> list = new ListView<>();
        for(Book b : user.getMyBooks()) {
            ImageView iw = new ImageView(b.getCover());
            String s = b.getTitle();
            Button button = new Button(s, iw);
            list.getItems().add(button);

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        openBookPage(b);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        list.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        list.setMaxSize(200, 300);

        Button add = new Button("Add");
        Button delete = new Button("Delete");
        HBox box = new HBox();
        box.getChildren().addAll(add, delete);
        box.setBackground(new Background(new BackgroundFill(Color.CRIMSON, CornerRadii.EMPTY, Insets.EMPTY)));
        box.setSpacing(312);

        BorderPane bp = new BorderPane();
        bp.setBottom(box);
        bp.setCenter(list);
        bp.setBackground(new Background(new BackgroundFill(Color.DARKSALMON, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene s = new Scene(bp, 400, 400);
        Stage books = new Stage();
        books.setScene(s);
        books.show();

        EventHandler<ActionEvent> addBook = e -> {
            TextField addTitle = new TextField();
            TextField addAuthor = new TextField();
            TextField addDescription = new TextField();

            Text t = new Text("Title: ");
            t.setFill(Color.GHOSTWHITE);
            t.setFont(Font.font("Cooper", FontWeight.BOLD, 12));
            Text a = new Text("Author: ");
            a.setFill(Color.GHOSTWHITE);
            a.setFont(Font.font("Cooper", FontWeight.BOLD, 12));
            Text d = new Text("Short Description: ");
            d.setFill(Color.GHOSTWHITE);
            d.setFont(Font.font("Cooper", FontWeight.BOLD, 12));

            FileChooser imageChooser = new FileChooser();
            Button i = new Button("Choose cover image");
            i.setOnAction(event -> selectedImage = imageChooser.showOpenDialog(books));

            FileChooser fileChooser = new FileChooser();
            Button l = new Button("Choose PDF/EPUB file");
            l.setOnAction(event -> selectedFile = fileChooser.showOpenDialog(books));
            Button ok = new Button("Add Book");

            VBox title = new VBox(t, addTitle);
            VBox author = new VBox(a, addAuthor);
            HBox ta = new HBox(title, author);
            VBox description = new VBox(d, addDescription);
            VBox tad = new VBox(ta, description);
            VBox files = new VBox(i, l, ok);
            files.setSpacing(5);
            HBox all = new HBox(tad, files);
            all.setBackground(new Background(new BackgroundFill(Color.DARKSLATEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            Scene addS = new Scene(all, 500, 100);
            books.setScene(addS);
            books.show();

            //try {
                //Image image = new Image(new FileInputStream(selectedImage));
            //} catch (FileNotFoundException ex) {
                //ex.printStackTrace();
            //}
            ok.setOnAction(event -> {
                newBook = new Book(addTitle.getText(), new Author(addAuthor.getText()), new Text(addDescription.getText()), selectedFile);
                user.getMyBooks().add(newBook);
                books.close();
                handleBooks();
            });


        };

        EventHandler<ActionEvent> deleteBook = e -> {
            Text t = new Text("Write title of the Book you want to delete:");
            t.setFont(Font.font("Cooper", FontWeight.BOLD, 12));
            t.setFill(Color.GHOSTWHITE);
            TextField title = new TextField();
            Button ok = new Button("Delete Book");
            ok.setOnAction(event -> {
               int pos = containsBook(user.getMyBooks(), title.getText());
                if(pos == -1){
                    Text error = new Text("No such book!");
                    HBox noBox = new HBox(error);
                    Scene noScene = new Scene(noBox, 100, 100);
                    Stage noStage = new Stage();
                    noStage.setScene(noScene);
                    noStage.show();
                }
                else{
                    user.getMyBooks().remove(pos);
                    books.close();
                    handleBooks();
                }
            });
            HBox box1 = new HBox(t, title, ok);
            box1.setBackground(new Background(new BackgroundFill(Color.MEDIUMSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            Scene deleteScene = new Scene(box1, 500, 30);
            books.setScene(deleteScene);
            books.show();
        };

        add.setOnAction(addBook);
        delete.setOnAction(deleteBook);
    }

    public void handlePosts(){
        ListView<String> list = new ListView<>();
        for(String s : user.getPosts()) {
            String p = "->" + s;
            list.getItems().add(p);
        }
        list.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        list.setMaxSize(300, 300);
        Button add = new Button("Add");
        add.setAlignment(Pos.BOTTOM_RIGHT);

        BorderPane bp = new BorderPane();
        bp.setBottom(add);
        bp.setCenter(list);
        bp.setBackground(new Background(new BackgroundFill(Color.DARKRED, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene s = new Scene(bp, 400, 400);
        Stage postStage = new Stage();
        postStage.setScene(s);
        postStage.show();

        EventHandler<ActionEvent> addPost = e -> {
            Text t = new Text("Write your post:");
            t.setFont(Font.font("Cooper", FontWeight.BOLD, 12));
            t.setFill(Color.GHOSTWHITE);
            TextField post = new TextField();
            Button ok = new Button("Add Post");

            ok.setOnAction(event -> {
                user.getPosts().add(post.getText());
                postStage.close();
                handlePosts();
            });

            VBox box = new VBox(t, post, ok);
            box.setBackground(new Background(new BackgroundFill(Color.ORCHID, CornerRadii.EMPTY, Insets.EMPTY)));
            Scene scene = new Scene(box, 400, 100);
            postStage.setScene(scene);
            postStage.show();
        };

        add.setOnAction(addPost);
    }
}
