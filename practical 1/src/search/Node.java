package search;

public class Node {
	public final Node parent;
	public final Action action; // taken to get from parent state to this node's state. understand distinction between state and node
	public final State state;
	
	public Node(Node parent, Action action, State state) {
		this.parent = parent;
		this.action = action;
		this.state = state;
	}
}
