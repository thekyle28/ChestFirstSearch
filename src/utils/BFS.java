package utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;



public class BFS<A> {
	
	/**
	 * Find node from.
	 *
	 * @param node The starting node
	 * @param predicate The Predicate
	 * @return Just the node , or Nothing if not found
	 */
	public Maybe<Node<A>> findNodeFrom(Node<A> node, Predicate<A> predicate) {
		Queue<Node<A>> queue = new LinkedList<Node<A>>();
		ArrayList<Node<A>> array = new ArrayList<Node<A>>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node<A> x = queue.remove();
			A content = x.contents();
			if (!array.contains(x)) {
				if (predicate.holds(content)) {
					for(int i = 0; i<array.size(); i++){
					System.out.println(array.get(i));
					}
					return new Just<Node<A>>(x);	
				}
				array.add(x);
				for (Node<A> succ: x.successors()) {
					if (!array.contains(succ))
						queue.add(succ);
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
		Queue<Node<A>> queue = new LinkedList<Node<A>>();
		ArrayList<Node<A>> array = new ArrayList<Node<A>>();
		Map<Node<A>, Node<A>> parentMap = new HashMap<Node<A>, Node<A>>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node<A> x = queue.remove();
			A content = x.contents();
			if (!array.contains(x)) {
				if (predicate.holds(content)) {
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
				for (Node<A> succ: x.successors()) {
					if (!array.contains(succ)) {
						queue.add(succ);
						parentMap.put(succ, x);
						
					}
				}
			}
		}
		return new Nothing<IList<Node<A>>>();
	}
	public ArrayList<Node<A>> getVisitedFrom(Node<A> node, Predicate<A> predicate) {
		Queue<Node<A>> queue = new LinkedList<Node<A>>();
		ArrayList<Node<A>> array = new ArrayList<Node<A>>();
		Map<Node<A>, Node<A>> parentMap = new HashMap<Node<A>, Node<A>>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node<A> x = queue.remove();
			A content = x.contents();
			if (!array.contains(x)) {
				if (predicate.holds(content)) {
					IList<Node<A>> parents = new Nil<Node<A>>();
					parents = parents.append(x);
					Node<A> parent = parentMap.get(x);
					while (!parent.contentsEquals(node.contents())) {
						parents = parents.append(parent);
						parent = parentMap.get(parent);
					}
					parents = parents.append(node);
					return array;
				}
				array.add(x);
				for (Node<A> succ: x.successors()) {
					if (!array.contains(succ)) {
						queue.add(succ);
						parentMap.put(succ, x);
						
					}
				}
			}
		}
		return array;
	}
}


