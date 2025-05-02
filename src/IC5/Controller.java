package IC5;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private TextField tagTxt, scoreTxt, fnameTxt, lnameTxt, emailTxt, gameTxt;

    @FXML
    private Label errorLabel;

    @FXML
    private void handleSubmit() {
        try {
            // Create a Gamer object using input from the text fields
            Gamer gamer = new Gamer(
                    tagTxt.getText().trim(), // Gamer Tag
                    Double.parseDouble(scoreTxt.getText().trim()), // Average Score

                   //attributes first name,last name, email, favorite game
                    fnameTxt.getText().trim(),
                    lnameTxt.getText().trim(),
                    emailTxt.getText().trim(),
                    gameTxt.getText().trim()
            );

            // Validate input fields by calling the setter methods
            gamer.setGamerTag(gamer.getGamerTag());
            gamer.setAvgScore(gamer.getAvgScore());
            gamer.setFname(gamer.getFname());
            gamer.setLname(gamer.getLname());
            gamer.setEmail(gamer.getEmail());
            gamer.setFavGame(gamer.getFavGame());

            // If all input is valid, show the Gamer information in a dialog
            showInfo("Gamer Info", gamer.toString());

        } catch (NumberFormatException ex) {
            showError("Average Score must be a valid number.");  // Handle non-numeric score input
        } catch (GamerEntry ex) {
            showError(ex.getMessage()); // Show custom validation error
        }
    }

    @FXML
    private void handleCancel() {
        // Close the current window when Cancel is clicked
        Stage stage = (Stage) tagTxt.getScene().getWindow();
        stage.close();
    }

    private void showInfo(String title, String message) {
        // Show an information dialog with the given title and message
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);

        //Set dialog, header, main message
        dialog.setTitle("Gamer Information");
        dialog.setHeaderText("Message");
        dialog.setContentText(message);
        dialog.showAndWait(); // Display dialog
    }

    private void showError(String message) {
        // Show an error dialog with the given message
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error:");
        alert.setContentText(message);
        alert.showAndWait();
    }
}