package graphview;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;

import graphmodel.GraphModel;
import utils.BFS;
import utils.Coordinate;
import utils.Graph;
import utils.Node;
import utils.Predicate;
import utils.RoundButton;

public class GraphView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int GRID_WIDTH = 700;
	private static final int GRID_HEIGHT = 700;
	
	public GraphView() {
		super();
		setResizable(false);
		setSize(GRID_WIDTH,GRID_HEIGHT);
		setTitle("Chest First Search");
		setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public void drawGraph(Graph<Coordinate> graph) {
		// given a graph as a parameter in the form of a 2D array
		// loop through the graph adding the nodes one by one
		
		int nodeNum = 1;
		
		for(Node<Coordinate> node: graph.nodes()) {
				int nodeX = node.contents().x;
				int nodeY = node.contents().y;
				
				// translate node co-ordinates to actual JFrame co-ordinates
				// since each node will be a button 
				
//				System.out.println("Node x : " + nodeX  + "  Node y: " + nodeY);
				
				int buttonDiameter = (GRID_WIDTH / 5) / 2;
				int buttonStartX = (nodeX * (GRID_WIDTH / 5)) + (buttonDiameter / 2); // 5 is num of squares 
				int buttonStartY = (nodeY * (GRID_HEIGHT / 5)) + (buttonDiameter / 2); 
				
				JButton nodeBtn = new JButton();		
				nodeBtn.setSize(buttonDiameter, buttonDiameter);
			  Predicate<Coordinate> pred = new Predicate<Coordinate>(){
			    	public boolean holds(Coordinate x) {
			    		if(x.equals(new Coordinate(2,0)))
			    				return true;
			    		return false;
			    	}
			    };
				BFS<Coordinate> doBFS = new BFS<Coordinate>();
				GraphModel model = new GraphModel();
				model.BFSpath(0, 0);
				nodeBtn.setText(nodeX + ", " + nodeY);
				nodeBtn.setLocation(buttonStartX, buttonStartY);
				
				this.add(nodeBtn);
				
				nodeBtn.setVisible(true);
				this.repaint();
		}
	}

	
	public static void main(String args[]) {
		GraphModel model = new GraphModel();
		Graph<Coordinate> graph = model.generateRandomGraph(5, 5);
		
		GraphView view = new GraphView();
		view.drawGraph(graph);
		
	}
}
