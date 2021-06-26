package es.urjc.ist.streaming;

import java.time.Duration;
import java.util.Objects;

/**
 * <h1>FilmData class</h1>
 * <p> This class represents a data structure with two fields: A film and the last minute played<p>
 * @author César Borao Moratinos
 * @version 2.0
 */

public class FilmData {
	
	private Film film;
	private Duration lastMinute;
	
	// Default Constructor
	public FilmData() {
		super();
	}

	/**
	 * Constructor with arguments
	 * 
	 * @param film
	 * @param lastMinute
	 */
	public FilmData(Film film, Duration lastMinute) {
		this.film = film;
		this.lastMinute = lastMinute;
	}

	/**
	 * @return the film
	 */
	public Film getFilm() {
		return film;
	}

	/**
	 * @return the lastMinute
	 */
	public Duration getLastMinute() {
		return lastMinute;
	}

	/**
	 * @param film the film to set
	 */
	public void setFilm(Film film) {
		this.film = film;
	}

	/**
	 * @param lastMinute the lastMinute to set
	 */
	public void setLastMinute(Duration lastMinute) {
		this.lastMinute = lastMinute;
	}

	/**
	 * @return String describing the Artist content
	 */
	@Override
	public String toString() {
		return "FilmData [film=" + film + ", lastMinute=" + lastMinute + "]";
	}

	/**
	 * Calculate the hashCode for this object
	 * 
	 * @return int the hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(film, lastMinute);
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
		if (!(obj instanceof FilmData))
			return false;
		FilmData other = (FilmData) obj;
		return Objects.equals(film, other.film) && Objects.equals(lastMinute, other.lastMinute);
	}
}
