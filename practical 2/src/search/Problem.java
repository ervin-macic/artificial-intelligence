package search;
public interface Problem {
    State getInitialState();
    GoalTest getGoalTest();
    void printSolution(Node solution);
    String getName();
}
