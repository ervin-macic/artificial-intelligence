package search;

public class IterativeDeepeningTreeSearch implements Search {

    protected int generatedNodeCount;
    protected int overallMaxFrontierSize;

    public IterativeDeepeningTreeSearch() {
        generatedNodeCount = 0;
    }

    public Node search(Node root, GoalTest goalTest) {

        generatedNodeCount = 0;
        overallMaxFrontierSize = 0;

        int limit = 0;

        while (true) {
            Frontier frontier = new DepthFirstFrontier();
            frontier.addNode(root);
            generatedNodeCount++;   // root generated so increment

            while (!frontier.isEmpty()) {
                Node leaf = frontier.removeNode();

                if (goalTest.isGoal(leaf.state)) {
                    overallMaxFrontierSize = Math.max(
                        overallMaxFrontierSize,
                        frontier.getMaxFrontierSize()
                    );
                    return leaf;
                }

                if (leaf.depth < limit) {
                    for (Action action : leaf.state.getApplicableActions()) {
                        State newState = leaf.state.getActionResult(action);
                        Node child = new Node(leaf, action, newState, leaf.depth + 1);
                        frontier.addNode(child);
                        generatedNodeCount += 1;
                    }
                }
            }

            overallMaxFrontierSize = Math.max(
                overallMaxFrontierSize,
                frontier.getMaxFrontierSize()
            );

            limit++;
        }
    }

    public int getGeneratedNodeCount() {
        return generatedNodeCount;
    }

    public int getMaxFrontierSize() {
        return overallMaxFrontierSize;
    }
}