package tour;
import search.Action;
import search.Node;

// import java.util.Set;

public class TourAction implements Action {
    public int cost(Node n, Action a, Node n_prim) {
        // should make sure that n_prim.state is in n.state.outgoingRoads
        // Set<Road> outgoingRoads = n.state.getApplicableActions();
        return 0;
    }
}
