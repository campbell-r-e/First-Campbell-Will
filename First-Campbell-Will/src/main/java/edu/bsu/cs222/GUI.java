package edu.bsu.cs222;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.util.List;

public class GUI extends Region {

    public void primaryStage()  {
        Stage primaryStage = new Stage();
        VBox parent = new VBox();
        parent.getChildren().add(new Label("Wikipedia Page Revision collector"));
        HBox urlArea = new HBox(new Label("Enter Article name or type exit to exit or type command to enter command mode."));
        TextField textField = new TextField();
        urlArea.getChildren().add(textField);
        parent.getChildren().add(urlArea);
        Button button = new Button("Display Revisions");
        button.setOnMouseClicked(event -> GUIController.guiControlMouseClick(textField,primaryStage) );
        parent.getChildren().add(button);
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    public void secondaryStage(String userQuery) {
        String revisionsResult = null;
        String redirectResult = null;
        try {
            String articleData = WikipediaConnection.dataPuller(userQuery);
            List<Revision> listRevision = WikipediaParser.getRevisions(articleData, 1);
            List<Redirect> listRedirect = WikipediaParser.getRedirects(articleData);
            Printer printData = new Printer();
            redirectResult = printData.returnsRedirects(listRedirect);
            revisionsResult = printData.returnsRevisions(listRevision);
        } catch (IOException e) {
            showNetworkError();
            return;
        }
        Stage primaryStage = new Stage();
        VBox parent = new VBox();
        parent.getChildren().add(new Label("Wikipedia Page Revision results"));
        parent.getChildren().add(new Text(redirectResult));
        parent.getChildren().add(new Text(revisionsResult));
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    public void showNetworkError() {
        Stage netorkErrorStage = new Stage();
        Scene scene = new Scene(new Label("There was a network error"));
        netorkErrorStage.setScene(scene);
        netorkErrorStage.show();
    }

    public void showInputError() {
        Stage inputErrorStage = new Stage();
        Scene scene = new Scene(new Label("No article entered"));
        inputErrorStage.setScene(scene);
        inputErrorStage.show();
    }

    public static void showNoArticleError() {
        Stage articleErrorStage = new Stage();
        Scene scene = new Scene(new Label("No article exists with that name"));
        articleErrorStage.setScene(scene);
        articleErrorStage.show();
    }
}
