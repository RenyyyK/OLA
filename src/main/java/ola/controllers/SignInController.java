package ola.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ola.Main;
import ola.exceptions.UserDoesNotExistException;
import ola.exceptions.WrongPasswordException;
import ola.model.User;
import ola.services.UserService;

import java.io.IOException;

public class SignInController {
    Stage stage = Main.getStage();

    @FXML
    private Text SignInMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;

    @FXML
    public void handleSignInAction() {
        try {
            User u = UserService.searchUser(usernameField.getText(), passwordField.getText());
            SignInMessage.setText("Sign In Successful!");

            stage = Main.getStage();
            stage.setTitle("Home Page");

            Parent root;
            String r = u.getRole();

            if(r.equals("Author")) {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("authorHomePage.fxml"));
            }
            else if(r.equals("Reader")){
                root = FXMLLoader.load(getClass().getClassLoader().getResource("readerHomePage.fxml"));
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

        } catch (UserDoesNotExistException e) {
            SignInMessage.setText(e.getMessage());
        } catch (WrongPasswordException e){
            SignInMessage.setText(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
