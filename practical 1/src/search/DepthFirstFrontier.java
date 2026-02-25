package search;

import java.util.Stack;

import static java.lang.Math.max;

public class DepthFirstFrontier implements Frontier{
    protected final Stack<Node> frontier; // could use ArrayDeque
    protected int maxFrontierSize;
    public DepthFirstFrontier() {
        frontier = new Stack<>(); 
        maxFrontierSize = 0;
    }
    public void addNode(Node node) {
        frontier.push(node);
        // Update max frontier size if we reach an all-time high
        maxFrontierSize = max(maxFrontierSize, frontier.size());
    }
    public void clearFrontier() {
        frontier.clear();
        maxFrontierSize = 0;
    }
    public boolean isEmpty() {
        return frontier.isEmpty();
    }
    public Node removeNode() {
        return frontier.pop();
    }
    public int getMaxFrontierSize(){
        return maxFrontierSize;
    }
}
