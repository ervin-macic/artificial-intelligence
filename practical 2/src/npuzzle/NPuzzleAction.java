package npuzzle;
import search.Action;
import search.Node;

public class NPuzzleAction implements Action {
    public int cost(Node n, Action a, Node n_prim) {
        return 1;
    }
}
