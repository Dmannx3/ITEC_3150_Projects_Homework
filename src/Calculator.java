/*
Create a Function calculator using Java FX
 */
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label num1lbl = new Label("Number 1: ");
        TextField num1Txt = new TextField();
        HBox num1HB = new HBox();
        num1HB.setSpacing(20);
        num1HB.setPadding(new Insets(5));
        num1HB.getChildren().addAll(num1lbl, num1Txt);

        Label num2lbl = new Label("Number 2: ");
        TextField num2Txt = new TextField();
        HBox num2HB = new HBox();
        num2HB.setSpacing(19);
        num2HB.setPadding(new Insets(5));
        num2HB.getChildren().addAll(num2lbl, num2Txt);

        Label oplbl = new Label("Operation: ");
        String[] ops = {"+", "-", "*", "/"};
        ObservableList<String> opList = FXCollections.observableArrayList(ops);
        ComboBox<String> opBox = new ComboBox<>(opList);
        HBox opHB = new HBox();
        opHB.setSpacing(18);
        opHB.setPadding(new Insets(5));
        opHB.getChildren().addAll(oplbl, opBox);

        Label resultLbl = new Label("Result: ");
        Label ansLbl = new Label();
        HBox resultHB = new HBox();
        resultHB.setSpacing(30);
        resultHB.setPadding(new Insets(10));
        resultHB.getChildren().addAll(resultLbl, ansLbl);

        Button opBtn = new Button("Calculate");
        opBtn.setOnAction(e -> {
            double first, second, result = 0;
            try {
                first = Double.parseDouble(num1Txt.getText());
                second = Double.parseDouble(num2Txt.getText());
                String operation = opBox.getValue();

                if (operation == null) {
                    throw new IllegalArgumentException("Please select an operation.");
                }

                switch (operation) {
                    case "+" -> result = first + second;
                    case "-" -> result = first - second;
                    case "*" -> result = first * second;
                    case "/" -> {
                        if (second == 0) {
                            throw new ArithmeticException("Cannot divide by zero.");
                        }
                        result = first / second;
                    }
                }
                ansLbl.setText(String.valueOf(result)); // Display result
            } catch (NumberFormatException nfe) {
                showError("Must enter a valid number.");
            } catch (IllegalArgumentException | ArithmeticException ex) {
                showError(ex.getMessage());
            }
        });

        Button exitBtn = new Button("Exit");
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
                Platform.exit();
            }
        });

        HBox btnHB = new HBox();
        btnHB.setSpacing(100);
        btnHB.setPadding(new Insets(30));
        btnHB.getChildren().addAll(opBtn, exitBtn);

        VBox calcVB = new VBox();
        calcVB.setSpacing(5);
        calcVB.setPadding(new Insets(10));
        calcVB.getChildren().addAll(num1HB, num2HB, opHB, resultHB, btnHB);

        BorderPane bp = new BorderPane();
        bp.setCenter(calcVB);
        Scene scene = new Scene(bp, 300, 300);
        stage.setScene(scene);
        stage.show();
    }


    private void showError(String message) {
        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setTitle("Error");
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
