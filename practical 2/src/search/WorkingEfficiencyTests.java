package search;
//import tour.*;
import npuzzle.*;

public class WorkingEfficiencyTests {
    public static void main(String[] args) {

		// npuzzle setup

		Tiles npuzzleInitialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});
        
        GoalTest npuzzleGoalTest = new TilesGoalTest();
		
        // tour setup
        /* 
        Cities romania = SetUpRomania.getRomaniaMapSmall();
		City startCity = romania.getState("Bucharest");
		
		GoalTest tourGoalTest = new TourGoalTest(romania.getAllCities(), startCity);
        */

        // *******************************************************************************
        //  {A*} X {GraphSearch, TreeSearch}
        // *******************************************************************************

        MisplacedTilesHeuristicFunction h = new MisplacedTilesHeuristicFunction();
        AStarFunction f = new AStarFunction(h);
        BestFirstFrontier frontier = new BestFirstFrontier(f);
        Search[] searches = {
            new GraphSearch(frontier),
            new TreeSearch(frontier),
        };

        for (Search search : searches) {

            // n puzzle analysis using frontier and search
            search.search(new Node(null, null, npuzzleInitialConfiguration), npuzzleGoalTest);
            System.out.println();
            System.out.println(
                "n puzzle" + " | A* " +
                search.getClass().getSimpleName() + " | " +
                frontier.getClass().getSimpleName()
            );
            System.out.println("Number of nodes generated: " + search.getGeneratedNodeCount());
            System.out.println("Frontier max size: " + frontier.getMaxFrontierSize());
            System.out.println();

            // new NPuzzlePrinting().printSolution(solution);
            
            // tour analysis using frontier and search 
            /* 
            solution = search.search(new Node(null, null, new TourState(startCity)), tourGoalTest);
            
            System.out.println();
            System.out.println(
                "tour" + " | " +
                search.getClass().getSimpleName() + " | " +
                frontier.getClass().getSimpleName()
            );
            System.out.println("Number of nodes generated: " + search.getGeneratedNodeCount());
            System.out.println("Frontier max size: " + frontier.getMaxFrontierSize());
            System.out.println(); 
            */
            // new TourPrinting().printSolution(solution);
        }
    }
	
}
