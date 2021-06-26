package es.urjc.ist.streaming;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Serie {

	//We establish a constant to indicate the language which the program is intended to run
	private static final Locale LANGUAGE = Locale.ENGLISH;
	
	private static final int MAX_CAST = 5;
	
	private String title;
	private String description;
	private boolean childContent;
	private LocalDate firstReleaseDate;
	private LocalDate lastReleaseDate;
	private Locale language;
	
	private List<Actor> cast;
	private List<Season> seasons;
	
	public Serie() {
		super();
		this.language = Locale.ENGLISH;
		
		// We create empty lists to avoid "null"
		this.cast = new ArrayList<Actor>();
		this.seasons = new ArrayList<Season>();
	}

	/**
	 * Constructor with arguments
	 * 
	 * @param title
	 * @param description
	 * @param childContent
	 * @param language
	 * @param seasons
	 * @throws Exception
	 */
	public Serie(String title, String description, boolean childContent, Locale language, List<Season> seasons) throws Exception {
		
		this.title = title;
		this.description = description;
		this.childContent = childContent;
		
		// Get the first season release date and set as the release date of the series
		try {
			this.firstReleaseDate = seasons.get(0).getReleaseDate();
		} catch (Exception e) {
			throw new Exception("Error: cannot create " + this.getTitle() + " series" + ", no episodes found");
		}
		
		// Get the last episode release date nd set as the last release date of the series
		try {
			Season lastSeason = seasons.get(seasons.size()-1);
			this.lastReleaseDate = lastSeason.getEpisodes().get(lastSeason.getEpisodes().size()-1).getReleaseDate();
		} catch (Exception e) {
			throw new Exception("Error: cannot create " + this.getTitle() + " series" + ", no episodes found");
		}
		
		this.language = language;
		
		// Get the first season cast and set as the cast of the series
		try {
			this.cast = seasons.get(0).getCast();
		} catch (Exception e) {
			throw new Exception("Error: cannot create season " + this.getTitle() + ", no episodes found");
		}
		
		this.seasons = seasons;
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
	 * @return the childContent
	 */
	public boolean isChildContent() {
		return childContent;
	}

	/**
	 * @return the firstReleaseDate
	 */
	public LocalDate getFirstReleaseDate() {
		return firstReleaseDate;
	}

	/**
	 * @return the lastReleaseDate
	 */
	public LocalDate getLastReleaseDate() {
		return lastReleaseDate;
	}

	/**
	 * @return the language
	 */
	public Locale getLanguage() {
		return language;
	}

	/**
	 * @return the cast
	 */
	public List<Actor> getCast() {
		return cast;
	}

	/**
	 * @return the seasons
	 */
	public List<Season> getSeasons() {
		return seasons;
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
	 * @param childContent the childContent to set
	 */
	public void setChildContent(boolean childContent) {
		this.childContent = childContent;
	}
	
 	/**
 	 * set the first release date
 	 * 
 	 * @param firstReleaseDate
 	 */
	// Only admin with correct password can change the first release date
	public void setFirstReleaseDate(LocalDate firstReleaseDate, Admin admin) {
		if (admin.isVerified()) {
			System.out.println("Warning: Change the first release Date cannot ensure the coincidence with the release of the first season");
			this.firstReleaseDate = firstReleaseDate;
		} else {
			System.out.println("Error: wrong admin password");
		}
	}

	/**
	 * set the last release date
	 * 
	 * @param lastReleaseDate the lastReleaseDate to set
	 */
	// Only admin with correct password can change the last release date
	public void setLastReleaseDate(LocalDate lastReleaseDate, Admin admin) {
		if (admin.isVerified()) {
			System.out.println("Warning: Change the last release Date cannot ensure the coincidence with the release of the last episode");
			this.lastReleaseDate = lastReleaseDate;
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
	 * set the series cast
	 * 
	 * @param cast
	 * @param admin
	 */
	// Only admin with correct password can change the series cast
	public void setCast(List<Actor> cast, Admin admin) {
		if (admin.isVerified()) {
			System.out.println("Warning: Change the cast cannot ensure the coincidence with the cast of the first season");
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
	 * @param seasons the seasons to set
	 */
	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;

		// update the first release date
		try {
			this.firstReleaseDate = seasons.get(0).getReleaseDate();
		} catch (Exception e) {
			System.out.print("error: The Serie " + this.title + " is empty");
		}
		
		// update the first last release date
		try {
			Season lastSeason = seasons.get(seasons.size());
			this.lastReleaseDate = lastSeason.getEpisodes().get(lastSeason.getEpisodes().size()).getReleaseDate();
		} catch (Exception e) {
			System.out.print("error: cannot set the last release Date");
		}
	}

	@Override
	/**
	 * @return String describing the series content
	 */
	public String toString() {
		return "\ntitle=" + title + "\ndescription=" + description + "\nchildContent=" + childContent
				+ "\nfirstReleaseDate=" + firstReleaseDate + "\nlastReleaseDate=" + lastReleaseDate + "\nlanguage="
				+ language.getDisplayLanguage(LANGUAGE) + "\ncast=" + cast + "\nseasons=" + seasons;
	}

	/**
	 * Calculate the hashCode for this object
	 * 
	 * @return int the hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cast, childContent, description, firstReleaseDate, language, lastReleaseDate, seasons,
				title);
	}

	@Override
	/**
	 * Compares this object against the specified object
	 * 
	 * @param the other object to compare
	 * @return boolean
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Serie))
			return false;
		Serie other = (Serie) obj;
		return Objects.equals(cast, other.cast) && childContent == other.childContent
				&& Objects.equals(description, other.description)
				&& Objects.equals(firstReleaseDate, other.firstReleaseDate) && Objects.equals(language, other.language)
				&& Objects.equals(lastReleaseDate, other.lastReleaseDate) && Objects.equals(seasons, other.seasons)
				&& Objects.equals(title, other.title);
	}

}
