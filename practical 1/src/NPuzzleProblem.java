
import npuzzle.*;
import search.GoalTest;
import search.Node;
import search.State;

public class NPuzzleProblem implements Problem {

    private final State initialState;
    private final GoalTest goalTest;

    public NPuzzleProblem(State initialState) {
        this.initialState = initialState;
        this.goalTest = new TilesGoalTest();
    }

    public State getInitialState() {
        return initialState;
    }

    public GoalTest getGoalTest() {
        return goalTest;
    }

    public void printSolution(Node solution) {
        new NPuzzlePrinting().printSolution(solution);
    }

    public String getName() {
        return "N-Puzzle";
    }
}
