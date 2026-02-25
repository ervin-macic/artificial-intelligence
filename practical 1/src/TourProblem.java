

import search.GoalTest;
import search.Node;
import search.State;

public class TourProblem implements Problem {

    private final State initialState;
    private final GoalTest goalTest;

    public TourProblem(State initialState, GoalTest goalTest) {
        this.initialState = initialState;
        this.goalTest = goalTest;
    }

    public State getInitialState() {
        return initialState;
    }

    public GoalTest getGoalTest() {
        return goalTest;
    }

    public void printSolution(Node solution) {
        // new TourPrinting().printSolution(solution);
    }

    public String getName() {
        return "Romania Tour";
    }
}
