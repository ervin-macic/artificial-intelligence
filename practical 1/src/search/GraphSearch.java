package search;

import java.util.HashSet;
import java.util.Set;

public class GraphSearch implements Search {
    protected final Frontier frontier;
    protected Set<State> explored;
    protected int generatedNodeCount; 
    public GraphSearch(Frontier frontier) {
        this.frontier = frontier;
        explored = new HashSet<>(); // has O(1) operations that we're interested in, like contains, add, remove
        generatedNodeCount = 0;
    }

    public Node search(Node root, GoalTest goalTest) {
        frontier.clearFrontier();
        frontier.addNode(root);
        explored.clear();
        generatedNodeCount = 1;

        while (!frontier.isEmpty()) {
            Node leaf = frontier.removeNode();
            // # explored = number of states added to the explored set
            // # generated = number of nodes that were created/constructed during the search
            // # expanded = number of nodes whose children were generated 
            // node generated <-> new Node(...),
            // node expanded <-> generate successors of the node
            // node explored <-> explored.add(node.state)
            
            // skip already explored states immediately
            if (explored.contains(leaf.state)) {
                continue;
            }

            if (goalTest.isGoal(leaf.state)) {
                return leaf;
            }

            explored.add(leaf.state);

            for (Action action : leaf.state.getApplicableActions()) {
                State newState = leaf.state.getActionResult(action);

                // don't add already explored states to the frontier
                if (!explored.contains(newState)) {
                    frontier.addNode(new Node(leaf, action, newState));
                    generatedNodeCount += 1;
                }
            }
        }
        return null;
    }
    public int getGeneratedNodeCount() {
        return generatedNodeCount;
    }
}











/*
public
Node search(Node root, GoalTest goalTest) {
  frontier.clearFrontier();
  frontier.addNode(root);
  explored.clear();
  generatedNodeCount = 1;
  while (!frontier.isEmpty()) {
    Node leaf = frontier.removeNode();
    if (goalTest.isGoal(leaf.state)) {
      return leaf;
    }  // Add leaf's state to explored set
    if (!explored.contains(leaf.state)) {
      explored.add(leaf.state);
      for (Action action : leaf.state.getApplicableActions()) {
        State newState = leaf.state.getActionResult(action);
        frontier.addNode(new Node(leaf, action, newState));
        generatedNodeCount += 1;
      }
    }
  }
  return null;
}
*/