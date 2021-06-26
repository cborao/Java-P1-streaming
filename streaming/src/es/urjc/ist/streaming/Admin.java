package es.urjc.ist.streaming;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <h1>Admin class</h1>
 * <p> The admin class models superusers that are able to modify critical data or functionality in the other classes
 * included in the es.urjc.ist.streaming package.<p>
 * 
 * The methods of other classes that can access are:
 * <ul>
 * 	<li>setFilmId (Film class)
 *  <li>setEpId (Episode class)
 *  <li>setReleaseDate (Season class)
 *  <li>setDuration (Season class)
 *  <li>setCast (Season class)
 *  <li>SetFirstDate (Serie class)
 *  <li>SetLastDate (Serie class)
 *  <li>SetCast (Serie class)
 *  <li>SetContract (User class)
 *  <li>SetBirthDate (User class)
 *  <li>SetCatalog (User class)
 * </ul>
 * 
 * @author César Borao Moratinos
 * @version 2.0
 */

public class Admin {

	// Fixed and secret password to access the methods
	private static String passwordKey = "1234pass";
	private static List<String> adminActiveIds = new ArrayList<>();
	
	private String sessionId;
	private String password;
	
	/**
	 * Contructorwith arguments
	 * 
	 * @param sessionId
	 * @param password
	 */
	public Admin(String sessionId, String password) {
		this.sessionId = sessionId;
		adminActiveIds.add(sessionId);
		this.password = password;
	}
	
	/**
	 * @return if the admin is verified or not
	 */
	public boolean isVerified () {
		if (Admin.adminActiveIds.contains(sessionId) && this.password.equals(passwordKey))
			return true;
			
		return false;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Calculate the hashCode for this object
	 * 
	 * @return int the hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(password, sessionId);
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
		if (!(obj instanceof Admin))
			return false;
		Admin other = (Admin) obj;
		return Objects.equals(password, other.password) && Objects.equals(sessionId, other.sessionId);
	}

	/**
	 * @return String describing the Admin content
	 */
	@Override
	public String toString() {
		return "Admin [sessionId=" + sessionId + ", password=" + password + "]";
	}
	
}
