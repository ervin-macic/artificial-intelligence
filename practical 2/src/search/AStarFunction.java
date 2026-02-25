package search;

public class AStarFunction implements NodeFunction {
    protected NodeFunction herusFunction;
    public AStarFunction(NodeFunction heuristicFunction) {
        this.herusFunction = heuristicFunction;
    }
    public float nodeFunction(Node n) {
        return n.gValue + herusFunction.nodeFunction(n);
    }
}
