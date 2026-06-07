package tour;

import java.util.LinkedHashSet;
import java.util.Set;
import search.Node;
import search.NodeFunction;

public class TourHeuristicFunction implements NodeFunction {
    private final Cities allCities;
    private final City goalCity;
    public TourHeuristicFunction(Cities allCities, City goalCity) {
        this.allCities = allCities;
        this.goalCity = goalCity;
    }
    public float nodeFunction(Node n) {
        TourState state = (TourState) n.state;
        Set<City> allCitiesSet = allCities.getAllCities();
        City currentCity = state.currentCity;
        Set<City> visited = state.visitedCities;

        // unvisited set
        Set<City> unvisited = new LinkedHashSet<>(allCitiesSet);
        unvisited.removeAll(allCitiesSet);

        if (unvisited.isEmpty()) {
            return currentCity.getShortestDistanceTo(goalCity);
        }

        int maxDistance = 0;
        City furthestCity = null;

        // Find furthest unvisited city from current city
        for (City c : unvisited) {
            int dist = currentCity.getShortestDistanceTo(c);
            if (dist > maxDistance) {
                maxDistance = dist;
                furthestCity = c;
            }
        }
        int distanceToGoal = furthestCity.getShortestDistanceTo(goalCity);
        return maxDistance + distanceToGoal;
    }
}