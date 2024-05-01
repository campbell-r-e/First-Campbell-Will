package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class GUIController extends Application {
    public static String userQuery = "";

    public static void main(String[] args){
       launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
        GUI gui = new GUI();
        gui.primaryStage();
    }

    public static void guiControlMouseClick(TextField textField, Stage primaryStage){
        userQuery = textField.getText();
        primaryStage.close();
        if (userQuery.isEmpty()) {
            GUI no_input = new GUI();
            no_input.showInputError();
            return;
        }
        GUI gui = new GUI();
        gui.secondaryStage(userQuery);
    }
}
