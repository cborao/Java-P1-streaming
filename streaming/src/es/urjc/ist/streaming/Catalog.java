package es.urjc.ist.streaming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * <h1>Catalog class</h1>
 * <p> The catalog class models two list with films and series content. This class
 * provide the methods to manage this contents list, such ass add, remove and summarize methods
 * <p>
 * @author César Borao Moratinos
 * @version 2.0
 */

public class Catalog {
	
	// In a Catalog, we have a list with series and a list with films.
	private List<Film> films; 
	private List<Serie> series;
	
	// Default constructor: initialize with empty lists.
	public Catalog() {
		this.films = new ArrayList<Film>();
		this.series = new ArrayList<Serie>();
	}
	
	// Constructor with arguments
	public Catalog(List<Film> films, List<Serie> series) {
		this.films = films;
		this.series = series;
	}

	/**
	 * @return the films
	 */
	public List<Film> getFilms() {
		return films;
	}

	/**
	 * @return the series
	 */
	public List<Serie> getSeries() {
		return series;
	}
	
	/**
	 * @param films the films to set
	 */
	public void setFilms(List<Film> films) {
		this.films = films;
	}
	
	/**
	 * @param series the series to set
	 */
	public void setSeries(List<Serie> series) {
		this.series = series;
	}
	
	
	/**
	 * Add Film to the Catalog
	 * 
	 * @param newFilm
	 */
	public void addFilm(Film newFilm) {
		Iterator <Film> films = this.getFilms().iterator();
		while (films.hasNext()) {
			if (films.next().equals(newFilm)) {
				System.out.println("Error: cannot add '" + newFilm.getTitle() + "', this film is already in the catalog\n");
				return;
			}
		}
		this.getFilms().add(newFilm);
	}
	
	
	/**
	 * Add serie to the Catalog
	 * @param newSerie
	 */
	public void addSerie(Serie newSerie) {
		Iterator <Serie> series = this.getSeries().iterator();
		while (series.hasNext()) {
			if (series.next().equals(newSerie)) {
				System.out.println("Error: cannot add '" + newSerie.getTitle() + "', this serie is already in the catalog\n");
				return;
			}
		}
		this.getSeries().add(newSerie);
	}
		
	/**
	 * Add Collection of Films to the Catalog
	 * 
	 * @param filmCollection
	 */
	public void addFilmCollection(List<Film> filmCollection) {
		this.films.addAll(filmCollection);
			
		// To remove duplicates
		Set<Film> set = new HashSet<Film>(this.getFilms());
		this.getFilms().clear();
		this.getFilms().addAll(set);
	}
		

	/**
	 * Remove Film in the Catalog
	 * 
	 * @param film
	 */
	public void removeFilm(Film film) {
		Iterator <Film> films = this.getFilms().iterator();
		while (films.hasNext()) {
			if (films.next().equals(film)) {
				this.getFilms().remove(film);
				return;
			}
		}
		System.out.println("Error: cannot remove '" + film.getTitle() + "', this film is not in the catalog\n");
	}
	 
	/**
	 * Remove Collection of Films in the Catalog
	 * 
	 * @param filmCollection
	 */
	public void removeFilmCollection(List<Film> filmCollection) {
		try {
			this.films.removeAll(filmCollection);
		}catch(Exception e){
			System.err.println("Error cannot add Film collection: " + e);
		}
	}

	/**
	 * Remove Serie in the Catalog
	 * 
	 * @param serie
	 */
	public void removeSerie(Serie serie) {
		Iterator <Serie> series = this.getSeries().iterator();
		while (series.hasNext()) {
			if (series.next().equals(serie)) {
				this.getSeries().remove(serie);
				return;
			}
		}
		System.out.println("Error: cannot remove '" + serie.getTitle() + "', this serie is not in the catalog\n");
	}
	
	/**
	 * Remove all the Films in the Catalog
	 */
	public void removeAllFilms() {
		this.getFilms().clear();
	}
	
	/**
	 *  Remove all the Series in the Catalog
	 */
	
	public void removeAllSeries() {
		this.getSeries().clear();
	}
		
	/**
	 *  Remove all the Catalog content
	 */
	public void removeAllCatalog() {
		this.getFilms().clear();
		this.getSeries().clear();
	}
		
	//------------------
	// SUMMARY METHODS -
	//------------------
	
	/**
	 * Print a title summary of the Films and Series included in the catalog
	 */
	public void summarizeCatalog() {
		System.out.println("Films in Catalog:\n");
		for (int i=0; i < this.films.size(); i++) {
			System.out.println("  > " + films.get(i).getTitle());
		}
		System.out.println("\nSeries in Catalog:\n");
		for (int j=0; j < this.series.size(); j++) {
			System.out.println("  > " + series.get(j).getTitle());
		}
		System.out.println("\n");
	}
	
	/**
	 * Print a title summary of the Films included in the catalog
	 */
	public void summarizeFilmsCatalog() {
		System.out.println("Films in Catalog:\n");
		for (int i=0; i < this.films.size(); i++) {
			System.out.println("  > " + films.get(i).getTitle());
		}
		System.out.println("\n");
	}

	/**
	 * Print a title summary of the Series included in the catalog
	 */
	public void summarizeSeriesCatalog() {
		System.out.println("\nSeries in Catalog:\n");
		for (int j=0; j < this.series.size(); j++) {
			System.out.println("  > " + series.get(j).getTitle());
		}
		System.out.println("\n");
	}
	
	// toString method
	/**
	 * @return String describing the Artist content
	 */
	@Override
	public String toString() {
		return "Catalog [films=" + films + "\nseries=" + series + "]";
	}
	
	// hashCode method
	/**
	 * Calculate the hashCode for this object
	 * 
	 * @return int the hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(films, series);
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
		if (!(obj instanceof Catalog))
			return false;
		Catalog other = (Catalog) obj;
		return Objects.equals(films, other.films) && Objects.equals(series, other.series);
	}
}
