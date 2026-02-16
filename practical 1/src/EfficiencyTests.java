
import tour.*;
import npuzzle.*;
import search.BreadthFirstFrontier;
import search.DepthFirstFrontier;
import search.Frontier;
import search.GoalTest;
import search.GraphSearch;
import search.Node;
import search.Problem;
import search.Search;
import search.TreeSearch;

public class EfficiencyTests {
    public static void main(String[] args) {

		// npuzzle setup
		Tiles npuzzleInitialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});

        // tour setup
        Cities romania = SetUpRomania.getRomaniaMapSmall();
		City startCity = romania.getState("Bucharest");
        GoalTest tourGoalTest = new TourGoalTest(romania.getAllCities(), startCity);

        // for each problem, for each frontier, for each search method: analyse efficiency
        Problem[] problems = {
            new TourProblem(new TourState(startCity), tourGoalTest),
            new NPuzzleProblem(npuzzleInitialConfiguration)
        };
        
        for (Problem problem : problems) {

            Frontier[] frontiers = {
                new DepthFirstFrontier(),
                new BreadthFirstFrontier()
            };

            for (Frontier frontier : frontiers) {

                Search[] searches = {
                    new TreeSearch(frontier),
                    new GraphSearch(frontier)
                };

                for (Search search : searches) {
                    Node result = search.search(new Node(null, null, problem.getInitialState()), problem.getGoalTest());
                    System.out.println(
                        problem.getName() + " | " +
                        search.getClass().getSimpleName() + " | " +
                        frontier.getClass().getSimpleName()
                    );

                    problem.printSolution(result);
                }
            }
        }
	}
}
