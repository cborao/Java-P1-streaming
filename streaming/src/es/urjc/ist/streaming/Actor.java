package es.urjc.ist.streaming;

import java.time.LocalDate;
import java.util.List;

/**
 * <h1>Actor class</h1>
 * <p> The actor class inherits from artist class all attributes and functionality to model actors/actresses. <p>
 * @author César Borao Moratinos
 * @version 2.0
 */

public class Actor extends Artist {

	// Default constructor
	public Actor() {
		super();
	}
	
	// The Actor class offers four different constructors with parameters, depending on optional attributes such as deathRate and psudonym
	/**
	 * Constructor with all the attributes given
	 * 
	 * @param name
	 * @param surnames
	 * @param pseudonym
	 * @param birthDate
	 * @param numOfFilms
	 * @param numOfSeries
	 * @param active
	 * @param awards
	 * @param deathDate
	 */
	public Actor(String name, String surnames, String pseudonym, LocalDate birthDate, int numOfFilms, int numOfSeries,
			boolean active, List<String> awards, LocalDate deathDate) {
		
		super(name, surnames, pseudonym, birthDate, numOfFilms, numOfSeries, active, awards, deathDate);

	}
	
	/**
	 * Constructor with all the attributes given except the pseudonym: default = "None"
	 * 
	 * @param name
	 * @param surnames
	 * @param pseudonym
	 * @param birthDate
	 * @param numOfFilms
	 * @param numOfSeries
	 * @param active
	 * @param awards
	 */
	public Actor(String name, String surnames, String pseudonym, LocalDate birthDate, int numOfFilms, int numOfSeries,
			boolean active, List<String> awards) {
		
		super(name, surnames, pseudonym, birthDate, numOfFilms, numOfSeries, active, awards);

	}
	
	/**
	 * Constructor with all the attributes given except the pseudonym and the deathDate: default= "None", "null"
	 * 
	 * @param name
	 * @param surnames
	 * @param birthDate
	 * @param numOfFilms
	 * @param numOfSeries
	 * @param active
	 * @param awards
	 * @param deathDate
	 */
	public Actor(String name, String surnames, LocalDate birthDate, int numOfFilms, int numOfSeries,
			boolean active, List<String> awards, LocalDate deathDate) {
		
		super(name, surnames, birthDate, numOfFilms, numOfSeries, active, awards, deathDate);

	}
	
	/**
	 * Constructor with all the attributes given except the deathDate: default= "null"
	 * 
	 * @param name
	 * @param surnames
	 * @param birthDate
	 * @param numOfFilms
	 * @param numOfSeries
	 * @param active
	 * @param awards
	 */
	public Actor(String name, String surnames, LocalDate birthDate, int numOfFilms, int numOfSeries,
			boolean active, List<String> awards) {
		
		super(name, surnames, birthDate, numOfFilms, numOfSeries, active, awards);

	}
	
	/**
	 * @return String describing the Actor content
	 */
	@Override
	public String toString() {
		return "Actor/Actress " + super.toString();
	}

	/**
	 * Calculate the hashCode for this object
	 * 
	 * @return int the hashCode
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * Compares this object against the specified object
	 * 
	 * @param the other object to compare
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Actor))
			return false;
		return true;
	}	
}
