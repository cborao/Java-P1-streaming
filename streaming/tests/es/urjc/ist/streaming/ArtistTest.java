package es.urjc.ist.streaming;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ArtistTest {

	@Test
	void testGetName() {
		Artist a1 = new Artist();
		assertEquals(a1.getName(),null);
	}

	@Test
	void testSetName() {
		String name = "newName";
		Artist a1 = new Artist("name","","",null,0,0,false,new ArrayList<String>());
		a1.setName(name);
		assertEquals(a1.getName(),name);
	}

	@Test
	void testGetSurnames() {
		Artist a1 = new Artist();
		assertEquals(a1.getSurnames(),null);
	}

	@Test
	void testSetSurnames() {
		String surname = "newSurname";
		Artist a1 = new Artist("","","",null,0,0,false,new ArrayList<String>());
		a1.setSurnames(surname);
		assertEquals(a1.getSurnames(),surname);
	}

	@Test
	void testGetPseudonym() {
		Artist a1 = new Artist();
		assertEquals(a1.getPseudonym(),null);
	}

	@Test
	void testSetPseudonym() {
		String pseud = "newPseudonym";
		Artist a1 = new Artist("","","pseudonym",null,0,0,false,new ArrayList<String>());
		a1.setPseudonym(pseud);
		assertEquals(a1.getPseudonym(),pseud);
	}

	@Test
	void testGetBirthDate() {
		Artist a1 = new Artist("","",LocalDate.of(1985, 10, 29),0,0,false,new ArrayList<String>());
		assertTrue(a1.getBirthDate().compareTo(LocalDate.of(1985, 10, 29)) == 0);
	}

	@Test
	void testSetBirthDate() {
		LocalDate date = LocalDate.of(1995, 11, 24);
		
		Artist a1 = new Artist("","",LocalDate.of(1985, 10, 29),0,0,false,new ArrayList<String>());
		a1.setBirthDate(date);
		
		assertTrue(a1.getBirthDate().compareTo(LocalDate.of(1985, 10, 29)) != 0);
	}

	@Test
	void testGetNumOfFilms() {
		Artist a1 = new Artist();
		assertTrue(a1.getNumOfFilms() == 0);
	}

	@Test
	void testSetNumOfFilms() {
		int num = 10;
		Artist a1 = new Artist();
		a1.setNumOfFilms(num);
		assertTrue(a1.getNumOfFilms() == num);
	}

	@Test
	void testGetNumOfSeries() {
		Artist a1 = new Artist();
		assertTrue(a1.getNumOfSeries() == 0);
	}

	@Test
	void testSetNumOfSeries() {
		int num = 10;
		Artist a1 = new Artist();
		a1.setNumOfSeries(num);
		assertTrue(a1.getNumOfSeries() == num);
	}

	@Test
	void testIsActive() {
		Artist a1 = new Artist();
		assertTrue(!a1.isActive());
	}

	@Test
	void testSetActive() {
		Artist a1 = new Artist();
		a1.setActive(true);
		assertTrue(a1.isActive());
	}

	@Test
	void testGetDeathDate() {
		Artist a1 = new Artist("","",LocalDate.of(1985, 10, 29),0,0,false,new ArrayList<String>(), LocalDate.of(1999, 1, 9));
		assertTrue(a1.getDeathDate().compareTo(LocalDate.of(1999, 1, 9)) == 0);
	}

	@Test
	void testSetDeathDate() {
		LocalDate date = LocalDate.of(1995, 11, 24);
		
		Artist a1 = new Artist("","",LocalDate.of(1985, 10, 29),0,0,false,new ArrayList<String>(), LocalDate.of(1999, 1, 9));
		a1.setDeathDate(date);
		
		assertTrue(a1.getDeathDate().compareTo(LocalDate.of(1999, 1, 9)) != 0);
	}

	@Test
	void testGetAwards() {
		List<String> awards = new ArrayList<String>();
		awards.add("Oscar: Best Film");
		
		Artist a1 = new Artist("","",null,0,0,false,awards, LocalDate.of(1999, 1, 9));
		assertNotNull(a1.getAwards());
	}

	@Test
	void testSetAwards() {
		List<String> awards = new ArrayList<String>();
		awards.add("Oscar: Best Film");
		
		Artist a1 = new Artist();
		a1.setAwards(awards);
		assertNotNull(a1.getAwards());
	}

	@Test
	void testEquals() {
		Artist a1 = new Artist("Artist number 1","testing",LocalDate.of(1959, 6, 10),2,15,true,new ArrayList<String>());
		assertEquals(a1, a1);
	}
	
	@Test
	void testEquals2() {
		Artist a1 = new Artist("Artist number 1","testing",LocalDate.of(1959, 6, 10),2,15,true,new ArrayList<String>());
		Artist a2 = new Artist("Artist number 1","testing",LocalDate.of(1959, 6, 10),2,15,true,new ArrayList<String>());
		assertEquals(a1, a2);
	}


}
