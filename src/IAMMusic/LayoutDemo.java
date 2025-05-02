package IAMMusic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LayoutDemo extends Application {
    @Override
    public void start(Stage stage) {
        Label num1lbl = new Label("Album Name: ");
        TextField num1Txt = new TextField();
        HBox num1HB = new HBox(20, num1lbl, num1Txt);
        num1HB.setPadding(new Insets(5));

        Label num2lbl = new Label("Artist: ");
        TextField num2Txt = new TextField();
        HBox num2HB = new HBox(20, num2lbl, num2Txt);
        num2HB.setPadding(new Insets(5));

        // Genre Selection
        Label genrelbl = new Label("Genre: ");
        String[] genres = {"Rock", "Pop", "Rap", "R&B"};
        ObservableList<String> genreList = FXCollections.observableArrayList(genres);
        ComboBox<String> genreBox = new ComboBox<>(genreList);
        HBox genreHB = new HBox(20, genrelbl, genreBox);
        genreHB.setPadding(new Insets(5));

        Label num4lbl = new Label("Time (min): ");
        TextField num4Txt = new TextField();
        HBox num4HB = new HBox(20, num4lbl, num4Txt);
        num4HB.setPadding(new Insets(5));

        Label num5lbl = new Label("Number of Tracks: ");
        TextField num5Txt = new TextField();
        HBox num5HB = new HBox(20, num5lbl, num5Txt);
        num5HB.setPadding(new Insets(5));

        // Submit Button
        Button opBtn = new Button("Done");
        opBtn.setOnAction(e -> {
            String albumName = num1Txt.getText().trim();
            String artist = num2Txt.getText().trim();
            String genre = genreBox.getValue();
            String time = num4Txt.getText().trim();
            String tracks = num5Txt.getText().trim();

            if (albumName.isEmpty() || artist.isEmpty() || genre == null || time.isEmpty() || tracks.isEmpty()) {
                showError("All fields must be filled out.");
                return;
            }

            try {
                double albumTime = Double.parseDouble(time);
                int numTracks = Integer.parseInt(tracks);

                String message = String.format(
                        "Album: %s\nArtist: %s\nGenre: %s\nTime: %.2f minutes\nTracks: %d",
                        albumName, artist, genre, albumTime, numTracks
                );
                showInfo("Album Details", message);
            } catch (NumberFormatException ex) {
                showError("Time must be a valid number, and Tracks must be an integer.");
            }
        });

        // Exit Button
        Button exitBtn = new Button("Exit");
        exitBtn.setOnAction(e -> {
            stage.close();
            Platform.exit();
        });

        HBox btnHB = new HBox(50, opBtn, exitBtn);
        btnHB.setPadding(new Insets(20));

        VBox layout = new VBox(10, num1HB, num2HB, genreHB, num4HB, num5HB, btnHB);
        layout.setPadding(new Insets(15));

        BorderPane root = new BorderPane();
        root.setCenter(layout);
        Scene scene = new Scene(root, 350, 300);
        stage.setScene(scene);
        stage.setTitle("Music Album Form");
        stage.show();
    }

    // Show error message
    private void showError(String message) {
        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setTitle("Error");
        dialog.setHeaderText(null);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    // Show album details
    private void showInfo(String title, String message) {
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle(title);
        dialog.setHeaderText(null);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

