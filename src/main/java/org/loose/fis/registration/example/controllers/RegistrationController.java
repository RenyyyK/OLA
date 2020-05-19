package org.loose.fis.registration.example.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.registration.example.Main;
import org.loose.fis.registration.example.classes.Author;
import org.loose.fis.registration.example.exceptions.UserDoesNotExistException;
import org.loose.fis.registration.example.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.registration.example.exceptions.WrongPasswordException;
import org.loose.fis.registration.example.model.User;
import org.loose.fis.registration.example.services.UserService;

import java.io.IOException;

public class RegistrationController {
    Stage stage = Main.getStage();
    User user;

    @FXML
    private Text registrationMessage;
   // @FXML
    //private Text SignInMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField fullNameField;
    @FXML
    private ChoiceBox role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Author", "Reader");
    }

    @FXML
    public void handleRegisterAction() {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Account created successfully!");

            stage = Main.getStage();
            stage.setTitle("Home Page");

            Parent root;
            String r = (String) role.getValue();

            if(r.equals("Author")) {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("authorHomePage.fxml"));
                user  = new User(usernameField.getText(), passwordField.getText(), (String)role.getValue());
            }
            else if(r.equals("Reader")){
                root = FXMLLoader.load(getClass().getClassLoader().getResource("readerHomePage.fxml"));
                user  = new User(usernameField.getText(), passwordField.getText(), (String)role.getValue());
            }
            else {
                root = null;
            }

            StackPane layout = new StackPane();
            Image wallpaper_image = new Image("books.jpg");
            BackgroundImage bi = new BackgroundImage(wallpaper_image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            Background background = new Background(bi);
            layout.setBackground(background);
            layout.getChildren().add(root);

            stage.setScene(new Scene(layout, 500, 500));
            stage.show();

        } catch (UsernameAlreadyExistsException | IOException e) {
            registrationMessage.setText(e.getMessage());
        }
    }

    @FXML
    public void handleSignInAction() throws Exception{
        stage.setTitle("Sign In");

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("signIn.fxml"));

        StackPane layout = new StackPane();
        Image wallpaper_image = new Image("books.jpg");
        BackgroundImage bi = new BackgroundImage(wallpaper_image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(bi);
        layout.setBackground(background);
        layout.getChildren().add(root);

        stage.setScene(new Scene(layout, 500, 500));
        stage.show();
    }

    public User getUser(){
        return user;
    }
}
