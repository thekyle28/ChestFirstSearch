package gui;
	

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MainMenu extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
            AnchorPane mainMenuPane = (AnchorPane) FXMLLoader.load(MainMenu.class.getResource("fxgraph/MainMenu.fxml"));
			Scene scene = new Scene(mainMenuPane,700,739);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Chest First Search!");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
