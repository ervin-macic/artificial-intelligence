package tour;

import search.NodeFunction;
import search.Node; 

import java.util.Set;

public class TourHeuristicFunction implements NodeFunction{

    public float f(Node n) {
        TourState s = (TourState) n.state;
        City c = s.currentCity;
        Set<City> visitedCities = s.visitedCities;
        for ()
        // idea: run Dijkstra's algorithm and find c' most distant from c
        // then run another Dijkstra's to find 
        return 0;
    }
}
