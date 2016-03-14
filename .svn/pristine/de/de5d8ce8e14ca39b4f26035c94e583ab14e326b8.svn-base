package gui.controller;

import java.io.IOException;

import gui.MainMenu;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CustomController {
	
	public void switchScene(Event event, String scene) throws IOException{
	    Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        AnchorPane newPane = (AnchorPane) FXMLLoader.load(MainMenu.class.getResource(scene));
		Scene newScene = new Scene(newPane,700,739);
		stage.setScene(newScene);
	}
	
}
