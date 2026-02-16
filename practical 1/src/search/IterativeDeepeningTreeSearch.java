package search;

public class IterativeDeepeningTreeSearch implements Search {
    public Frontier frontier = new DepthFirstFrontier();
    protected int generatedNodeCount;
    protected int overallMaxFrontierSize;

    public IterativeDeepeningTreeSearch() {
        generatedNodeCount = 0;
    }

    public Node search(Node root, GoalTest goalTest) {
        generatedNodeCount = 0;
        int limit = 0;
        overallMaxFrontierSize = 0;

        while (limit < 1000) {
            frontier.clearFrontier();
            frontier.addNode(root);

            while (!frontier.isEmpty()) {
                Node leaf = frontier.removeNode();
                generatedNodeCount += 1;

                if (goalTest.isGoal(leaf.state)) {
                    return leaf;
                }

                if (leaf.depth < limit) {
                    for (Action action : leaf.state.getApplicableActions()) {
                        State newState = leaf.state.getActionResult(action);
                        frontier.addNode(
                            new Node(leaf, action, newState, leaf.depth + 1)
                        );
                    }
                }
            }
            limit++;
            overallMaxFrontierSize = Math.max(
                overallMaxFrontierSize,
                frontier.getMaxFrontierSize()
            );

        }
        return null;
    }

    public int getGeneratedNodeCount() {
        return generatedNodeCount;
    }

    public int getMaxFrontierSize() {
        return overallMaxFrontierSize;
    }

}
