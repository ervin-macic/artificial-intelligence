LEFT = "Left"
RIGHT = "Right"
SUCK = "Suck"
CLEAN = "clean"
DIRTY = "dirty"
class State:
    def __init__(self, position, cells):
        self.position = position
        self.cells = cells

    def __eq__(self, other):
        return (isinstance(other, State) and self.position == other.position and self.cells == other.cells)

    def __hash__(self):
        return hash((self.position, self.cells))


class Problem:
    seen = {}
    initial_state = None
    def __init__(self, initial_state: State):
        self.initial_state = initial_state

    def goal_test(self, state):
        return state.cells == (CLEAN, CLEAN)

    def actions(self, state):
        direction = LEFT if state.position == 'L' else RIGHT
        return [direction, SUCK]
    
    def results(self, state, action):
        if action == LEFT:
            return [State('L', state.cells)]
        elif action == RIGHT:
            return [State('R', state.cells)]
        elif action == SUCK:
            pos = state.position
            left, right = state.cells
            results = []

            if pos == 'L':
                if left == DIRTY:
                    results.append(State('L', (CLEAN, right)))
                    results.append(State('L', (CLEAN, CLEAN)))
                else:
                    results.append(State('L', (left, right)))
                    results.append(State('L', (DIRTY, right)))
            else:
                if right == DIRTY:
                    results.append(State('R', (left, CLEAN)))
                    results.append(State('R', (CLEAN, CLEAN)))
                else:
                    results.append(State('R', (left, right)))
                    results.append(State('R', (left, DIRTY)))

        return results
    
def and_or_graph_search(problem):
    cache = {}  # state -> plan or None (failure)
    return or_search(problem.initial_state, problem, set(), cache)

def or_search(state, problem, path, cache):
    if problem.goal_test(state):
        return []
    
    if state in path:
        return None
    
    if state in cache:
        return cache[state]
    
    new_path = path | {state}

    for action in problem.actions(state):
        result_states = problem.results(state, action)
        plan = and_search(result_states, problem, new_path, cache)

        if plan is not None:
            solution = [action, plan]
            cache[state] = solution
            return solution
        
    cache[state] = None
    return None


def and_search(states, problem, path, cache):
    plan = {}

    for s in states:
        subplan = or_search(s, problem, path, cache)

        if subplan is None:
            return None
        
        plan[s] = subplan
    return plan
init_state = State('L', (DIRTY, DIRTY))
problem = Problem(init_state)
