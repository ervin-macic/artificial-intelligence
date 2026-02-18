package search;

public interface Search {
    Node search(Node root, GoalTest goalTest);
    int getGeneratedNodeCount();
}
