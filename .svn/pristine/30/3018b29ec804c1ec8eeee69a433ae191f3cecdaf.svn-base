package gui;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;



public class SinglePlayerController extends Application{

	public  Button start;
	public  RadioButton breadthFirstSearch;
	public  RadioButton depthFirstSearch;
	public  ComboBox mapHeight;
	private String Title;
	public  ComboBox mapWidth;
	private String algo;
	private String description;
	public TextArea descriptionText;
	public RadioButton Easy;
	public RadioButton Medium;
	public RadioButton Hard;
	
	//the code called when the start button is clicked, it begins a game with the settings that the user has selected.
	public void startGame(){
		int height =  (int) mapHeight.getValue();
		int width = (int) mapWidth.getValue();
		double freeSpaceRatio;
		if(breadthFirstSearch.isSelected())
			algo = "BFS";
		else if(depthFirstSearch.isSelected()) 
			algo = "DFS";
		if(Easy.isSelected()){
			freeSpaceRatio = 0.75;
		} else if (Medium.isSelected()){
			freeSpaceRatio = 0.50;
		} else if (Hard.isSelected()){
			freeSpaceRatio = 0.25;
		}
		
		//add function name to begin the map generation along with the parameters
		
		//mapGeneration(height, width, freeSpaceRatio);
		
		//beginGame(diverColour, algo, startSearchingLeft)
		
	}
	
	//this code is called when the user changes the algorithm that they wish to use to search
	//it updates the algorithm description text.
	public void updateDescription(){
		
		if(depthFirstSearch.isSelected()){
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
		else if(breadthFirstSearch.isSelected()){
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
	public void start(Stage primaryStage) {
		try {
			//get the fxml file and link to it the controller.
            Parent page = FXMLLoader.load(SinglePlayerController.class.getResource("fxgraph/SinglePlayer.fxml"));
			Scene scene = new Scene(page);
			
			//set the scene and show it.
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
	