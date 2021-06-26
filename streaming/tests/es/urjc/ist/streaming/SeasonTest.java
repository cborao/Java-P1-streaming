package es.urjc.ist.streaming;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;

class SeasonTest {
	
	// Only tested methods that set Season class attributes automatically;
	@Test
	void testGetReleaseDate() throws Exception {
		
		Episode e1 = new Episode("","",null,Locale.ENGLISH,Duration.ofMinutes(62),new ArrayList<>(),new ArrayList<>());
		Episode e2 = new Episode("","",null,Locale.ENGLISH,Duration.ofMinutes(62),new ArrayList<>(),new ArrayList<>());
		Episode e3 = new Episode("","",null,Locale.ENGLISH,Duration.ofMinutes(62),new ArrayList<>(),new ArrayList<>());
		
		List<Episode> list = new ArrayList<Episode>();
		list.add(e1);
		list.add(e2);
		list.add(e3); 

		Season s1 = new Season("","",Locale.ENGLISH,list);
		assertEquals(s1.getReleaseDate(),e1.getReleaseDate());
	}

	@Test
	void testGetDuration() throws Exception {
		
		Episode e1 = new Episode("","",null,Locale.ENGLISH,Duration.ofMinutes(62),new ArrayList<>(),new ArrayList<>());
		Episode e2 = new Episode("","",null,Locale.ENGLISH,Duration.ofMinutes(62),new ArrayList<>(),new ArrayList<>());
		Episode e3 = new Episode("","",null,Locale.ENGLISH,Duration.ofMinutes(62),new ArrayList<>(),new ArrayList<>());
		
		List<Episode> list = new ArrayList<Episode>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		Season s1 = new Season("","",Locale.ENGLISH,list);
		assertEquals(s1.getDuration(),e1.getDuration().plus(e2.getDuration().plus(e3.getDuration())));
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
		assertEquals(s1.getCast(),e1.getCast());
	}

}
