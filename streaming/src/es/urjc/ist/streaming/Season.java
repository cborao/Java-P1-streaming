package es.urjc.ist.streaming;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * <h1>Season class</h1>
 * <p> The season class models season objects that will be part of another serie class objects<p>
 * @author César Borao Moratinos
 * @version 2.0
 */

public class Season{
	
	//We establish a constant to indicate the language which the program is intended to run
	private static final Locale LANGUAGE = Locale.ENGLISH;
	
	private static final int MAX_CAST = 5;
	
	private String subtitle;
	private String description;
	private Locale language;

	private List<Actor> cast;
	private List<Episode> episodes;
	
	// This attributes will set automatically with the episodes values
	private LocalDate releaseDate;
	private Duration duration;
	
	// Default constructor
	public Season() {
		super();
		this.language = Locale.ENGLISH;
		
		// We create empty lists to avoid "null"
		this.cast = new ArrayList<Actor>();
		this.episodes = new ArrayList<Episode>();
	}

	/**
	 * Constructor with arguments
	 * 
	 * @param subtitle
	 * @param description
	 * @param language
	 * @param episodes
	 * @throws Exception
	 */
	
	public Season(String subtitle, String description, Locale language, List<Episode> episodes) throws Exception {
		
		// NOTE: The release date, the duration and the cast are not parameters given by the user.
		
		this.subtitle = subtitle;
		this.description = description;
		
		// Try to set the Season release Date
		try {
			this.releaseDate = episodes.get(0).getReleaseDate();
		} catch (Exception e) {
			throw new Exception("Error: cannot create season " + this.getSubtitle() + ", no episodes found");
		}
		
		this.language = language;
		
		// Get total of minutes in the season
		Duration total = Duration.ofMinutes(0);
		Iterator<Episode> it;
		it = episodes.iterator();
		while(it.hasNext()) {
			total = total.plus((it.next().getDuration()));
		}
		this.duration = total;
		
		// Try to set the Season cast
		try {
			this.cast = episodes.get(0).getCast();
		} catch (Exception e) {
			throw new Exception("Error: cannot create season " + this.getSubtitle() + ", no episodes found");
		}
		
		this.episodes = episodes;
	}
	
	/**
	 * @return the subtitle
	 */
	public String getSubtitle() {
		return subtitle;
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
	 * @return the cast
	 */
	public List<Actor> getCast() {
		return cast;
	}

	/**
	 * @return the episodes
	 */
	public List<Episode> getEpisodes() {
		return episodes;
	}

	// Setter methods
	/**
	 * @param subtitle the subtitle to set
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * set the release date of the season
	 * 
	 * @param releaseDate
	 * @param admin
	 */
	// Only admin with correct password can change the release date
	public void setReleaseDate(LocalDate releaseDate, Admin admin) {
		if (admin.isVerified()) {
			System.out.println("Warning: Change the release Date cannot ensure the coincidence with the release of the first episode");
			this.releaseDate = releaseDate;
		} else {
			System.out.println("Error: wrong admin password");
		}
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(Locale language) {
		this.language = language;
	}

	/**
	 * Set the duration
	 * 
	 * @param duration
	 * @param admin
	 */
	// Only admin with correct password can change the season duration
	public void setDuration(Duration duration, Admin admin) {
		if (admin.isVerified()) {
			System.out.println("Warning: Change the duration cannot ensure the coincidence with the duration of the season");
			this.duration = duration;
		} else {
			System.out.println("Error: wrong admin password");
		}
	}
	
	/**
	 * set the season cast
	 * 
	 * @param cast
	 * @param admin
	 */
	// Only admin with correct password can change the season cast
	public void setCast(List<Actor> cast, Admin admin) {
		if (admin.isVerified()) {
			System.out.println("Warning: Change the cast cannot ensure the coincidence with the cast of the first episode");
			if(cast == null) {
			} else if(cast.size() <= MAX_CAST) {
				this.cast = cast;
			} else {
				this.cast = cast.subList(0, MAX_CAST);
			}
		} else {
			System.out.println("Error: wrong admin password");
		}
	}

	/**
	 * @param episodes the episodes to set
	 */
	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
		
		// update the total duration
		Duration total = Duration.ofMinutes(0);
		Iterator<Episode> it;
		it = episodes.iterator();
		while(it.hasNext()) {
			total = total.plus((it.next().getDuration()));
		}
		this.duration = total;
		
		// update the release date
		try {
			this.releaseDate = episodes.get(0).getReleaseDate();
		} catch (Exception e) {
			System.out.print("error: The Season " + this.subtitle + "is empty");
		}
	}

	// toString method
	/**
	 * @return String describing the Season content
	 */
	@Override
	public String toString() {
		return "subtitle=" + subtitle + "\ndescription=" + description + "\nreleaseDate=" + releaseDate
				+ "\nlanguage=" + language.getDisplayLanguage(LANGUAGE) + "\nduration= " + duration.toMinutes() + " minutes" + "\ncast=" + cast + "\nepisodes=" + episodes;
	}

	// hashCode method
	/**
	 * Calculate the hashCode for this object
	 * 
	 * @return int the hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cast, description, duration, episodes, language, releaseDate, subtitle);
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
		if (!(obj instanceof Season))
			return false;
		Season other = (Season) obj;
		return Objects.equals(cast, other.cast) && Objects.equals(description, other.description)
				&& Objects.equals(duration, other.duration) && Objects.equals(episodes, other.episodes)
				&& Objects.equals(language, other.language) && Objects.equals(releaseDate, other.releaseDate)
				&& Objects.equals(subtitle, other.subtitle);
	}	
}
