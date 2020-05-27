package ola.controllers;

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
import ola.Main;
import ola.exceptions.UsernameAlreadyExistsException;
import ola.model.User;
import ola.services.UserService;

import java.io.IOException;

public class RegistrationController {
    Stage stage = Main.getStage();
    static User user;

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
            String r = (String)role.getValue();
            if(r.equals("Author"))
                UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue(), fullNameField.getText());
            else
                UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }

    @FXML
    public void handleSignInAction() throws Exception {
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

    public static User getUser() {
        return user;
    }
}
