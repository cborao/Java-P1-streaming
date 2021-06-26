package es.urjc.ist.streaming;

import java.time.LocalDate;
import java.util.List;

/**
 * <h1>Director class</h1>
 * <p> The director class inherits from artist class all attributes and functionality to model directors. <p>
 * @author César Borao Moratinos
 * @version 2.0
 */

public class Director extends Artist {

	// Default constructor
	public Director() {
		super();
	}
	
	// The Director class offers four different constructors with parameters, depending on optional attributes such as deathRate and psudonym
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
	public Director(String name, String surnames, String pseudonym, LocalDate birthDate, int numOfFilms, int numOfSeries,
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
	public Director(String name, String surnames, String pseudonym, LocalDate birthDate, int numOfFilms, int numOfSeries,
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
	public Director(String name, String surnames, LocalDate birthDate, int numOfFilms, int numOfSeries,
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
	public Director(String name, String surnames, LocalDate birthDate, int numOfFilms, int numOfSeries,
			boolean active, List<String> awards) {
		
		super(name, surnames, birthDate, numOfFilms, numOfSeries, active, awards);

	}
	
	/**
	 * @return String describing the Director content
	 */
	@Override
	public String toString() {
		return "Director " + super.toString();
	}

	/** Calculate the hashCode for this object
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
		if (!(obj instanceof Director))
			return false;
		return true;
	}	
}
