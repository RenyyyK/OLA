package org.loose.fis.registration.example.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.registration.example.exceptions.UserDoesNotExistException;
import org.loose.fis.registration.example.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.registration.example.exceptions.WrongPasswordException;
import org.loose.fis.registration.example.services.UserService;

public class SignInController {

    @FXML
    private Text SignInMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;

    @FXML
    public void handleSignInAction() {
        try {
            UserService.searchUser(usernameField.getText(), passwordField.getText());
            SignInMessage.setText("Sign In Successful!");
        } catch (UserDoesNotExistException e) {
            SignInMessage.setText(e.getMessage());
        } catch (WrongPasswordException e){
            SignInMessage.setText(e.getMessage());
        }
    }
}
