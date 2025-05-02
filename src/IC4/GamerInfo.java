package IC4;
/**
 * Class: GameInfo
 *  @author Damien Brown
 *  @version 1.0
 *  Course: ITEC 31250 Spring 2025
 *  Written: March 30, 2025.
 *  This class – will collect and validate a gamer's information through a form .
 *  It will display an error message for invalid input.
 *  It will show a confirmation message with the gamer's details upon successful entry.
 *
 *
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GamerInfo extends Application {
    @Override
    public void start(Stage stage) {

        Label GreetLbl = new Label("Please enter the Gamer's Information");
        HBox greetHB = new HBox(50, GreetLbl);
        greetHB.setPadding(new Insets(15));


        Label tagLbl = new Label("Gamer Tag: ");
        TextField tagTxt = new TextField();
        HBox tagHB = new HBox(35, tagLbl, tagTxt);
        tagHB.setPadding(new Insets(10));


        Label scoreLbl = new Label("Average Score: ");
        TextField scoreTxt = new TextField();
        HBox scoreHB = new HBox(20, scoreLbl, scoreTxt);
        scoreHB.setPadding(new Insets(5));


        Label fnameLbl = new Label("First Name: ");
        TextField fnameTxt = new TextField();
        HBox fnameHB = new HBox(38, fnameLbl, fnameTxt);
        fnameHB.setPadding(new Insets(5));


        Label lnameLbl = new Label("Last Name: ");
        TextField lnameTxt = new TextField();
        HBox lnameHB = new HBox(40, lnameLbl, lnameTxt);
        lnameHB.setPadding(new Insets(5));


        Label emailLbl = new Label("Email: ");
        TextField emailTxt = new TextField();
        HBox emailHB = new HBox(65, emailLbl, emailTxt);
        emailHB.setPadding(new Insets(5));


        Label gameLbl = new Label("Favorite Game: ");
        TextField gameTxt = new TextField();
        HBox gameHB = new HBox(20, gameLbl, gameTxt);
        gameHB.setPadding(new Insets(5));

        // Submit Button (OK)
        Button okBtn = new Button("OK");
        okBtn.setOnAction(e -> {
            try {
                Gamer gamer = new Gamer(
                        tagTxt.getText().trim(),
                        Double.parseDouble(scoreTxt.getText().trim()),
                        fnameTxt.getText().trim(),
                        lnameTxt.getText().trim(),
                        emailTxt.getText().trim(),
                        gameTxt.getText().trim()
                );

                // Checks using setters
                gamer.setGamerTag(gamer.getGamerTag());
                gamer.setAvgScore(gamer.getAvgScore());
                gamer.setFname(gamer.getFname());
                gamer.setLname(gamer.getLname());
                gamer.setEmail(gamer.getEmail());
                gamer.setFavGame(gamer.getFavGame());

                showInfo("Gamer Info", gamer.toString());

            } catch (NumberFormatException ex) {
                showError("Average Score must be a valid number.");
            } catch (GamerEntry ex) {
                showError(ex.getMessage());
            }
        });

        // Exit Button
        Button exitBtn = new Button("Cancel");
        exitBtn.setOnAction(e -> {
            stage.close();
            Platform.exit();
        });

        HBox btnHB = new HBox(50, okBtn, exitBtn);
        btnHB.setPadding(new Insets(20));

        // Create VBox for all form elements
        VBox layout = new VBox(10, greetHB, tagHB, scoreHB, fnameHB, lnameHB, emailHB, gameHB, btnHB);
        layout.setPadding(new Insets(15));

        // Center the VBox in the BorderPane
        BorderPane root = new BorderPane();
        root.setCenter(layout);

        // Create a scene and display window
        Scene scene = new Scene(root, 400, 350);
        stage.setScene(scene);
        stage.setTitle("Gamer Info");
        stage.show();
    }
    //method for showing error message
    private void showError(String message) {
        // Create an HBox for the Error label
        HBox errorHB = new HBox(10);
        errorHB.setPadding(new Insets(10));

        // Create the 'Error' label on the left side like example
        Label errorLabel = new Label("Error");
        errorLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        // Create a Separator (which is a line) below the message
        Separator separator = new Separator();

        // Create a VBox to hold the error message and add separator below it
        VBox errorMessageBox = new VBox(10, errorHB, separator, new Label(message));
        errorMessageBox.setPadding(new Insets(10));

        // Create the error alert
        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setTitle("Error");
        dialog.setHeaderText(null);  // Remove the default header

        // Set the content of the dialog to our custom VBox
        dialog.getDialogPane().setContent(errorMessageBox);

        // Align the error label and message in the left side
        errorHB.getChildren().addAll(errorLabel);



        // Show the dialog
        dialog.showAndWait();
    }
// method to show confirmation message and display the items
    private void showInfo(String title, String message) {
        // Create an HBox for the Error label
        HBox confirmHB = new HBox(10);
        confirmHB.setPadding(new Insets(10));

        // Create the 'Error' label on the left
        Label cfLabel = new Label("Confirmation");
        cfLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        // Create a Separator (line) below the message
        Separator separator = new Separator();

        // Create a VBox to hold the error message and add separator line below it
        VBox confirmMessageBox = new VBox(10, confirmHB, separator, new Label(message));
        confirmMessageBox.setPadding(new Insets(10));

        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle("Confirmation");
        dialog.setHeaderText(null);
        dialog.getDialogPane().setContent(confirmMessageBox);
        confirmHB.getChildren().addAll(cfLabel);
        dialog.showAndWait();
    }
}
