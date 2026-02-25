package search;

public interface Action {
    int cost(Node parent, Node child); // c(n,a,n') here n is parent, n' is child
}
