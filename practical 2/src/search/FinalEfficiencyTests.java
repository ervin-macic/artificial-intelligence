package search;

import tour.*;
import npuzzle.*;

public class FinalEfficiencyTests {
    public static void main(String[] args) {
        Tiles npuzzleInitialConfiguration = new Tiles(new int[][]{
            {7, 4, 2},
            {8, 1, 3},
            {5, 0, 6}
        });
        GoalTest npuzzleGoalTest = new TilesGoalTest();

        Cities romania = SetUpRomania.getRomaniaMapSmall();
        romania.computeShortestDistances();
        City startCity = romania.getState("Bucharest");
        GoalTest tourGoalTest = new TourGoalTest(romania.getAllCities(), startCity);

        // n-puzzle A* GraphSearch
        BestFirstFrontier frontierNPGraph = new BestFirstFrontier(new AStarFunction(new MisplacedTilesHeuristicFunction()));
        Search searchNPGraph = new GraphSearch(frontierNPGraph);
        searchNPGraph.search(new Node(null, null, npuzzleInitialConfiguration), npuzzleGoalTest);
        System.out.println("n puzzle | A* GraphSearch | BestFirstFrontier");
        System.out.println("Number of nodes generated: " + searchNPGraph.getGeneratedNodeCount());
        System.out.println("Frontier max size: " + frontierNPGraph.getMaxFrontierSize());
        System.out.println();

        // n-puzzle A* TreeSearch
        BestFirstFrontier frontierNPTree = new BestFirstFrontier(new AStarFunction(new MisplacedTilesHeuristicFunction()));
        Search searchNPTree = new TreeSearch(frontierNPTree);
        searchNPTree.search(new Node(null, null, npuzzleInitialConfiguration), npuzzleGoalTest);
        System.out.println("n puzzle | A* TreeSearch | BestFirstFrontier");
        System.out.println("Number of nodes generated: " + searchNPTree.getGeneratedNodeCount());
        System.out.println("Frontier max size: " + frontierNPTree.getMaxFrontierSize());
        System.out.println();

        // tour A* GraphSearch
        BestFirstFrontier frontierTourGraph = new BestFirstFrontier(new AStarFunction(new TourHeuristicFunction(romania, startCity)));
        Search searchTourGraph = new GraphSearch(frontierTourGraph);
        searchTourGraph.search(new Node(null, null, new TourState(startCity)), tourGoalTest);
        System.out.println("tour | A* GraphSearch | BestFirstFrontier");
        System.out.println("Number of nodes generated: " + searchTourGraph.getGeneratedNodeCount());
        System.out.println("Frontier max size: " + frontierTourGraph.getMaxFrontierSize());
        System.out.println();
        
        // tour A* TreeSearch
        BestFirstFrontier frontierTourTree = new BestFirstFrontier(new AStarFunction(new TourHeuristicFunction(romania, startCity)));
        Search searchTourTree = new TreeSearch(frontierTourTree);
        searchTourTree.search(new Node(null, null, new TourState(startCity)), tourGoalTest);
        System.out.println("tour | A* TreeSearch | BestFirstFrontier");
        System.out.println("Number of nodes generated: " + searchTourTree.getGeneratedNodeCount());
        System.out.println("Frontier max size: " + frontierTourTree.getMaxFrontierSize());
        System.out.println();
    }
}