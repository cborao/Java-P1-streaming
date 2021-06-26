package es.urjc.ist.streaming;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <h1>Artist class</h1>
 * <p> The artist class models people that are part of the world of cinema.
 * The difference between a generic people class and this class are the attributes related with this bussines,
 * such as the number of films or the number of series our artist has participated
 * <p>
 * @author César Borao Moratinos
 * @version 2.0
 */

public class Artist {
	
	// We establish a constant to indicate the max number of awards our list can storage
	private static final int MAX_AWARDS = 10;
	
	// The attributes of the Artist class
	private String name;
	private String surnames;
	private String pseudonym;
	private LocalDate birthDate;
	private int numOfFilms;
	private int numOfSeries;
	private boolean active;
	
	private List<String> awards;
	private LocalDate deathDate;
		
	
	/**
	 * Default constructor
	 */
	public Artist(){
		super();
		birthDate = LocalDate.now();
		awards = new ArrayList<String>();
	}

	// Constructor with arguments
	// We have implemented 4 different constructors to include 2 optional parameters: the pseudonym and the deathDate.
	
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
	public Artist(String name, String surnames, String pseudonym, LocalDate birthDate, int numOfFilms, int numOfSeries,
			boolean active, List<String> awards, LocalDate deathDate) {
		
		this.name = name;
		this.surnames = surnames;
		this.pseudonym = pseudonym;
		this.birthDate = birthDate;
		this.numOfFilms = numOfFilms;
		this.numOfSeries = numOfSeries;
		this.active = active;
		
		// To create an awards list.
		// Note that passing more awards than the maximum of our list can storage is not considered
		// an error. Our program only storage the first ten (MAX_AWARDS) awards and ignore the other.
		if(awards == null) {
			this.awards = new ArrayList<String>();
		} else if(awards.size() <= MAX_AWARDS) {
			this.awards = awards;
		} else {
			try {
				this.awards = awards.subList(0, MAX_AWARDS);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Error: create awards list failed");
			}
		}
		
		this.deathDate = deathDate;
	}

	/**
	 * Constructor with all the attributes given except the pseudonym: default = "None"
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
	public Artist(String name, String surnames, LocalDate birthDate, int numOfFilms, int numOfSeries,
			boolean active, List<String> awards, LocalDate deathDate) {
		
		this.name = name;
		this.surnames = surnames;
		this.pseudonym = "None";
		this.birthDate = birthDate;
		this.numOfFilms = numOfFilms;
		this.numOfSeries = numOfSeries;
		this.active = active;
		
		// To create an awards list.
		// Note that passing more awards than the maximum of our list can storage is not considered
		// an error. Our program only storage the first ten awards and ignore the others.
		if(awards == null) {
			this.awards = new ArrayList<String>();
		} else if(awards.size() <= MAX_AWARDS) {
			this.awards = awards;
		} else {
			try {
				this.awards = awards.subList(0, MAX_AWARDS);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Error: create awards list failed");
			}
		}
		
		this.deathDate = deathDate;
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
	 */
	public Artist(String name, String surnames, LocalDate birthDate, int numOfFilms, int numOfSeries,
			boolean active, List<String> awards) {
		
		this.name = name;
		this.surnames = surnames;
		this.pseudonym = "None";
		this.birthDate = birthDate;
		this.numOfFilms = numOfFilms;
		this.numOfSeries = numOfSeries;
		this.active = active;
		
		// To create an awards list.
		// Note that passing more awards than the maximum of our list can storage is not considered
		// an error. Our program only storage the first ten awards and ignore the others.
		if(awards == null) {
			this.awards = new ArrayList<String>();
		} else if(awards.size() <= MAX_AWARDS) {
			this.awards = awards;
		} else {
			try {
				this.awards = awards.subList(0, MAX_AWARDS);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Error: create awards list failed");
			}
		}
		
		this.deathDate = null;
	}
	
	/**
	 * Constructor with all the attributes given except the deathDate: default= "null"
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
	public Artist(String name, String surnames, String pseudonym, LocalDate birthDate, int numOfFilms, int numOfSeries,
			boolean active, List<String> awards) {
		
		this.name = name;
		this.surnames = surnames;
		this.pseudonym = pseudonym;
		this.birthDate = birthDate;
		this.numOfFilms = numOfFilms;
		this.numOfSeries = numOfSeries;
		this.active = active;
		
		// To create an awards list.
		// Note that passing more awards than the maximum of our list can storage is not considered
		// an error. Our program only storage the first ten awards and ignore the others.
		if(awards == null) {
			this.awards = new ArrayList<String>();
		} else if(awards.size() <= MAX_AWARDS) {
			this.awards = awards;
		} else {
			try {
				this.awards = awards.subList(0, MAX_AWARDS);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Error: create awards list failed");
			}
		}
		
		this.deathDate = null;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surnames
	 */
	public String getSurnames() {
		return this.surnames;
	}

	/**
	 * @param surnames the surnames to set
	 */
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	/**
	 * @return the pseudonym
	 */
	public String getPseudonym() {
		return this.pseudonym;
	}

	/**
	 * @param pseudonym the pseudonym to set
	 */
	public void setPseudonym(String pseudonym) {
		this.pseudonym = pseudonym;
	}

	/**
	 * @return the birthDate
	 */
	public LocalDate getBirthDate() {
		return this.birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the numOfFilms
	 */
	public int getNumOfFilms() {
		return this.numOfFilms;
	}

	/**
	 * @param numOfFilms the numOfFilms to set
	 */
	public void setNumOfFilms(int numOfFilms) {
		this.numOfFilms = numOfFilms;
	}

	/**
	 * @return the numOfSeries
	 */
	public int getNumOfSeries() {
		return this.numOfSeries;
	}

	/**
	 * @param numOfSeries the numOfSeries to set
	 */
	public void setNumOfSeries(int numOfSeries) {
		this.numOfSeries = numOfSeries;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return this.active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the deathDate
	 */
	public LocalDate getDeathDate() {
		return this.deathDate;
	}

	/**
	 * @param deathDate the deathDate to set
	 */
	public void setDeathDate(LocalDate deathDate) {
		this.deathDate = deathDate;
	}

	/**
	 * @return the awards
	 */
	public List<String> getAwards() {
		return this.awards;
	}

	/**
	 * @param awards the awards to set
	 */
	public void setAwards(List<String> awards) {
		
		// Note that passing more awards than the maximum of our list can storage is not considered
		// an error. Our program only storage the first ten awards and ignore the other.
		if(awards == null) {
			this.awards = new ArrayList<String>();
		} else if(awards.size() <= MAX_AWARDS) {
			this.awards = awards;
		} else {
			try {
				this.awards = awards.subList(0, MAX_AWARDS);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Error: set award list failed");
			}
		}
	}

	// toString method
	/**
	 * @return String describing the Artist content
	 */
	@Override
	public String toString() {
		return "Artist [name=" + name + ", surnames=" + surnames + ", pseudonym=" + pseudonym + ", birthDate="
				+ birthDate + ", numOfFilms=" + numOfFilms + ", numOfSeries=" + numOfSeries + ", active=" + active
				+ ", awards=" + awards + ", deathDate=" + deathDate + "]";
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
		if (!(obj instanceof Artist))
			return false;
		Artist other = (Artist) obj;
		return active == other.active && Objects.equals(awards, other.awards)
				&& Objects.equals(birthDate, other.birthDate) && Objects.equals(deathDate, other.deathDate)
				&& Objects.equals(name, other.name) && numOfFilms == other.numOfFilms
				&& numOfSeries == other.numOfSeries && Objects.equals(pseudonym, other.pseudonym)
				&& Objects.equals(surnames, other.surnames);
	}
	
	// hashCode method
	/**
	 * Calculate the hashCode for this object
	 * 
	 * @return int the hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(active, awards, birthDate, deathDate, name, numOfFilms, numOfSeries, pseudonym, surnames);
	}
}
