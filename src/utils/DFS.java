package utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;



public class DFS<A> {
	
	/**
	 * Find node from.
	 *
	 * @param node The starting node
	 * @param predicate The Predicate
	 * @return Just the node , or Nothing if not found
	 */
	public Maybe<Node<A>> findNodeFrom(Node<A> node, Predicate<A> predicate){
		Stack<Node<A>> stack = new Stack<Node<A>>();
		ArrayList<Node<A>> array = new ArrayList<Node<A>>();
		stack.push(node);				
		while(!stack.isEmpty()){
			Node<A> x = stack.pop();
			A content = x.contents();
			if(!array.contains(x)){
				if(predicate.holds(content)){
					return new Just<Node<A>>(x);
				}
				array.add(x);
				for(Node<A> succ: x.successors()){
					if (!array.contains(succ))
						stack.push(succ);
				}
			}
		}
		return new Nothing<Node<A>>();
	}
	
	/**
	 * Find path from.
	 *
	 * @param node The starting node
	 * @param predicate The Predicate
	 * @return the path to the node if found
	 */
	public Maybe<IList<Node<A>>> findPathFrom(Node<A> node, Predicate<A> predicate) {
		Stack<Node<A>> stack = new Stack<Node<A>>();
		ArrayList<Node<A>> array = new ArrayList<Node<A>>();
		Map<Node<A>, Node<A>> parentMap = new HashMap<Node<A>, Node<A>>();
		stack.push(node);				
		while(!stack.isEmpty()){
			Node<A> x = stack.pop();
			A content = x.contents();
			if(!array.contains(x)){
				if(predicate.holds(content)){
					IList<Node<A>> parents = new Nil<Node<A>>();
					parents = parents.append(x);
					Node<A> parent = parentMap.get(x);
					while (!parent.contentsEquals(node.contents())) {
						parents = parents.append(parent);
						parent = parentMap.get(parent);
					}
					parents = parents.append(node);
					return new Just<IList<Node<A>>>(parents.reverse());
				}
				array.add(x);
				for(Node<A> succ: x.successors()){
					if (!array.contains(succ)) {
						stack.push(succ);
						parentMap.put(succ, x);
					}
				}
			}
		}
		return new Nothing<IList<Node<A>>>();
	}
}

