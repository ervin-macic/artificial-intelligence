import search.GoalTest;
import search.Node;
import search.State;

public interface Problem {
    State getInitialState();
    GoalTest getGoalTest();
    void printSolution(Node solution);
    String getName();
}
