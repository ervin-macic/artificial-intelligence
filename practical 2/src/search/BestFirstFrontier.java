package search;
import java.util.PriorityQueue;

public class BestFirstFrontier implements Frontier {
    protected NodeFunction f;
    protected PriorityQueue<Node> frontier;
    protected int maxFrontierSize;

    public BestFirstFrontier(NodeFunction f) {
        this.f = f;
        frontier = new PriorityQueue<Node>((n1, n2) -> Float.compare(n1.value, n2.value));
        maxFrontierSize = 0;
    }
    public void addNode(Node node) {
        node.value = this.f.f(node);
        frontier.add(node);
        maxFrontierSize = Math.max(maxFrontierSize, frontier.size());
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
