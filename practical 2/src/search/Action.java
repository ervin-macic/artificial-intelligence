package search;

public interface Action {
    int cost(Node n, Action a, Node n_prim);
}
