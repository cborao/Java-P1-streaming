package es.urjc.ist.streaming;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * <h1>Episode class</h1>
 * <p> The episode class models episode objects that will be part of another season class objects<p>
 * @author César Borao Moratinos
 * @version 2.0
 */

public class Episode {

	//We establish a constant to indicate the language which the program is intended to run
	private static final Locale LANGUAGE = Locale.ENGLISH;
	
	//We establish a constant to indicate the max number of directors our list can storage
	private static final int MAX_DIRECTORS = 3;
	
	//We establish a constant to indicate the max number of actors/actresses our list can storage
	private static final int MAX_CAST = 5;
	
	//We establish a static variable to build an unique episode ID. 
	private static int count = 0;
		
	// Attributes
	private int epId;
	private String title;
	private String description;
	private LocalDate releaseDate;
	private Locale language;
	private Duration duration;
	
	private List<Director> directors;
	private List<Actor> cast;
	
	// Default constructor
	public Episode() {
		super();
		this.epId = count;
		this.language = Locale.ENGLISH;
		this.duration = Duration.ofMinutes(60);
		this.releaseDate = LocalDate.now();
		count++;
		
		// We create empty lists to avoid "null"
		this.directors = new ArrayList<Director>();
		this.cast = new ArrayList<Actor>();
	}

	/**
	 * Constructor with arguments
	 * 
	 * @param title
	 * @param description
	 * @param releaseDate
	 * @param language
	 * @param duration
	 * @param directors
	 * @param cast
	 */
	public Episode(String title, String description, LocalDate releaseDate, Locale language, Duration duration,
					List<Director> directors, List<Actor> cast) {
		
		// Note that the filmID set is automatic. Is not a parameter given in the initialization. 
		this.epId = count;
		count++;
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		this.language = language;
		this.duration = duration;
		
		// directors list initialization
		if(directors == null) {
			this.directors = new ArrayList<Director>();
		} else if(directors.size() <= MAX_DIRECTORS) {
			this.directors = directors;
		} else {
			this.directors = directors.subList(0, MAX_DIRECTORS);
		}
		
		// cast list initialization
		if(cast == null) {
			this.cast = new ArrayList<Actor>();
		} if(cast.size() <= MAX_CAST) {
			this.cast = cast;
		} else {
			this.cast = cast.subList(0, MAX_CAST);
		}
	}

	/**
	 * @return the epId
	 */
	public int getEpId() {
		return epId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the releaseDate
	 */
	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @return the language
	 */
	public Locale getLanguage() {
		return language;
	}

	/**
	 * @return the duration
	 */
	public Duration getDuration() {
		return duration;
	}

	/**
	 * @return the directors
	 */
	public List<Director> getDirectors() {
		return directors;
	}

	/**
	 * @return the cast
	 */
	public List<Actor> getCast() {
		return cast;
	}

	/**
	 * set the Episode Id
	 * 
	 * @param epId
	 * @param admin
	 */
	// Only admin with correct password can change the EpisodeId
	public void setEpId(int epId, Admin admin) {
		if (admin.isVerified()) {
			System.out.println("Warning: Change the epId cannot ensure the epId uniqueness");
			this.epId = epId;
		} else {
			System.out.println("Error: wrong admin password");
		}
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(Locale language) {
		this.language = language;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	/**
	 * @param directors the directors to set
	 */
	public void setDirectors(List<Director> directors) {
		try {
			if(directors == null) {
				this.directors = new ArrayList<Director>();
			} else if(directors.size() <= MAX_DIRECTORS) {
				this.directors = directors;
			} else {
				this.directors = directors.subList(0, MAX_DIRECTORS);
			}
		}catch(Exception e){
			System.out.println("Error cannot set the production companies");
		}
	}

	/**
	 * @param cast the cast to set
	 */
	public void setCast(List<Actor> cast) {
		try {
			if(cast == null) {
				this.cast = new ArrayList<Actor>();
			} if(cast.size() <= MAX_CAST) {
				this.cast = cast;
			} else {
				this.cast = cast.subList(0, MAX_CAST);
			}
		}catch(Exception e){
			System.out.println("Error cannot set the casting");
		}
	}

	// toString method
	/**
	 * @return String describing the Episode content
	 */
	@Override
	public String toString() {
		return "\nepId=" + epId + "\ntitle=" + title + "\ndescription=" + description + "\nreleaseDate="
				+ releaseDate + "\nlanguage=" + language.getDisplayLanguage(LANGUAGE) + "\nduration= " + duration.toMinutes() + " minutes" + "\ndirectors=" + directors
				+ "\ncast=" + cast;
	}

	// hashCode method
	/**
	 * Calculate the hashCode for this object
	 * 
	 * @return int the hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cast, description, directors, duration, epId, language, releaseDate, title);
	}

	// equals method
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
		if (!(obj instanceof Episode))
			return false;
		Episode other = (Episode) obj;
		return Objects.equals(cast, other.cast) && Objects.equals(description, other.description)
				&& Objects.equals(directors, other.directors) && Objects.equals(duration, other.duration)
				&& epId == other.epId && Objects.equals(language, other.language)
				&& Objects.equals(releaseDate, other.releaseDate) && Objects.equals(title, other.title);
	}
}

