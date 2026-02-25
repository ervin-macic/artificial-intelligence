package search;

public class Node {
	public final Node parent;
	public final Action action; // taken to get from parent state to this node's state. 
	public final State state;
	public final int depth;
	public float value;
	public int gValue;

	public Node(Node parent, Action action, State state, int depth) {
		this.parent = parent;
		this.action = action;
		this.state = state;
		this.depth = depth;
		this.value = 0;
		if (parent != null) {
			this.gValue = parent.gValue + action.cost(parent, this);
		} else {
			this.gValue = 0;
		}
	}
	public Node(Node parent, Action action, State state) {
		this.parent = parent;
		this.action = action;
		this.state = state;
		this.depth = 0;
		this.value = 0;
		if (parent != null) {
			this.gValue = parent.gValue + action.cost(parent, this);
		} else {
			this.gValue = 0;
		}
	}
}
