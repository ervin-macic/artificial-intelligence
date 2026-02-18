package search;

import java.util.Queue;
import java.util.LinkedList;

import static java.lang.Math.max;

public class BreadthFirstFrontier implements Frontier{
    protected final Queue<Node> frontier;
    protected int maxFrontierSize;
    public BreadthFirstFrontier() {
        frontier = new LinkedList<>();
        maxFrontierSize = 0;
    }
    public void addNode(Node node) {
        frontier.add(node);
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
        return frontier.remove();
    }
    public int getMaxFrontierSize() {
        return maxFrontierSize;
    }
}
