package es.urjc.ist.streaming;

import java.time.Duration;
import java.util.Objects;

/**
 * <h1>SerieData class</h1>
 * <p> This class represents a data structure with four fields: A series, the last season and the last episode played and the last minute played<p>
 * @author César Borao Moratinos
 * @version 2.0
 */

public class SerieData {

	private Serie serie;
	private Season lastSeason;
	private Episode lastEpisode;
	private Duration lastMinute;
	
	public SerieData() {
		super();
	}
	
	/**
	 * Contructor with arguments
	 * 
	 * @param serie
	 * @param lastSeason
	 * @param lastEpisode
	 * @param lastMinute
	 */
	public SerieData(Serie serie, Season lastSeason, Episode lastEpisode, Duration lastMinute) {
		this.serie = serie;
		this.lastSeason = lastSeason;
		this.lastEpisode = lastEpisode;
		this.lastMinute = lastMinute;
	}

	/**
	 * @return the serie
	 */
	public Serie getSerie() {
		return serie;
	}
	
	/**
	 * @return the lastSeason
	 */
	public Season getLastSeason() {
		return lastSeason;
	}
	
	/**
	 * @return the lastEpisode
	 */
	public Episode getLastEpisode() {
		return lastEpisode;
	}
	
	/**
	 * @return the lastMinute
	 */
	public Duration getLastMinute() {
		return lastMinute;
	}
	
	/**
	 * @param serie the serie to set
	 */
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	/**
	 * @param lastSeason the lastSeason to set
	 */
	public void setLastSeason(Season lastSeason) {
		this.lastSeason = lastSeason;
	}
	
	/**
	 * @param lastEpisode the lastEpisode to set
	 */
	public void setLastEpisode(Episode lastEpisode) {
		this.lastEpisode = lastEpisode;
	}
	
	/**
	 * @param lastMinute the lastMinute to set
	 */
	public void setLastMinute(Duration lastMinute) {
		this.lastMinute = lastMinute;
	}

	/**
	 * @return String describing the SerieData content
	 */
	@Override
	public String toString() {
		return "SerieData [serie=" + serie + ", lastSeason=" + lastSeason + ", lastEpisode=" + lastEpisode
				+ ", lastMinute=" + lastMinute + "]";
	}

	/**
	 * Calculate the hashCode for this object
	 * 
	 * @return int the hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lastEpisode, lastMinute, lastSeason, serie);
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
		if (!(obj instanceof SerieData))
			return false;
		SerieData other = (SerieData) obj;
		return Objects.equals(lastEpisode, other.lastEpisode) && Objects.equals(lastMinute, other.lastMinute)
				&& Objects.equals(lastSeason, other.lastSeason) && Objects.equals(serie, other.serie);
	}
}
