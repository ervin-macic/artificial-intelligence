# Conclusions of experiments

## Java Heap Size issue

All combinations except TreeSearch with DepthFirstFrontier terminate.
This case we exceed Java heap space (throws exception `java.lang.OutOfMemoryError`)
This makes sense for the npuzzle considering that DFS with Tree search potentially does R -> L -> R -> L -> ... into infinity.
The state space in the npuzzle is cyclic considering that any action can be undone.

## Performance 

### IterativeDeepeningTreeSearch tiny max frontier size

IterativeDeepeningTreeSearch repeatedly does depth-limited DFS.
It generates a lot of nodes because it re-explores shallow nodes at each depth.
Max frontier size is tiny, only 25 (n puzzle) and 22 (tour).

### GraphSearch with DepthFirstFrontier
GraphSearch | DepthFirstFrontier worked surprisingly well compared to GraphSearch | BreadthFirstFrontier

### npuzzle

The exact size of the state space of the npuzzle is $\frac{9!}{2} = 181440$.

Interesting to compare these numbers to the number of nodes generated: 

        n puzzle | IterativeDeepeningTreeSearch | DepthFirstFrontier
        Number of nodes generated: 1211854
        Frontier max size: 25

        n puzzle | GraphSearch | BreadthFirstFrontier
        Number of nodes generated: 4579
        Frontier max size: 1698

        n puzzle | TreeSearch | BreadthFirstFrontier
        Number of nodes generated: 2298274
        Frontier max size: 1473871

A similar analysis can be done for the tour problem with $9!=362,880$ states
## Implementation remarks:

1. Wanted to abstract away the problems in a Problem interface and 
use polymorphism with all three: frontier, search, problem so that it is possible to run the experiments neatly. 
To this end, it was necessary to implement TourProblem and NPuzzleProblem which implement the Problem interface. The Problem interface would look like:

        package search;
        public interface Problem {
            State getInitialState();
            GoalTest getGoalTest();
            void printSolution(Node solution);
            String getName();
        }



2. IterativeDeepeningTreeSearch is implemented in a whonky way due to it breaking the Frontier interface rule.
I struggled for a bit to expose the getMaxFrontierSize getter outside of the class given that the frontier is
baked into the class itself.