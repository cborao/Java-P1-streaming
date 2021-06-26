package es.urjc.ist.streaming;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * <h1>User class</h1>
 * <p> The user class models the people inside the FilmIN platforms as a role of consumer.
 * This class provide the methods to manage the user content depending on their age. of course, the user can add content to the playlist and 
 * access to the catalog.
 * <p>
 * @author César Borao Moratinos
 * @version 2.0
 */

public class User {
	
	private static final int MAX_AGE = 13;
	
	private String name;
	private String surnames;
	private LocalDate birthDate;
	private String dni;
	private Contract contract; 
	
	public enum Contract {
		NORMAL, SUPERIOR, PREMIUM
	}
	
	// Create a playlist for each user
	private Playlist playlist;
	
	// Storage a copy of the Catalog
	private Catalog catalog;
	
	// Default constructor
	public User() {
		super();
		this.playlist = new Playlist();
		this.catalog = new Catalog();
		this.contract = Contract.NORMAL;
	}

	/**
	 * Constructor with arguments
	 * 
	 * @param name
	 * @param surnames
	 * @param birthDate
	 * @param dni
	 * @param contract
	 * @param catalog
	 */
	public User(String name, String surnames, LocalDate birthDate, String dni, Contract contract, Catalog catalog) {
		this.name = name;
		this.surnames = surnames;
		this.birthDate = birthDate;
		this.dni = dni;
		
		// Validate the type of contract
		switch (contract) {
			case NORMAL:
				this.contract = Contract.NORMAL;
				break;
			case SUPERIOR:
				this.contract = Contract.SUPERIOR;
				break;
			case PREMIUM:
				this.contract = Contract.PREMIUM;
				break;
			default:
				System.out.println("error: Unknow type of contract, assumed normal contract");
				this.contract = Contract.NORMAL;
		}

		this.catalog = catalog;
		this.playlist = new Playlist();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
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
		return surnames;
	}

	/**
	 * @param surnames the surnames to set
	 */
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * @return the birthDate
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * set the user birth date
	 * @param birthDate the birthDate to set
	 */
	// Note: our program filter the content automatically to set if the user is adult or child depending on the user birthDate.
	// For this reason, only admin with correct password can change the user birthdate.
	public void setBirthDate(LocalDate birthDate, Admin admin) {
		if (admin.isVerified()) {
			System.out.println("Warning: Change the user birthDate could affect the type of content that the user can access");
			this.birthDate = birthDate;
		} else {
			System.out.println("Error: wrong admin password");
		}
	}


	/**
	 * @param catalog the catalog to set
	 */
	// Only admin with correct password can change the user catalog.
	public void setCatalog(Catalog catalog, Admin admin) {
		if (admin.isVerified()) {
			System.out.println("Warning: Change the user catalog could affect the content that the user can access");
			this.catalog = catalog;
		} else {
			System.out.println("Error: wrong admin password");
		}
	}

	/**
	 * @return the contract
	 */
	public Contract getContract() {
		return this.contract;
	}
	
	/**
	 * Set the type of contract
	 * @param contract
	 * @param admin
	 */
	// only admin with correct password can change the user contract
	public void setContract(Contract contract, Admin admin) {
		if (admin.isVerified()) {
			switch (contract) {
			case NORMAL:
				this.contract = Contract.NORMAL;
				break;
			case SUPERIOR:
				this.contract = Contract.SUPERIOR;
				break;
			case PREMIUM:
				this.contract = Contract.PREMIUM;
				break;
			default:
				System.out.println("error: Unknown type of contract, assumed normal contract");
				this.contract = Contract.NORMAL;
			}
		} else {
			System.out.println("Error: wrong admin password");
		}
	}
	
	/**
	 * @return the playlist
	 */
	public Playlist getPlaylist() {
		return this.playlist;
	}

	/**
	 * Calculate the hashCode for this object
	 * 
	 * @return int the hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(birthDate, catalog, contract, dni, name, playlist, surnames);
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
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		return Objects.equals(birthDate, other.birthDate) && Objects.equals(catalog, other.catalog)
				&& contract == other.contract && Objects.equals(dni, other.dni) && Objects.equals(name, other.name)
				&& Objects.equals(playlist, other.playlist) && Objects.equals(surnames, other.surnames);
	}

	/**
	 * @return String describing the User content
	 */
	@Override
	public String toString() {
		return "User [name=" + name + ", surnames=" + surnames + ", birthDate=" + birthDate + ", dni=" + dni
				+ ", contract=" + contract + ", playlist=" + playlist + ", catalog=" + catalog + "]";
	}

	/**
	 * Check if the user have access to this film or not according to the user age.
	 * 
	 * @param film the film to check if is child content
	 * @return if the user can access to the film or not
	 * 
	 */
	private boolean isAllowed(Film film) {
		
		LocalDate now = LocalDate.now();
		
		// if the user is an adult is allowed to all 
		if (now.compareTo(this.birthDate) >= MAX_AGE) return true;
		
		// if the user is a child is allowed if the film is childContent 
		if (film.isChildContent()) return true;
		
		// else, is not allowed
		return false;
	}
	
	/**
	 * Check if the user have access to this serie or not according to the user age.
	 * 
	 * @param serie the serie to check if is child content
	 * @return if the user can access to the series or not
	 * 
	 */
	private boolean isAllowed(Serie serie) {
		
		LocalDate now = LocalDate.now();
		
		// if the user is an adult is allowed to all 
		if (now.compareTo(this.birthDate) >= MAX_AGE) return true;
		
		// if the user is a child is allowed if the serie is childContent 
		if (serie.isChildContent()) return true;
		
		// else, is not allowed
		return false;
	}
	
	//---------------------------------------
	// 		METHODS TO ACCESS THE CATALOG -
	//
	//	The users ONLY can access the Catalog
	//	given in the initialization or given  
	//  by a "setCatalog" call in the main.
	//
	//----------------------------------------
	
	/**
	 * Print a title summary of the Films included in the catalog
	 */
	public void summarizeFilmsCatalog() {
		catalog.summarizeFilmsCatalog();
	}
	
	/**
	 * Print a title summary of the Series included in the catalog
	 */
	public void summarizeSeriesCatalog() {
		catalog.summarizeSeriesCatalog();
	}
	
	/**
	 * Print a title summary of the entire catalog
	 */
	public void summarizeCatalog() {
		catalog.summarizeFilmsCatalog();
		catalog.summarizeSeriesCatalog();
	}
	
	/**
	 * 
	 * @return the films included in the catalog
	 * 
	 */
	public List<Film> getFilmsCatalog() {
		return this.catalog.getFilms();
	}
	
	/**
	 * 
	 * @return the series included in the catalog
	 * 
	 */
	public List<Serie> getSeriesCatalog() {
		return this.catalog.getSeries();
	}
	
	/**
	 * 
	 * @return the entire catalog
	 * 
	 */
	public Catalog getCatalog() {
		return this.catalog;
	}
	
	//------------------------------------------------------------
	// METHODS TO ADD CONTENT TO THE PLAYLIST 
	//
	// We suppose that the user cannot access directly the Catalog
	// (we use iterators to go through the Catalog).The user only
	// can add the content included in the Catalog given in the
	// initialization or with a setCatalog method call in the main.
	// For example, the user cannot add to his playlist the content
	// of another Catalog.
	//
	//------------------------------------------------------------
	
	/**
	 * To add all the films included in Catalog to the user's playlist
	 * 
	 */
	// Note that the last minute played is 0.
	public void addFilmsToPlaylist() {
		Iterator<Film> catalogFilms = catalog.getFilms().iterator();
		while(catalogFilms.hasNext() ) {
			Film nextFilm = catalogFilms.next();
			if (this.isAllowed(nextFilm)) {
				this.playlist.getFilms().add(new FilmData(nextFilm, Duration.ofMinutes(0)));
			}
		}
	}
	
	/**
	 * To add all the the series included in Catalog to the user's playlist
	 */
	// Note that the last minute played is 0, store the first season and first episode.
	public void addSeriesToPlaylist() {
		
		Iterator<Serie> catalogSeries = catalog.getSeries().iterator();
		while(catalogSeries.hasNext()) {
			Serie nextSerie = catalogSeries.next();
			if (this.isAllowed(nextSerie)) {
				Season season = nextSerie.getSeasons().get(0);
				Episode episode = nextSerie.getSeasons().get(0).getEpisodes().get(0);
				Duration minute = Duration.ofMinutes(0);
				this.playlist.getSeries().add(new SerieData(nextSerie,season,episode,minute));
			}
		}
	}
	
	/**
	 * To add the entire Catalog to the user's playlist
	 */
	public void addCatalogToPlaylist() {
		
		Iterator<Film> catalogFilms = catalog.getFilms().iterator();
		Iterator<Serie> catalogSeries = catalog.getSeries().iterator();
		while(catalogFilms.hasNext()) {
			Film nextFilm = catalogFilms.next();
			if (this.isAllowed(nextFilm)) {
				this.playlist.getFilms().add(new FilmData(nextFilm, Duration.ofMinutes(0)));
			}
		}
		
		while(catalogSeries.hasNext()) {
			Serie nextSerie = catalogSeries.next();
			if (this.isAllowed(nextSerie)) {
				Season season = nextSerie.getSeasons().get(0);
				Episode episode = nextSerie.getSeasons().get(0).getEpisodes().get(0);
				Duration minute = Duration.ofMinutes(0);
				this.playlist.getSeries().add(new SerieData(nextSerie,season,episode,minute));
			}
		}
	}
	
	/**
	 * To add a specific Film included in Catalog to the user's playlist
	 * First, we try to find the Film inside the Catalog, if true, we check that the user 
	 * doesn't have this Film in the playlist. If he doesn't have, we add to the playlist
	 * 
	 * @param film
	 * @param lastMinute
	 */
	public void addFilmToPlaylist(Film film, Duration lastMinute) {
		
		// We look if the film is part of the Catalog
		Iterator<Film> catalogFilms = catalog.getFilms().iterator();
		while(catalogFilms.hasNext()) {
			Film nextFilm = catalogFilms.next();
			if (nextFilm.equals(film) && this.isAllowed(nextFilm)) {
				for (int i = 0; i < this.playlist.getFilms().size(); i++) {
					if (this.playlist.getFilms().get(i).getFilm().equals(film)) {
						System.out.println("Error: cannot add '" + film.getTitle() + "', this film is already in the playlist");
						return;
					} 
				}
				this.playlist.getFilms().add(new FilmData(film, lastMinute));
				return;
			} 
		}
		System.out.println("Error: cannot add '" + film.getTitle() + "' to the playlist, this film is not in the Catalog");
	}

	/**
	 * To add a specific series included in Catalog to the user's playlist
	 * First, we try to find the serie inside the Catalog, if true, we check that the user 
	 * doesn't have this serie in the playlist. If he doesn't have, we add to the playlist
	 * 
	 * @param serie
	 * @param lastSeason
	 * @param lastEp
	 * @param lastMin
	 */
	public void addSerieToPlaylist(Serie serie, Season lastSeason, Episode lastEp, Duration lastMin) {
		
		// We look if the film is part of the Catalog
		Iterator<Serie> catalogSeries = catalog.getSeries().iterator();
	
		while(catalogSeries.hasNext()) {
			Serie nextSerie = catalogSeries.next();
			if (nextSerie.equals(serie) && this.isAllowed(nextSerie)) {
				for (int i = 0; i < this.playlist.getSeries().size(); i++) {
					if (this.playlist.getSeries().get(i).getSerie().equals(serie)) {
						System.out.println("Error: cannot add '" + serie.getTitle() + "', this serie is already in the playlist");
						return;
					} 
				}
				this.playlist.getSeries().add(new SerieData(serie,lastSeason,lastEp,lastMin));
				return;
			} 
		}
		System.out.println("Error: cannot add '" + serie.getTitle() + " to the playlist', this serie is not in the Catalog");
	}
		
	
	/*
	 * To print a summary of the content titles included in the playlist
	 */
	public void summarizePlaylist() {
		System.out.println("Films in playlist:");
		if (this.playlist.getFilms().size() == 0) 
			System.out.println("   no films in playlist");
		
		for (int i=0; i < this.playlist.getFilms().size(); i++) {
			System.out.println("  > " + this.playlist.getFilms().get(i).getFilm().getTitle()
								+ ", last minute: " + this.playlist.getFilms().get(i).getLastMinute().toMinutes());
		}
		System.out.println("Series in playlist:");
		
		if (this.playlist.getSeries().size() == 0) 
			System.out.println("   no series in playlist");
		
	
		for (int i=0; i < this.playlist.getSeries().size(); i++) {
			System.out.println("  > " + this.playlist.getSeries().get(i).getSerie().getTitle()
								+ " --> Season: " + this.playlist.getSeries().get(i).getLastSeason() .getSubtitle()
								+ " --> Episode: " + this.playlist.getSeries().get(i).getLastEpisode().getTitle()
								+ ", last minute: " + this.playlist.getSeries().get(i).getLastMinute().toMinutes());
		}
		System.out.println("\n");
	}
	
	// Removing methods
	
	/**
	 * Remove all the playlist content
	 */
	public void clearPlaylist() {
		playlist.getFilms().clear();
		playlist.getSeries().clear();
	}
	
	/**
	 * Remove all the films included in the playlist
	 */
	public void removeFilmsInPlaylist() {
		playlist.getFilms().clear();
	}

	/**
	 * Remove all the series included in the playlist
	 */
	public void removeSeriesInPlaylist() {
		playlist.getSeries().clear();
	}
	
	/**
	 *To remove a specific Film. Fist we check that this film is in the playlist.
	 */
	public void removeFilmInPlaylist(Film film) {
		
		for (int i = 0; i < this.playlist.getFilms().size(); i++) {
			if (this.playlist.getFilms().get(i).getFilm().equals(film)) {
				playlist.getFilms().remove(i);
				return;
			}
		}
		System.out.println("Error: cannot remove '" + film.getTitle() + "', this film is not in the playlist");
	}
	
	/**
	 * To remove a specific Film. Fist we check that this film is in the playlist.
	 *
	 * @param serie
	 */
	public void removeSerieInPlaylist(Serie serie) {
			
		for (int i = 0; i < this.playlist.getSeries().size(); i++) {
			if (this.playlist.getSeries().get(i).getSerie().equals(serie)) {
				playlist.getSeries().remove(i);
				return;
			}
		}
		System.out.println("Error: cannot remove '" + serie.getTitle() + "', this serie is not in the playlist");
	}
}
