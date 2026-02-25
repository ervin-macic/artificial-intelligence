package search;
import java.util.PriorityQueue;

public class BestFirstFrontier implements Frontier {
    protected NodeFunction f;
    protected PriorityQueue<Node> frontier;
    protected int maxFrontierSize;
    
    public BestFirstFrontier(NodeFunction nodeFunction) {
        this.f = nodeFunction;
        frontier = new PriorityQueue<Node>((n1, n2) -> Float.compare(n1.value, n2.value));
        maxFrontierSize = 0;
    }
    public void addNode(Node node) {
        node.value = this.f.nodeFunction(node);
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
        // probably should be .poll() to avoid exception
        return frontier.remove();
    }
    public int getMaxFrontierSize() {
        return maxFrontierSize;
    }
}
