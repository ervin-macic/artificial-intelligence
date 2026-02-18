package search;

import java.util.HashSet;
import java.util.Set;

public class GraphSearch implements Search {
    protected final Frontier frontier;
    protected Set<State> explored;
    protected int generatedNodeCount; 
    public GraphSearch(Frontier frontier) {
        this.frontier = frontier;
        explored = new HashSet<>();
        generatedNodeCount = 0;
    }

    public Node search(Node root, GoalTest goalTest) {
        frontier.clearFrontier();
        frontier.addNode(root);
        explored.clear();
        generatedNodeCount = 1;
        while (!frontier.isEmpty()) {
            Node leaf = frontier.removeNode();
            if (goalTest.isGoal(leaf.state)) {
                return leaf;
            }
            // Add leaf's state to explored set
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
    public int getGeneratedNodeCount() {
        return generatedNodeCount;
    }
}
