package tour;

import java.util.Objects;
import search.Action;
import search.Node; 

public class Road implements Action {
	public final City sourceCity;
	public final City targetCity;
	public final int length;
	
	public Road(City sourceCity, City targetCity, int length) {
		this.sourceCity = sourceCity;
		this.targetCity = targetCity;
		this.length = length;
	}
	public int cost(Node parent, Node child) {
		return length;
	}
	public boolean equals(Object that) {
		if (this == that) return true;
		if (that == null) return false;
		if (!(that instanceof Road)) return false;
		Road other = (Road) that;

		return sourceCity.equals(other.sourceCity) &&
			   targetCity.equals(other.targetCity) && 
			   length == other.length;
	}
	public int hashCode() {
		return Objects.hash(sourceCity, targetCity, length);
	}
}

