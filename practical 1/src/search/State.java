package search;

import java.util.Set;

public interface State {
	Set<? extends Action> getApplicableActions();
	State getActionResult(Action action);
	// doesn't java declare these for all Objects?
	boolean equals(Object that);
	int hashCode();
}
