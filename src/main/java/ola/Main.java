package ola;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import ola.services.UserService;

public class Main extends Application {
    private static Stage mainStage;

    public static Stage getStage() {
        return mainStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        UserService.loadUsersFromFile();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        mainStage.setTitle("Registration");

        StackPane layout = new StackPane();
        Image wallpaper_image = new Image("books.jpg");
        BackgroundImage bi = new BackgroundImage(wallpaper_image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(bi);
        layout.setBackground(background);
        layout.getChildren().add(root);

        Scene scene = new Scene(layout, 500, 500);
        mainStage.setScene(scene);
        mainStage.show();
    }
}
