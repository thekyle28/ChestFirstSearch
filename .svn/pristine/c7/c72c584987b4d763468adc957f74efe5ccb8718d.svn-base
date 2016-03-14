package visualisation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import graphmodel.GraphModel;
import utils.Coordinate;
import utils.DFS;
import utils.Graph;
import utils.Node;
import utils.Predicate;

public class MapFrame extends JFrame {
	
	private JPanel mainPanel;
	private JPanel gamePanel;
	private JPanel info;
	private JPanel visitedPanel;
	private int numNodesWidth  = 30; 
	private int numNodesHeight = 30;
	private static Graph<Coordinate> g;
	
	public MapFrame(Graph<Coordinate> g) {
		super("Treasure Hunt");
		makePanels();
		displayInfo();
		pack();
		this.g=g;
		
	}
	
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 MapFrame mapFrame = new MapFrame(g);
                 mapFrame.setSize(800,600);
                 mapFrame.setVisible(true);

            }
      });
	}

	private void makePanels() {
		mainPanel = new JPanel();
		info = new JPanel();
		GraphModel model = new GraphModel();
		gamePanel = new GamePanel(model.generateRandomGraph(numNodesWidth, numNodesHeight), numNodesWidth, numNodesHeight);
		//gamePanel = new GamePanel(model.getTestGraph());
		visitedPanel = new JPanel();
		
		mainPanel.setLayout(new BorderLayout());
		gamePanel.setLayout(new GridLayout(numNodesWidth, numNodesHeight, 8, 8));
		
		mainPanel.add(gamePanel, BorderLayout.CENTER);
		mainPanel.add(visitedPanel, BorderLayout.EAST);
		mainPanel.add(info,BorderLayout.SOUTH);
		this.add(mainPanel);
		
	
	}
	
	private void displayInfo() {
		JLabel lb1 = new JLabel("Green - Path    ");
		JLabel lb2 = new JLabel("Blue - Node to reach        ");
		JLabel lb3 = new JLabel("Red - nodes visited    ");
		JLabel lb4 = new JLabel("Black - starting node      ");
		info.add(lb1);
		info.add(lb2);
		info.add(lb3);
		info.add(lb4);
	}
}
