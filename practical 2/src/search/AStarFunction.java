package search;

public class AStarFunction implements NodeFunction {
    protected NodeFunction h;
    public AStarFunction(NodeFunction heuristicFunction) {
        this.h = heuristicFunction;
    }
    public float f(Node n) {
        return n.gValue + h.f(n);
    }
}
