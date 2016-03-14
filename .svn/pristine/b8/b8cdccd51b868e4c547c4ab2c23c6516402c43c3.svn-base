package graphmodel;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import utils.BFS;
import utils.Coordinate;
import utils.Graph;
import utils.Maybe;
import utils.Node;
import utils.Predicate;

public class GraphModel {

	int width = 5;
	int height = 5;
	
	public GraphModel() {
		
	}
	
	public Maybe<Node<Coordinate>> BFSpath(int xCoord, int yCoord){
		
		/* Initialising the testing scripts */
	    Predicate<Coordinate> p = new Predicate<Coordinate>(){
	    	public boolean holds(Coordinate x) {
	    		if(x.equals(new Coordinate(xCoord,yCoord)) )
	    				return true;
	    		return false;
	    	}
	    };
	    
	    BFS<Coordinate> test2 = new BFS<Coordinate>();
	    Coordinate coord = new Coordinate(2, 3);
	    
	    Set<Node<Coordinate>> nodes = generateRandomGraph(5, 5).nodes();
	    Node<Coordinate> node =  null;
	    if (nodes.iterator().hasNext()) {
	    	node = nodes.iterator().next();
	    }
	    Maybe<Node<Coordinate>> node3 = test2.findNodeFrom(node, p);
	    System.out.println("\n BFS \n" + node3);
	    return node3;
	}
	
	public Graph<Coordinate> generateRandomGraph(int width, int height) {
		
		Random random = new Random();
		
		ArrayList<Node<Coordinate>> nodes = new ArrayList<Node<Coordinate>>();
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				Coordinate coord = new Coordinate(x, y);
				Node<Coordinate> node = new Node<Coordinate>(coord);
				nodes.add(node);
			}
		}
		
		int numOfNodesToDelete = width*height/5; // CHANGE THIS
		
		System.out.println(nodes.size() - numOfNodesToDelete);
		
		while(numOfNodesToDelete > 0) {
			int deleteIndex = random.nextInt(nodes.size());
			nodes.remove(deleteIndex);
			numOfNodesToDelete--;
		}
		
		// Add the successors to each node
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				Coordinate test = new Coordinate(x, y);
				Coordinate testLeft = new Coordinate(x-1, y);
				Node<Coordinate> nodeLeft = new Node<Coordinate>(testLeft);
				
				int indexOfNode = coordinateIndexOf(nodes, test);
				Node<Coordinate> left = getNodeFromList(nodes, nodeLeft);
				if(left != null) {
					nodes.get(indexOfNode).addSuccessor(left);
				}
				
				
				// Right
				Coordinate testRight = new Coordinate(x+1, y);
				Node<Coordinate> nodeRight = new Node<Coordinate>(testRight);
				Node<Coordinate> right = getNodeFromList(nodes, nodeRight);
				if(right != null) {
					nodes.get(indexOfNode).addSuccessor(right);
				}
				
				// Up
				Coordinate testAbove = new Coordinate(x, y+1);
				Node<Coordinate> nodeAbove = new Node<Coordinate>(testAbove);
				Node<Coordinate> above = getNodeFromList(nodes, nodeAbove);
				if(above != null) {
					nodes.get(indexOfNode).addSuccessor(above);
				}
				
				// Below
				Coordinate testBelow = new Coordinate(x, y-1);
				Node<Coordinate> nodeBelow = new Node<Coordinate>(testBelow);
				Node<Coordinate> below = getNodeFromList(nodes, nodeBelow);
				if(below != null) {
					nodes.get(indexOfNode).addSuccessor(below);
				}
			}
		}
		
		Graph<Coordinate> graph = new Graph<Coordinate>();
		
		for(Node<Coordinate> node : nodes) {
			graph.addNode(node);
//			System.out.println(node);
//			System.out.println(node.successors());
		}
		
		return graph;
	}
		
	
	public Graph<Coordinate> getTestGraph() {
		int [] [] test = {
				{0,1,0,2,1,1},
				{0,2,0,1,0,3},
				{0,3,0,2,0,4},
				{0,4,0,3,1,4},
				{1,0,1,1,2,0},
				{1,1,1,0,2,1},
				{1,4,0,4},
				{2,0,2,1,3,0},
				{2,1,1,1,2,0,2,2,3,1},
				{2,2,2,1,2,3},
				{2,3,2,2,3,3},
				{3,0,2,0,3,1},
				{3,1,2,1,3,0,4,1},
				{3,3,2,3,4,3},
				{4,1,3,1},
				{4,3,3,3,4,4},
				{4,4,4,3}		
		};

	    Graph<Coordinate> ourTestGraph = new Graph<Coordinate>();
	
	    for (int i = 0; i < test.length; i++) {
	      // What we are going to do relies on the two following facts
	      // about nick:
	      assert(test[i].length >= 2);       // (1)
	      assert(test[i].length % 2 == 0);   // (2)
	
	      int x = test[i][0]; // Can't get array out of bounds 
	      int y = test[i][1]; // because of assertion (1).
	      Coordinate c = new Coordinate(x, y);
	      Node<Coordinate> node = ourTestGraph.nodeWith(c);
	
	      // And next we add its successors. We rely on assertion (2)
	      // again to avoid array out of bounds. Now we start from
	      // position 2, as positions 0 and 1 have already been looked at
	      // (they are x and y). Notice that we need to increment by 2.
	
	      for (int j = 2; j < test[i].length; j=j+2) {
	        int sx = test[i][j];   
	        int sy = test[i][j+1]; 
	        Coordinate sc = new Coordinate(sx, sy);
	        Node<Coordinate> s = ourTestGraph.nodeWith(sc);
	        node.addSuccessor(s);
	      }
	    }
	    
	    return ourTestGraph;
	}
	
	
	public int coordinateIndexOf(ArrayList<Node<Coordinate>> nodes, Coordinate coord2) {
		for(int i = 0; i < nodes.size(); i++) {
			Coordinate coord = nodes.get(i).contents();
			
			if(coord.x == coord2.x && coord.y == coord2.y) {
				return i;
			}
		}
		
		
		return 99999;
	}
	
	public Node<Coordinate> getNodeFromList(ArrayList<Node<Coordinate>> nodes, Node<Coordinate> nodeToCheck) {
		for(Node<Coordinate> node : nodes) {
			Coordinate coord = node.contents();
			Coordinate coord2 = nodeToCheck.contents();
			if(coord.x == coord2.x && coord.y == coord2.y) {
				return node;
			}
		}
		return null;
	}
	
	public boolean arrayListContains(ArrayList<Node<Coordinate>> nodes, Node<Coordinate> nodeToCheck) {
		for(Node<Coordinate> node : nodes) {
			Coordinate coord = node.contents();
			Coordinate coord2 = nodeToCheck.contents();
			if(coord.x == coord2.x && coord.y == coord2.y) {
				return true;
			}
		}
		return false;
	}
	
}
