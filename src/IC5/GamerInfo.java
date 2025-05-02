package IC5;
/**
 * Class: GameInfo
 *  @author Damien Brown
 *  @version 1.0
 *  Course: ITEC 31250 Spring 2025
 *  Written: March 31, 2025.
 *  This class – using FXML instead will collect and validate a gamer's information through a form .
 *  It will display an error message for invalid input.
 *  It will show a confirmation message with the gamer's details upon successful entry.
 *
 *
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

    public class GamerInfo extends Application {
        @Override
        public void start(Stage stage) throws Exception {
            // Load the UI layout from the FXML file
            Parent root = FXMLLoader.load(getClass().getResource("Gamer.fxml"));
            Scene scene = new Scene(root); // Create a new scene
            stage.setScene(scene);
            stage.setTitle("Gamer Info");//Title on window
            stage.show();//Display stage

        }

        public static void main(String[] args) {
            launch(args);//start method
        }
    }

