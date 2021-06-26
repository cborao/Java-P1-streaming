package es.urjc.ist.streaming;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * <h1>Film class</h1>
 * <p> The film class models film objects <p>
 * @author César Borao Moratinos
 * @version 2.0
 */

public class Film {
	
	//We establish a constant to indicate the language which the program is intended to run
	private static final Locale LANGUAGE = Locale.ENGLISH;
		
	//We establish a constant to indicate the max number of production companies our list can storage
	private static final int MAX_PROD = 3;
	
	//We establish a constant to indicate the max number of directors our list can storage
	private static final int MAX_DIRECTORS = 3;
	
	//We establish a constant to indicate the max number of actors/actresses our list can storage
	private static final int MAX_CAST = 5;
	
	//We establish a constant to indicate the max number of labels our list can storage
	private static final int MAX_LABELS = 3;
	
	//We establish a constant to indicate the max and minimum number of rating we can give to a film
	private static final int MAX_RATE = 10;
	private static final int MIN_RATE = 0;
	
	//We establish a static variable to build an unique FilmId. 
	private static int count = 0;
	
	// Attributtes
	private int filmId;
	private String title;
	private String description;
	private boolean childContent;
	private LocalDate releaseDate;
	private Locale language;
	private Duration duration;
	
	private List<String> prodCompanies;
	private List<Director> directors;
	private List<Actor> cast;
	private int rating;
	private List<String> labels;
	
	// Default constructor
	public Film() {
		super();
		this.filmId = count;
		this.releaseDate = LocalDate.now();
		
		// The default language is English
		this.language = Locale.ENGLISH;
		this.duration = Duration.ofMinutes(60);
		
		// We create empty lists to avoid "null"
		this.prodCompanies = new ArrayList<String>();
		this.directors = new ArrayList<Director>();
		this.cast = new ArrayList<Actor>();
		this.labels = new ArrayList<String>();
		
		// Doing this, we ensure that the FilmId is unique for each film.
		count++;
	}

	/**
	 * Constructor with arguments. Note that the filmID set is automatic. Is not a parameter given in the initialization. 
	 * 
	 * @param title
	 * @param description
	 * @param childContent
	 * @param releaseDate
	 * @param language
	 * @param duration
	 * @param prodCompanies
	 * @param directors
	 * @param cast
	 * @param rating
	 * @param labels
	 */
	public Film(String title, String description, boolean childContent, LocalDate releaseDate,
			Locale language, Duration duration, List<String> prodCompanies, List<Director> directors, List<Actor> cast,
			int rating, List<String> labels) {
		
		this.filmId = count;
		count++;
		
		this.title = title;
		this.description = description;
		this.childContent = childContent;
		this.releaseDate = releaseDate;
		this.language = language;
		this.duration = duration;
		
		// To create a production companies list.
		// Note that passing more awards than the maximum of our list can storage is not considered
		// an error. Our program only storage the first three companies and ignore the others.
		if(prodCompanies == null) {
			this.prodCompanies = new ArrayList<String>();
		} else if(prodCompanies.size() <= MAX_PROD) {
			this.prodCompanies = prodCompanies;
		} else {
			this.prodCompanies = prodCompanies.subList(0, MAX_PROD);
		}
		
		// To create a directors list.
		// Note that passing more directors than the maximum of our list can storage is not considered
		// an error. Our program only storage the first three directors and ignore the others.
		if(directors == null) {
			this.directors = new ArrayList<Director>();
		} else if(directors.size() <= MAX_DIRECTORS) {
			this.directors = directors;
		} else {
			this.directors = directors.subList(0, MAX_DIRECTORS);
		}
		
		// To create a cast list.
		// Note that passing more actors/actresses than the maximum of our list can storage is not considered
		// an error. Our program only storage the first five actors/actresses and ignore the others.
		if(cast == null) {
			this.cast = new ArrayList<Actor>();
		} else if(cast.size() <= MAX_CAST) {
			this.cast = cast;
		} else {
			this.cast = cast.subList(0, MAX_CAST);
		}
	
		// Before initialize the rating, we check that is between the max and minimum ratings.
		
		if(rating < MIN_RATE) {
			System.err.println("Error: invalid rating value, assumed rating = 0");
			this.rating = 0;
		} else if (rating > MAX_RATE) {
			System.err.println("Error: invalid rating value, assumed rating = 10");
		} else {
			this.rating = 10;
		}
		
		// To create a cast list.
		// Note that passing more labels than the maximum of our list can storage is not considered
		// an error. Our program only storage the first five labels and ignore the others.
		if(labels == null) {
			this.labels = new ArrayList<String>();
		} else if(labels.size() <= MAX_LABELS) {
			this.labels = labels;
		} else {
			this.labels = labels.subList(0, MAX_LABELS);
		}
	}

	/**
	 * @return the filmId
	 */
	public int getFilmId() {
		return filmId;
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
	 * @return the prodCompanies
	 */
	public List<String> getProdCompanies() {
		return prodCompanies;
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
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @return the labels
	 */
	public List<String> getLabels() {
		return labels;
	}

	/** 
	 * @param filmId
	 * @param admin
	 */
	public void setFilmId(int filmId, Admin admin) {
		// Only admin with correct password can change the filmId
		if (admin.isVerified()) {
			System.out.println("Warning: Change the FilmId cannot ensure the FilmId uniqueness");
			this.filmId = filmId;
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
	 * @param childContent the childContent to set
	 */
	public void setChildContent(boolean childContent) {
		this.childContent = childContent;
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
	 * @param prodCompanies the prodCompanies to set
	 */
	public void setProdCompanies(List<String> prodCompanies) {
		
		// Note that passing more awards than the maximum of our list can storage is not considered
		// an error. Our program only storage the first three companies and ignore the others.
		try {
			if(prodCompanies == null) {
				this.prodCompanies = new ArrayList<String>();
			} else if(prodCompanies.size() <= MAX_PROD) {
				this.prodCompanies = prodCompanies;
			} else {
				this.prodCompanies = prodCompanies.subList(0, MAX_PROD);
			}
		}catch(Exception e){
			System.out.println("Error cannot set the production companies: ");
		}	
	}

	/** 
	 * @param directors the directors to set
	 */
	public void setDirectors(List<Director> directors) {
		
		// Note that passing more directors than the maximum of our list can storage is not considered
		// an error. Our program only storage the first three directors and ignore the others
		try {
			if(directors == null) {
				this.directors = new ArrayList<Director>();
			} else if(directors.size() <= MAX_DIRECTORS) {
				this.directors = directors;
			} else {
				this.directors = directors.subList(0, MAX_DIRECTORS);
			}
		}catch(Exception e){
			System.err.println("Error cannot set the production companies: " + e);
		}
	}

	/**
	 * @param cast the cast to set
	 */
	public void setCast(List<Actor> cast) {
		
		// Note that passing more actors/actresses than the maximum of our list can storage is not considered
		// an error. Our program only storage the first five actors/actresses and ignore the others.
		try {
			if(cast == null) {
				this.cast = new ArrayList<Actor>();
			} else if(cast.size() <= MAX_CAST) {
				this.cast = cast;
			} else {
				this.cast = cast.subList(0, MAX_CAST);
			}
		}catch(Exception e){
			System.err.println("Error cannot set the casting: " + e);
		}
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		
		// Before set the rating, we check that is between the max and minimum ratings.
		try {
			if(rating < MIN_RATE) {
				System.err.println("Error: invalid rating value, assumed rating = 0");
				this.rating = 0;
			} else if (rating > MAX_RATE) {
				System.err.println("Error: invalid rating value, assumed rating = 10");
			} else {
				this.rating = 10;
			}
		}catch(Exception e){
			System.err.println("Error cannot set the rating: " + e);
		}
	}

	/**
	 * @param labels the labels to set
	 */
	public void setLabels(List<String> labels) {
		
		// Note that passing more labels than the maximum of our list can storage is not considered
		// an error. Our program only storage the first five labels and ignore the others.
		try {
			if(labels == null) {
				this.labels = new ArrayList<String>();
			} else if(labels.size() <= MAX_LABELS) {
				this.labels = labels;
			} else {
				this.labels = labels.subList(0, MAX_LABELS);
			}
		}catch(Exception e){
			System.err.println("Error cannot set the rating: " + e);
		}
	}

	// toString method
	/**
	 * @return String describing the Film content
	 */
	@Override
	public String toString() {
		return "filmId=" + filmId + "\ntitle=" + title + "\ndescription=" + description + "\nchildContent="
				+ childContent + "\nreleaseDate=" + releaseDate + "\nlanguage=" + language.getDisplayLanguage(LANGUAGE) + "\nduration=" + duration.toMinutes() + " minutes"
				+ "\nprodCompanies=" + prodCompanies + "\ndirectors=" + directors + "\ncast=" + cast + "\nrating="
				+ rating + "\nlabels=" + labels;
	}

	// hashCode method
	/**
	 * Calculate the hashCode for this object
	 * 
	 * @return int the hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cast, childContent, description, directors, duration, filmId, labels, language,
							prodCompanies, rating, releaseDate, title);
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
		if (!(obj instanceof Film))
			return false;
		Film other = (Film) obj;
		return Objects.equals(cast, other.cast) && childContent == other.childContent
				&& Objects.equals(description, other.description) && Objects.equals(directors, other.directors)
				&& Objects.equals(duration, other.duration) && filmId == other.filmId
				&& Objects.equals(labels, other.labels) && Objects.equals(language, other.language)
				&& Objects.equals(prodCompanies, other.prodCompanies) && rating == other.rating
				&& Objects.equals(releaseDate, other.releaseDate) && Objects.equals(title, other.title);
	}
	
	// -------------------------------------
	// METHODS TO CREATE A FILM COLLECTION -
	//--------------------------------------
	
	/**
	 * Create a Film collection with the Film represented by "this" and an undefined number of films (represented by otherFilms) 
	 * 
	 * @param otherFilms
	 * @return
	 */
	public List<Film> newFilmCollection(Film... otherFilms) {
		List<Film> FilmsCollection = new ArrayList<Film>(Arrays.asList(otherFilms));
		FilmsCollection.add(0, this);
		return FilmsCollection;
	}
	
	/**
	 *  Create a Film collection with the Film represented by "this" and another Film Collection
	 *
	 * @param otherFilms
	 * @return
	 */
	public List<Film> newFilmCollection(List<Film> otherFilms) {
		otherFilms.add(this);
		return otherFilms;
	}
}
