package visualisation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;

import graphmodel.GraphModel;
import utils.BFS;
import utils.Coordinate;
import utils.Graph;
import utils.IList;
import utils.Maybe;
import utils.Node;
import utils.Nothing;
import utils.Predicate;

public class GamePanel extends JPanel {

	private Graph<Coordinate> graph;
	private ArrayList<Coordinate> visited;
	private Coordinate target;
	private Coordinate start;
	private ArrayList<Coordinate> path;
	private int width;
	private int height;
	
	public GamePanel(Graph<Coordinate> g, int numNodesWidth, int numNodesHeight)
	{
		this.width = numNodesWidth;
		this.height = numNodesHeight;
		this.graph=g;
//		TestBFS();
		TestBFSRandom();
	}
	
	private void TestBFS()
	{
		Predicate<Coordinate> p = new Predicate<Coordinate>(){
	    	public boolean holds(Coordinate x) {
	    		if(x.equals(new Coordinate(2,2)))
	    				return true;
	    		return false;
	    	}
	    };
	    target = new Coordinate(2,2);
	    Node<Coordinate> startNode = this.graph.nodeWith(new Coordinate(2,0));
	    start = startNode.contents();
	    int c = 0;
	    this.doBFS(startNode, p);
	    visited=new ArrayList<Coordinate>();
	    for(Node<Coordinate> node:this.showVisited(startNode, p))
	    {
	    	visited.add(node.contents());
	    }
	}
	
	private void TestBFSRandom()
	{
	    Node<Coordinate> startNode = generateRandomStart();
	    start = startNode.contents();
	    target = generateRandomGoal(startNode).contents();
		Predicate<Coordinate> p = new Predicate<Coordinate>(){
	    	public boolean holds(Coordinate x) {
	    		if(x.equals(target))
	    				return true;
	    		return false;
	    	}
	    };
	    
	    this.doBFS(startNode, p);
	    visited=new ArrayList<Coordinate>();
	    for(Node<Coordinate> node:this.showVisited(startNode, p))
	    {
	    	visited.add(node.contents());
	    }
	}
	
	private Node<Coordinate> generateRandomStart() {
		Random rand = new Random();
		Set<Node<Coordinate>> nodes = graph.nodes();
		int nodeIndex = rand.nextInt(nodes.size());
		int count = 0;
		for (Node<Coordinate> node : nodes) {
			if (count == nodeIndex) {
				return node;
			}
			count++;
		}
		//this should only happen with empty graph
		return null;
	}
	
	private Node<Coordinate> generateRandomGoal(Node<Coordinate> startNode) {
		Random rand = new Random();
		
		ArrayList<Node<Coordinate>> nodes = new ArrayList<Node<Coordinate>>();
		nodes.addAll(graph.nodes());
		
		//maybe there is a more efficient way to do this?
		//removes all nodes that are unreachable from startNode
		BFS<Coordinate> doBFS = new BFS<Coordinate>();
		for (int i = 0; i < nodes.size(); i++) {
			
			Node<Coordinate> node = nodes.get(i);
			Coordinate coord = node.contents();
			
			Predicate<Coordinate> p = new Predicate<Coordinate>(){
		    	public boolean holds(Coordinate x) {
		    		if(x.equals(coord))
		    				return true;
		    		return false;
		    	}
		    };
		    
			if (doBFS.findNodeFrom(startNode, p).isNothing() || node == startNode) {
				nodes.remove(i);
			}
		}
		int nodeIndex = rand.nextInt(nodes.size());
		//is null with empty graph or when (startNode == GoalNode)
		return nodes.get(nodeIndex);
	}
	
	private ArrayList<Node<Coordinate>> showVisited(Node<Coordinate> node, Predicate<Coordinate> pred)
	{
		BFS<Coordinate> doBFS = new BFS<Coordinate>();
		return doBFS.getVisitedFrom(node, pred);
	}
	
	private void doBFS(Node<Coordinate> node, Predicate<Coordinate> pred)
	{
		BFS<Coordinate> doBFS = new BFS<Coordinate>();
		Maybe<IList<Node<Coordinate>>> pathBFS = doBFS.findPathFrom(node, pred);
		path=new ArrayList<Coordinate>();
	    for (int i = 0; i < pathBFS.fromMaybe().size(); i++) {
	    	System.out.println("BFS Path " + pathBFS.fromMaybe().get(i).contents().x + ", " + pathBFS.fromMaybe().get(i).contents().y +" node number: "+ (i+1));
	    	path.add(pathBFS.fromMaybe().get(i).contents());
	    }
	}
	
	public void paintComponent(Graphics g) {
		repaint();
		
		Set<Node<Coordinate>> set = this.graph.nodes();
		for(Node<Coordinate> node:set)
		{
		    int x = node.contents().x;
		    int y = node.contents().y;
		    
		    if(start.equals(node.contents()))
		    {
		    	g.setColor(Color.black);
		    	g.fillOval(x*(getWidth()/width), y*(getHeight()/height), 40, 40);
		    }
		    
		    else if(target.equals(node.contents()))
		    {
		    	g.setColor(Color.blue);
		    	g.fillOval(x*(getWidth()/width), y*(getHeight()/height), 40, 40);
		    }
		    else if(path.contains(node.contents()))
		    {
		    	g.setColor(Color.green);
		    	g.fillOval(x*(getWidth()/width), y*(getHeight()/height), 40, 40);
		    }
		    else if(visited.contains(node.contents()))
		    {
		    	g.setColor(Color.red);
		    	g.fillOval(x*(getWidth()/width), y*(getHeight()/height), 40, 40);
		    }
	
		    
		    g.setColor(Color.black);
		    g.drawOval(x*(getWidth()/width), y*(getHeight()/height), 40, 40);
		    
		    Set<Node<Coordinate>> setSuc = node.successors();
		    for(Node<Coordinate> succ:setSuc)
		    {
		    	int x1 = succ.contents().x;
			    int y1 = succ.contents().y;
			    g.drawLine(x*(getWidth()/width)+20,  y*(getHeight()/height)+20, x1*(getWidth()/width)+20,  y1*(getHeight()/height)+20);
		    }
		}
	  }
	
	public static void main(String args[]) {
		JFrame frame = new JFrame("Oval Sample");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    frame.setLayout(new GridLayout(2, 2));
	    GraphModel model = new GraphModel();
		
	    GamePanel panel = new GamePanel(model.generateRandomGraph(5, 5), 5, 5);
//	    GamePanel panel = new GamePanel(model.getTestGraph());
	    frame.add(panel);

	    frame.setSize(300, 200);
	    frame.setVisible(true);
	}
}
