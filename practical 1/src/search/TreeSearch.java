package search;

public class TreeSearch implements Search {
    protected final Frontier frontier;
    protected int generatedNodeCount; 
    public TreeSearch(Frontier frontier) {
        this.frontier = frontier;
        generatedNodeCount = 0;
    }

    public Node search(Node root, GoalTest goalTest) {
        frontier.clearFrontier();
        frontier.addNode(root);
        generatedNodeCount = 1; // count root when generated
        while (!frontier.isEmpty()) {
            Node leaf = frontier.removeNode();
            if (goalTest.isGoal(leaf.state)) {
                return leaf;
            }
            // Expand the leaf
            for (Action action : leaf.state.getApplicableActions()) {
                State newState = leaf.state.getActionResult(action);
                frontier.addNode(new Node(leaf, action, newState));
                generatedNodeCount += 1; // count node when generated
            }
        }
        return null;
    }
    public int getGeneratedNodeCount() {
        return generatedNodeCount;
    }
}
