package loginEXFML;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginFXML extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        GridPane root = loader.load(getClass().getClassLoader().getResource("student/login.fxml"));
        Scene scene = new Scene(root, 325,275);
        scene.getStylesheets().add(getClass().getResource("loginFXML.css").toExternalForm());
        BackgroundImage bi = new BackgroundImage(new Image("student/background.jpg"),
                null,null,null,null);
        root.setBackground(new Background(bi));
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
