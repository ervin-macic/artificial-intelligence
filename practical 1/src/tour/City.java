package tour;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class City {
	protected final String name;
	protected final Set<Road> outgoingRoads;
	protected final Map<City,Integer> shortestDistanceByCity;

	public City(String name) {
		this.name = name;
		this.outgoingRoads = new LinkedHashSet<>();
		this.shortestDistanceByCity = new LinkedHashMap<>();
       	}
	public String getName() {
		return name;
	}
	public Set<Road> getOutgoingRoads() {
		return outgoingRoads;
	}
	public int getShortestDistanceTo(City city) {
		Integer distance = shortestDistanceByCity.get(city);
		if (distance == null)
			return Integer.MAX_VALUE;
		else
			return distance.intValue();
	}
	public boolean equals(Object that) {
		if (this == that) return true; // check reference equality, pointing to same variable in memory
		if (that == null) return false; 
		if (!(that instanceof City)) return false; // is "that" an object of type City (subclass of City)?
		// so here we know "that" is an object of class City so we're safe to cast
		City other = (City) that;
		
		return name.equals(other.name);
	}
	public int hashCode() {
		// this could be name.hashCode()? Or even String.hashCode(name)?
		return Objects.hash(name);
	}
}
