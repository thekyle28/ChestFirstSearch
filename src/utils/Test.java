package utils;
public class Test {

	public static void main(String[] args) {
		
		int [] [] test = {
				{0,1,0,2,1,1},
				{0,2,0,1,0,3},
				{0,3,0,2,0,4},
				{0,4,0,3,1,4},
				{1,0,1,1,2,0},
				{1,1,0,1,1,0,2,1},
				{1,4,0,4},
				{2,0,1,0,2,1,3,0},
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
	   
	    
	    /* Initialising the testing scripts */
	    Predicate<Coordinate> p = new Predicate<Coordinate>(){
	    	public boolean holds(Coordinate x) {
	    		if(x.equals(new Coordinate(2,0)) )
	    				return true;
	    		return false;
	    	}
	    };

	    DFS<Coordinate> test1 = new DFS<Coordinate>();
	    BFS<Coordinate> test2 = new BFS<Coordinate>();
	    System.out.println("start : ");
	    int c = 0;
	    for(Node<Coordinate> node : ourTestGraph.nodes()){
	    	System.out.println(c + ", " + ourTestGraph.nodes().size() + " (" + node.contents().x + ", " + node.contents().y +")");
	    	c++;
	    }
	    Coordinate coord = new Coordinate(2, 3);
	    
	    Node<Coordinate> node = ourTestGraph.nodeWith(coord);
	    Maybe<Node<Coordinate>> node2 = test1.findNodeFrom(node, p);
	    Maybe<Node<Coordinate>> node3 = test2.findNodeFrom(node, p);
	    System.out.println("\n DFS \n" + node2);
	    System.out.println("\n BFS \n" + node3);
	    /* Using a try - catch for the errors */
	    try {
		    System.out.println("\n DFS \n" + node2.fromMaybe().contents().x +", "+ node2.fromMaybe().contents().y );
		    System.out.println("\n BFS \n" + node3.fromMaybe().contents().x +", "+ node3.fromMaybe().contents().y );
		    
		   
		    System.out.println("\n BFS \n");
		    Maybe<IList<Node<Coordinate>>> pathBFS = test2.findPathFrom(node, p);
		    for (int i = 0; i < pathBFS.fromMaybe().size(); i++) {
		    	System.out.println("BFS Path " + pathBFS.fromMaybe().get(i).contents().x + ", " + pathBFS.fromMaybe().get(i).contents().y +" node number: "+ (i+1));
		    }
		    
		    System.out.println("\n DFS \n");
		    Maybe<IList<Node<Coordinate>>> pathDFS = test1.findPathFrom(node, p);
		    for (int i = 0; i < pathDFS.fromMaybe().size(); i++) {
		    	System.out.println("DFS Path " + pathDFS.fromMaybe().get(i).contents().x + ", " + pathDFS.fromMaybe().get(i).contents().y +" node number: "+ (i+1));
		    }
	   } catch(RuntimeException e) {
		   System.out.println("\n The node can't be found");
	   }
	}
}

