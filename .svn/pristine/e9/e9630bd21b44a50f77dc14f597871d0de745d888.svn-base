package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gui.MainMenu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainMenuController extends CustomController implements Initializable {
	
	@FXML private Pane playBtn;
	@FXML private Pane settingsBtn;
	@FXML private Pane quitBtn;	
	
	@FXML
	private void gotoGameSelection(MouseEvent event) throws IOException {
		switchScene(event, "fxgraph/GameModeSelection.fxml");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		EventHandler<MouseEvent> shrinkBtn = new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent event) {
			    Pane source = (Pane) event.getSource();
			    source.resize(source.getWidth() - 50, source.getHeight() - 50); 
			    
		    }
		};

		playBtn.setOnMousePressed(shrinkBtn);
		settingsBtn.setOnMousePressed(shrinkBtn);
		quitBtn.setOnMousePressed(shrinkBtn);
		
		quitBtn.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>(){
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		    	System.exit(0);
		    }
		});
		
	}

}
