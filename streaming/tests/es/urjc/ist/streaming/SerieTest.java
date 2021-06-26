package es.urjc.ist.streaming;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;

class SerieTest {

	@Test
	void testGetFirstReleaseDate() throws Exception {
		
		Episode e1 = new Episode("","",null,Locale.ENGLISH,Duration.ofMinutes(62),new ArrayList<>(),new ArrayList<>());
		Episode e2 = new Episode("","",null,Locale.ENGLISH,Duration.ofMinutes(62),new ArrayList<>(),new ArrayList<>());
		
		List<Episode> list = new ArrayList<Episode>();
		list.add(e1);
		list.add(e2);

		Season s1 = new Season("","",Locale.ENGLISH,list);
		List<Season> seasons = new ArrayList<Season>();
		seasons.add(s1);
		
		Serie se1 = new Serie("","",false,Locale.ENGLISH,seasons);
		assertEquals(se1.getFirstReleaseDate(),e1.getReleaseDate());
		
	}

	@Test
	void testGetLastReleaseDate() throws Exception {
		
		Episode e1 = new Episode("","",null,Locale.ENGLISH,Duration.ofMinutes(62),new ArrayList<>(),new ArrayList<>());
		Episode e2 = new Episode("","",null,Locale.ENGLISH,Duration.ofMinutes(62),new ArrayList<>(),new ArrayList<>());
		
		List<Episode> list = new ArrayList<Episode>();
		list.add(e1);
		list.add(e2);

		Season s1 = new Season("","",Locale.ENGLISH,list);
		List<Season> seasons = new ArrayList<Season>();
		seasons.add(s1);
		
		Serie se1 = new Serie("","",false,Locale.ENGLISH,seasons);
		assertEquals(se1.getLastReleaseDate(),e2.getReleaseDate());
	}

	@Test
	void testGetCast() throws Exception {

		Actor a1 = new Actor("actor1","","",null,0,0,false,new ArrayList<>(),null);
		List<Actor> cast = new ArrayList<Actor>();
		cast.add(a1);
		
		Episode e1 = new Episode("","",null,Locale.ENGLISH,Duration.ofMinutes(62),new ArrayList<>(),cast);
		Episode e2 = new Episode("","",null,Locale.ENGLISH,Duration.ofMinutes(62),new ArrayList<>(),new ArrayList<>());
	
		List<Episode> list = new ArrayList<Episode>();
		list.add(e1);
		list.add(e2);
		
		Season s1 = new Season("","",Locale.ENGLISH,list);
		List<Season> seasons = new ArrayList<Season>();
		seasons.add(s1);
		
		Serie se1 = new Serie("","",false,Locale.ENGLISH,seasons);
		System.out.println("uno: " + se1.getCast());
		System.out.println("dos: " + e1.getCast());
		assertEquals(se1.getCast(),e1.getCast());
		
	}

}
