
package HW3.View;

/**
 * Class: BookFile
 *  @author Damien Brown
 *  @version 1.0
 *  Course: ITEC 31250 Spring 2025
 *  Written: April 14, 2025.
 *  This class – wil.......
 *
 *
 */

import HW3.Controller.Book;
import HW3.Controller.BookException;
import HW3.Model.BookFile;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class BookEntry extends Application {

    @Override
    public void start(Stage stage) {

        //UI elements: labels, text fields, combo box, radio buttons, etc.

                // Layout containers for form sections and buttons

                // Button event handlers: save, display, cancel
                // Save validates inputs and writes a Book object to a file
                // Display reads and shows all saved books
                // Cancel closes the app

                // Final scene and stage setup
        // Labels and Inputs
        Label betitle = new Label("Book Entry");
        HBox beHB = new HBox(50, betitle);
        beHB.setSpacing(15);


        Label titleLbl = new Label("Title:");
        TextField titleTxt = new TextField();
        HBox titleHB = new HBox(35,titleLbl, titleTxt);
        titleHB.setSpacing(90);

        Label authorLbl = new Label("Author:");
        TextField authorTxt = new TextField();
        HBox authorHB = new HBox(20, authorLbl, authorTxt);
        authorHB.setSpacing(76);

        Label genreLbl = new Label("Genre:");
        ComboBox<String> genreCombo = new ComboBox<>();
        genreCombo.getItems().addAll("Fantasy", "Romance", "History", "Military", "Mystery");//Mystery to test
        genreCombo.setValue("History");
        HBox genreHB = new HBox(20,genreLbl, genreCombo);
        genreHB.setSpacing(82);


        Label chLbl = new Label("Number of chapters:");
        TextField chTxt = new TextField();
        HBox chHB = new HBox(20,chLbl, chTxt);
        chHB.setSpacing(10);

  Label inLiblbl = new Label("In Library:");
 HBox inLiHB = new HBox(inLiblbl);

        RadioButton inLibYes = new RadioButton("In Library");
        RadioButton inLibNo = new RadioButton("Not in Library");
        ToggleGroup inLibGroup = new ToggleGroup();
        inLibYes.setToggleGroup(inLibGroup);
        inLibNo.setToggleGroup(inLibGroup);
        inLibNo.setSelected(true);
        HBox inLibBox = new HBox(20, inLibYes, inLibNo);
        inLibBox.setSpacing(10);


        Label libnLbl = new Label("Library Name:");
        TextField libnTxt = new TextField();
        HBox libHB = new HBox(20,libnLbl, libnTxt);
        libHB.setSpacing(45);



        // Buttons
        Button saveBtn = new Button("Save");
        Button displayBtn = new Button("Display");
        Button cancelBtn = new Button("Cancel");

        HBox buttonBox = new HBox(75, saveBtn, displayBtn, cancelBtn);
        buttonBox.setPadding(new Insets(45));

        // Create VBox for all form elements
        VBox layout = new VBox(10, beHB, titleHB, authorHB, genreHB, chHB,inLiHB, inLibBox, libHB,buttonBox);
        layout.setPadding(new Insets(15));

        // Layout using BorderPane
        BorderPane root = new BorderPane();
        root.setCenter(layout);
        root.setBottom(buttonBox);

        // Event Handlers
        saveBtn.setOnAction(e -> {
            try {
                String title = titleTxt.getText().trim();
                String author = authorTxt.getText().trim();
                String genre = genreCombo.getValue();
                int chapters = Integer.parseInt(chTxt.getText().trim());
                boolean inLibrary = inLibYes.isSelected();
                String libraryName = libnTxt.getText().trim();

                if (inLibrary && (libraryName.isEmpty() || libraryName.trim().split(" ").length < 2)) {
                    throw new BookException("Library name must be two words if the book is in a library.");
                }

                Book book = new Book(title, author, genre, chapters, inLibrary, libraryName);
                BookFile.writeFile(book);
                showInfo("Saved", "Book saved successfully!");
            } catch (BookException ex) {
                showError(ex.getMessage());
            } catch (NumberFormatException ex) {
                showError("Number of chapters must be a valid number.");
            } catch (Exception ex) {
                showError("An unexpected error occurred.");
            }
        });

        displayBtn.setOnAction(e -> {
            try {
                ArrayList<Book> books = BookFile.readFile();
                StringBuilder sb = new StringBuilder();
                for (Book book : books) {
                    sb.append(book.toString()).append("\n\n");
                }

                TextArea displayArea = new TextArea(sb.toString());
                displayArea.setWrapText(true);
                displayArea.setEditable(false);

                Button closeBtn = new Button("Close");
                VBox vbox = new VBox(10, displayArea, closeBtn);
                vbox.setPadding(new Insets(10));

                Stage displayStage = new Stage();
                displayStage.setTitle("Books File");
                displayStage.setScene(new Scene(vbox, 500, 400));
                displayStage.show();

                closeBtn.setOnAction(closeEvent -> displayStage.close());

            } catch (Exception ex) {
                showError("Failed to read books file.");
            }
        });

        cancelBtn.setOnAction(e -> {
            stage.close();
        });

        // Scene and Stage
        Scene scene = new Scene(root, 500, 400);
        stage.setTitle("Book Entry");
        stage.setScene(scene);
        stage.show();
    }



    // Alert Helpers
    //Displays an error alert with a given message.
    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.setContentText(msg);
        alert.showAndWait();
    }
//Displays an information
    private void showInfo(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
// starts java fx program
    public static void main(String[] args) {
        launch(args);
    }
}




