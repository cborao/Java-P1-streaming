package es.urjc.ist.streaming;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <h1>Playlist class</h1>
 * <p> The playlist class models objects that include a film list and a series list.
 * Additionally, this class stores data about the last minute played and other relevant information.
 * 
 * @version 2.0
 */

public class Playlist {

	private List<FilmData> films;
	private List<SerieData> series;
	
	// Default constructor
	public Playlist() {
		this.films = new ArrayList<FilmData>();
		this.series = new ArrayList<SerieData>();
	}

	/**
	 * Constructor with arguments
	 * 
	 * @param films
	 * @param series
	 */
	public Playlist(List<FilmData> films, List<SerieData> series) {
		this.films = films;
		this.series = series;
	}

	/**
	 * @return the films
	 */
	public List<FilmData> getFilms() {
		return films;
	}

	/**
	 * @param films the films to set
	 */
	public void setFilms(List<FilmData> films) {
		this.films = films;
	}

	/**
	 * @return the series
	 */
	public List<SerieData> getSeries() {
		return series;
	}

	/**
	 * @param series the series to set
	 */
	public void setSeries(List<SerieData> series) {
		this.series = series;
	}

	/**
	 * Calculate the hashCode for this object
	 * 
	 * @return int the hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(films, series);
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
		if (!(obj instanceof Playlist))
			return false;
		Playlist other = (Playlist) obj;
		return Objects.equals(films, other.films) && Objects.equals(series, other.series);
	}

	/**
	 * @return String describing the playlist content
	 */
	@Override
	public String toString() {
		return "Playlist [films=" + films + ", series=" + series + "]";
	}
}
