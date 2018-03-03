package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends Application implements EventHandler<ActionEvent> {

    private Button button;
    private TextField textField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("LOL");
        HBox layout = new HBox();


        button = new Button("btn1");
        button.setOnAction(this);
        button.setMinSize(50,30);
        button.setMaxSize(400,30);
        layout.getChildren().add(button);

        textField = new TextField();
        textField.setEditable(true);
        layout.getChildren().add(textField);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == button) {
            button.setText("u pressed me");
        }
    }
}
