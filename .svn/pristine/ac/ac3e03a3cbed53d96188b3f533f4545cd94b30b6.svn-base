package gui.controller;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;



public class SinglePlayerController extends CustomController implements Initializable{

	@FXML private Button startBtn;
	@FXML private RadioButton bfsRBtn, dfsRBtn;
	@FXML private ComboBox mapHeight, mapWidth;
	@FXML private String title, algo, description;
	@FXML private TextArea descriptionText;
	@FXML private RadioButton easy, medium, hard;
	@FXML private ToggleGroup algorithms;
	
	/**
	 * Begins the visualisation.
	 */
	private void startGame(){
		int height =  (int) mapHeight.getValue();
		int width = (int) mapWidth.getValue();
		double freeSpaceRatio;
		if(bfsRBtn.isSelected())
			algo = "BFS";
		else if(dfsRBtn.isSelected()) 
			algo = "DFS";
		if(easy.isSelected()){
			freeSpaceRatio = 0.75;
		} else if (medium.isSelected()){
			freeSpaceRatio = 0.50;
		} else if (hard.isSelected()){
			freeSpaceRatio = 0.25;
		}
		
		//add function name to begin the map generation along with the parameters
		
		//mapGeneration(height, width, freeSpaceRatio);
		
		//beginGame(diverColour, algo, startSearchingLeft)
		
	}
	
	//this code is called when the user changes the algorithm that they wish to use to search
	//it updates the algorithm description text.
	
	@FXML
	public void updateDescription(){
		System.out.println("Changed");
		if(dfsRBtn.isSelected()){
			description = "Depth First Search is a search algorithm that searches as deeply "
					+ "as possible before backtracking and searching deeply down another branch of nodes. \n"
					+ "ADVANTAGES: If the treasure is hidden deeply under the ocean, then Depth First Search"
					+ " will definitely have the upper hand against the other algorithms, since it search as deep as possible first"
					+ " before swimming across. \n"
					+ "DISADVANTAGES: If Depth First Search reaches the bottom of the map and the ocean continues to go deeper then the"
					+ " diver will continue to swim deeper into the ocean and become lost. This is because Depth First Search will continue"
					+ " to search deeper and will go into an infinite loop, forever swimming deeper into the ocean.";
			descriptionText.setText(description);
		}
		else if(bfsRBtn.isSelected()){
			description = "Breadth First Search is a search algorithm that searches across all of the ocean. "
					+ "Breadth First Search searches horizontally across the ocean to find the treasure. \n"
					+ "ADVANTAGES: Breadth First Search cannot go into an infinite loop searching for the treasure."
					+ " Breadth First Search is guaranteed to search all of the ocean for the treasure"
					+ " and it will be better at the other algorithms if the treasure is located near the top of the map, "
					+ " since it searches all of the row before moving down to the next. \n"
					+ "DISADVANTAGES: It is more likely that the treasure will be further down in the ocean and Depth First Search"
					+ " is quicker when looking deeper in the ocean.";
			descriptionText.setText(description);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("HELLO");
		EventHandler<MouseEvent> startGame = new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent event) {
		    	System.out.println("start");
			    startGame();
		    }
		};
		startBtn.setOnMouseClicked(startGame);
	    algorithms.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
	        public void changed(ObservableValue<? extends Toggle> ov,
	            Toggle old_toggle, Toggle new_toggle) {
	        		System.out.println("toggle algo");
	        		updateDescription();
	        	}
	      });
		
	}

}
	