package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class MultiplayerController extends CustomController implements Initializable{
	@FXML private Pane backPane, okPane, treasureRandomPane, treasureSelectPane;
	@FXML private RadioButton Easy, Medium, Hard, treasureSelectRBtn, treasureRandomRBtn;
	@FXML private ComboBox<Integer> mapHeight, mapWidth;
	
	@FXML
	private void gotoMultiplayer2(MouseEvent event) throws IOException{
		switchScene(event, "fxgraph/Multiplayer2");
	}
	
	@FXML
	private void gotoGameSelection(MouseEvent event) throws IOException {
		switchScene(event, "fxgraph/GameModeSelection.fxml");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//initialise the combobox values
		setComboboxData();
	}
	
	@FXML
	private void setComboboxData() {
		mapHeight.getItems().addAll(1,2,3,4,5,6,7,8,9,
				10,11,12,13,14,15,16,17,18,19,20);
		mapWidth.getItems().addAll(1,2,3,4,5,6,7,8,9,
				10,11,12,13,14,15,16,17,18,19,20);	
	}

}
