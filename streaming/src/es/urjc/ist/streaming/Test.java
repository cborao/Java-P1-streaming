package es.urjc.ist.streaming;

/**
 * <h1>Test class</h1>
 * 
 * This class is for test all the other classes. Some classes are not tested directly, they are
 * tested indirectly taking part of another class.
 * 
 * We will follow a specified order to test the classes:
 * 
 * <ol>
 * 	<li>Testing the DIRECTOR class</li>
 * 	<li>Testing the ACTOR class</li>
 * 	<li>Testing the FILM class</li>
 *  <li>Testing the EPISODE class</li>
 *  <li>Testing the SEASON class</li>
 *  <li>Testing the SERIE class</li>
 *  <li>Testing the CATALOG class</li>
 *  <li>Testing the USER and ADMIN classes</li>
 * </ol>
 * 
 * @author César Borao Moratinos
 * @version 2.0
 */

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import es.urjc.ist.streaming.User.Contract;

public class Test {

	//We establish a constant to indicate the language which the program is intended to run
	private static final Locale LANGUAGE = Locale.ENGLISH;
	
	
	public static void main(String[] args) throws Exception {
	
	///////////////////////////////////
	// 1. TESTING THE DIRECTOR CLASS //
	///////////////////////////////////
		
		System.out.println("TESTING DIRECTOR CLASS...\n");

	// 1.1. CREATING AWARD LIST FOR EACH DIRECTOR
		
		// 1.1.1. Create an awards list to director Martinez-Lazaro
		
		List<String> mlAwards = new ArrayList<String>();
		mlAwards.add("Oso de Oro: Berninale");
		mlAwards.add("Biznaga de Oro");
		
		// 1.1.2. Create an awards list to director Steven Spielberg
		
		List<String> sbAwards = new ArrayList<String>();
		sbAwards.add("Oscar (Best Film): The Schindler's List");
		sbAwards.add("Oscar (Best Director): The Schindler's List");
		sbAwards.add("Oscar (Best Picture): The Schindler's List");
		sbAwards.add("Oscar (In memory of Irving Thalverg)");
		sbAwards.add("Oscar (Best Director): Saving private Ryan");
		sbAwards.add("Golden Globes (Best Motion Picture): E.T.the Extra-Terrestrial");
		sbAwards.add("BAFTA (Honorific Bafta)");
		sbAwards.add("Golden Globes (Best Director): Saving private Ryan");
		sbAwards.add("Golden Globes (Best Director): The Schindler's List");
		sbAwards.add("Emmy (Outstanding Miniseries): The Pacific");
		sbAwards.add("Invented award that does not appear in the awards list");
		
		// 1.1.3. Create an awards list to director George Lucas
		
		List<String> glAwards = new ArrayList<String>();
		glAwards.add("Evening Standard British Film Award (Best Film): Star Wars");
		glAwards.add("Saturn Award (Best Director): Star Wars");
		glAwards.add("Saturn Award (Best Writing): Star Wars");
		glAwards.add("Hugo Award (Best Dramatic Presentation): Return of the Jedi");
		glAwards.add("Hugo Award (Best Dramatic Presentation): Raiders of the Lost Ark");
		glAwards.add("Hugo Award (Best Dramatic Presentation): Indiana Jones and the Last Crusade");
		glAwards.add("Empire Award (Best Sci-Fi/Fantasy): Star Wars Episode III: Revenge of the Sith");
		
		
	//------------------------------
	// 1.2. CREATING THE DIRECTORS -
	//------------------------------
		
		Director vanPatten = new Director("Timothy","Van Patten","Tim Van Patten",LocalDate.of(1959, 6, 10),2,15,true,new ArrayList<String>());
		Director martinezLazaro = new Director("Emilio","Martínez-Lázaro",LocalDate.of(1945, 11, 30),17,1,true,mlAwards);
		Director lucasGeorge = new Director("George Walton","Lucas Jr","George Lucas",LocalDate.of(1944, 5, 14),41,5,true,glAwards);
		Director kershnerIrvin = new Director("Isadore","Kershner","Irvir Kershner",LocalDate.of(1923, 4, 29),19,1,false,new ArrayList<String>(),LocalDate.of(2010, 11, 27));
		Director spielberg = new Director("Steven Allan","Spielberg","Steven spielberg",LocalDate.of(1946, 12, 18),130,24,true,sbAwards);
		Director spielbergCopy = new Director("Steven Allan","Spielberg","Steven spielberg",LocalDate.of(1946, 12, 18),130,24,true,sbAwards);
		Director kirkBrian = new Director("Brian","Kirk",LocalDate.of(1968,1,31),2,13,true,new ArrayList<String>());
		Director taylorAlan = new Director("Alan","Taylor",LocalDate.of(1959,1,13),6,22,true,new ArrayList<String>());
		
		
	// 1.3. TESTING GET METHODS
		
		System.out.println("Testing GET methods: ");
		System.out.println("> " + "Martinez Lazaro number of films: " + martinezLazaro.getNumOfFilms());
		System.out.println("> " + "Van Patten birth date: " + vanPatten.getBirthDate());
		System.out.println("> " + "Spielberg awards: " + spielberg.getAwards());
		
	// 1.4. TESTING SET METHODS
		
		System.out.println("\nTesting SET methods: ");
		spielberg.setName("Pepe");
		spielberg.setBirthDate(LocalDate.now());
		
		System.out.println("> " + "spielberg new name: " + spielberg.getName());
		System.out.println("> " + "spielberg new birth date: " + spielberg.getBirthDate());
		
		spielberg.setName("Steven Allan");
		spielberg.setBirthDate(LocalDate.of(1946, 12, 18));
		
	// 1.5. TESTING EQUALS METHOD
		
		System.out.println("\nTesting EQUALS method: ");
		System.out.println("> " + "Spielberg equals to Spielberg copy?: " + spielberg.equals(spielbergCopy));
		System.out.println("> " + "Spielberg equals to Martinez-Lazaro?: " + spielberg.equals(martinezLazaro));
	
	// 1.5. TESTING TOSTRING METHOD
		System.out.println("\nTesting TOSTRING method: ");
		System.out.println("> " + taylorAlan.toString());
		
		
	///////////////////////////////
	// 2.TESTING THE ACTOR CLASS //
	//////////////////////////////
		
		System.out.println("\n\nTESTING ACTOR CLASS...\n");
		
	// 2.1. CREATING AWARDS LIST FOR EACH ACTOR/ACTRESS
		
		// 2.1.1. Create an awards list to actress Carrie Fisher
		
		List<String> cfAwards = new ArrayList<String>();
		cfAwards.add("Saturn (President's award)");
		cfAwards.add("Grammy Awards (Best Spoken Word Album): The Princess Diarist");
		cfAwards.add("Teen Choice Awards (Choice Fantasy Actress): Star Wars: The last jedi");
		
		// 2.1.2. Create an awards list to actor Daniel Rovira
		
		List<String> drAwards = new ArrayList<String>();
		drAwards.add("Goya awards (Best new Actor): Ocho apellidos vascos");
		drAwards.add("Cinematographer Circle Medals (Best new Actor): Ocho apellidos vascos");

	//-------------------------------------
	// 2.2. CREATING THE ACTORS/ACTRESSES -
	//-------------------------------------
		
		Actor fisherCarrie = new Actor("Carrie Frances","Fisher","Carrie Fisher",LocalDate.of(1956, 12, 21),39,14,false,cfAwards,LocalDate.of(2016, 12, 27));
		Actor turnerSophie = new Actor("Sophie","Turner",null,LocalDate.of(1996,2,21),11,3,true,new ArrayList<String>());
		Actor haringtonKit = new Actor("Christopher Catesby","Harington","Kit Harington",LocalDate.of(1986,12,26),13,2,true,new ArrayList<String>());
		Actor roviraDani = new Actor("Daniel","Rovira",LocalDate.of(1980,11,1),17,1,true,drAwards,null);
		Actor mcGregor = new Actor("Ewan Gordon","McGregor","Ewan McGregor",LocalDate.of(1971,3,31),63,4,true,new ArrayList<String>());
		
	// 2.3. TESTING GET METHODS
		
		System.out.println("Testing GET methods: ");
		System.out.println("> " + "Carrie Fisher death date: " + fisherCarrie.getDeathDate());
		System.out.println("> " + "Daniel Rovira awards: " + roviraDani.getAwards());
		System.out.println("> " + "Sophie Turner birth date: " + turnerSophie.getBirthDate());
		
	// 2.4. TESTING SET METHODS
		
		System.out.println("\nTesting SET methods: ");
		
		haringtonKit.setName("Jon");
		haringtonKit.setSurnames("Snow");
		fisherCarrie.setBirthDate(LocalDate.now());
		
		System.out.println("> " + "Kit Harington new name: " + haringtonKit.getName());
		System.out.println("> " + "Kit Harington new surname: " + haringtonKit.getSurnames());
		System.out.println("> " + "Carrie Fisher new birth date: " + fisherCarrie.getBirthDate());
		
		haringtonKit.setName("Christopher Catesby");
		haringtonKit.setSurnames("Harington");
		fisherCarrie.setBirthDate(LocalDate.of(1956, 12, 21));
		
	// 2.5. TESTING EQUALS METHOD
		
		System.out.println("\nTesting EQUALS method: ");
		
		System.out.println("> " + "Is Dani Rovira equals to Kit Harington?: " + roviraDani.equals(haringtonKit));
		System.out.println("> " + "Is Sophie Turner equals to Sophie Turner?: " + turnerSophie.equals(turnerSophie));
		
	// 2.6. TESTING TOSTRGING METHOD
		
		System.out.println("> " + fisherCarrie.toString());
				
		
	//////////////////////////
	// 3.TESTING FILM CLASS //
	/////////////////////////
		
		System.out.println("\n\nTESTING FILM CLASS...\n");
		
	// 3.1. CREATING PRODUCTION COMPANIES LIST
		
		// 3.1.1. Creating the list of production companies for Star Wars Episodes 2, 4 and 5
		
		List<String> swProd = new ArrayList<String>();
		swProd.add("Lucasfilm Ltd");
		swProd.add("20th Century Fox");
		
		// 3.1.2. Creating the list of production companies for Ocho apellidos vascos
		
		List<String> vascosProd = new ArrayList<String>();
		vascosProd.add("Lazonafilms");
		vascosProd.add("Kowalski Films");
		vascosProd.add("Telecinco Cinema");
		
		// 3.1.3. Creating the list of production companies for Ocho apellidos vascos
		
		List<String> catalanProd = vascosProd;
				
	// 3.2. CREATING DIRECTORS LIST
		
		// 3.2.1. Creating directors list for Star Wars Episode 4 and Episode 2
		
		List<Director> swDirectorsEp4 = new ArrayList<Director>();
		swDirectorsEp4.add(lucasGeorge);
		
		// 3.2.2. Creating directors list for Star Wars Episode 5
		
		List<Director> swDirectorsEp5 = new ArrayList<Director>();
		swDirectorsEp5.add(kershnerIrvin);
		swDirectorsEp5.add(lucasGeorge);
		
		// 3.2.3. Creating directors list for Ocho apellidos vascos
		
		List<Director> vascosDirectors = new ArrayList<Director>();
		vascosDirectors.add(martinezLazaro);
		
		// 3.2.4. Creating directors list for Ocho apellidos catalanes
		
		List<Director> catalanDirectors = vascosDirectors;
		
	// 3.3. CREATING CAST LIST
		
		// 3.3.1. Creating cast list for Star Wars Episode 4 and Episode 5
		
		List<Actor> swCast = new ArrayList<Actor>();
		swCast.add(fisherCarrie);

		// 3.3.2. Creating cast list for Star Wars Episode 2
		
		List<Actor> swCastEp2 = new ArrayList<Actor>();
		swCastEp2.add(mcGregor);
		
		// 3.3.3. Creating cast list for Ocho apellidos vascos
		
		List<Actor> vascosCast = new ArrayList<Actor>();
		vascosCast.add(roviraDani);
		
		// 3.3.4. Creating cast list for Ocho apellidos catalanes
		
		List<Actor> catalanCast = vascosCast;
	
		
	// 3.4. CREATING LABELS LIST
		
		// 3.4.1. Creating labels list for Star Wars Episodes 2, 4 and 5
		
		List<String> swLabels = new ArrayList<String>();
		swLabels.add("Sci-fi");
		swLabels.add("Star Wars");
		swLabels.add("Luke Skywalker");
		swLabels.add("Space");
		swLabels.add("Death Star");
		swLabels.add("X-Wing");
		
		// 3.4.2. Creating labels list for Ocho apellidos vascos
		
		List<String> vascosLabels = new ArrayList<String>();
		vascosLabels.add("Euskadi");
		vascosLabels.add("Sevilla");
		vascosLabels.add("Comedy");
		vascosLabels.add("Rovira");
		vascosLabels.add("Spanish");
		
		// 3.4.3. Creating labels list for Ocho apellidos catalanes
		
		List<String> catalanLabels = new ArrayList<String>();
		vascosLabels.add("Catalonia");
		vascosLabels.add("Spanish");
		vascosLabels.add("Comedy");
		
		
	//--------------------------
	// 3.5. CREATING THE FILMS -
	//--------------------------
		
		// 3.5.1. Creating the Star Wars Episode IV: A new Hope, film
		
		Film swEp4 = new Film("Star Wars: Episode IV A New Hope","It is a period of civil war. Rebel spaceships, striking from a hidden base, have won their first victory against the evil Galactic Empire. During the battle, Rebel spies managed to steal secret plans to the Empire's ultimate weapon, the DEATH STAR, an armored space station with enough power to destroy an entire planet."
							,true,LocalDate.of(1977, 5, 25),Locale.ENGLISH,Duration.ofMinutes(121),swProd,swDirectorsEp4,swCast,10,swLabels);
		
		// 3.5.2. Creating the Star Wars Episode V: The Empire Strikes Back film
		
		Film swEp5 = new Film("Star Wars: Episode V The Empire Strikes Back","After destroying the Death Star, the Rebel Alliance is forced to hole up on the freezing planet of Hoth while the Empire desperately tries to locate their secret base. In fact, the movie starts off with an Imperial probe crash-landing onto Hoth's surface."
							,true,LocalDate.of(1980, 5, 21),Locale.ENGLISH,Duration.ofMinutes(124),swProd,swDirectorsEp5,swCast,8,swLabels);
		
		// 3.5.3. Creating the Star Wars Episode II: Attack of the Clones, film
		
		Film swEp2 = new Film("Star Wars: Episode II Attack of the Clones","A large battle erupts between the Republic's clone forces and the Separatists' droid army. Count Dooku attempts to escape, but Obi-Wan and Anakin track him to a secret hangar, where they engage him in combat. Dooku quickly injures Obi-Wan and cuts off Anakin's right arm."
							,true,LocalDate.of(2002, 5, 16),Locale.ENGLISH,Duration.ofMinutes(142),swProd,swDirectorsEp4,swCastEp2,8,swLabels);
		
		// 3.5.4. Creating Ocho apellidos vascos film
		
		Film vascos = new Film("Ocho Apellidos Vascos","Ocho apellidos vascos narra la historia de Rafa, es un señorito andaluz que no ha tenido que salir jamás de Sevilla para conseguir lo único que le importa en la vida: el fino, la gomina y las mujeres. Hasta que un día todo cambia cuando aparece la primera mujer que se resiste a sus encantos: Amaia, una vasca."
							,false,LocalDate.of(2014, 3, 14),new Locale("es"),Duration.ofMinutes(98),vascosProd,vascosDirectors,vascosCast,9,vascosLabels);
	
		// 3.5.4. Creating Ocho apellidos catalanes film
		
		Film catalan = new Film("Ocho Apellidos Catalanes","Ocho apellidos catalanes es la secuela de la exitosa comedia Ocho apellidos vascos, una divertida historia de amor que lleva a un andaluz hasta Euskadi tras la pista de una chica a la que ha conocido en una noche loca en Sevilla."
							,false,LocalDate.of(2015, 11, 18),new Locale("es"),Duration.ofMinutes(99),catalanProd,catalanDirectors,catalanCast,6,catalanLabels);
			
	// 3.6. TESTING GETTER AND SETTER METHODS
		
		System.out.println("Testing GET and SET methods: ");
		System.out.println("> " + "Kershner empty awards list (before set): " + swEp5.getDirectors().get(0).getAwards());
		
		// awards list for director Irvin Kershner to set
		
		List<String> ikAwards = new ArrayList<String>();
		ikAwards.add("Saturn Awards (Lifetime Career Award )");
		ikAwards.add("Saturn Awards (Best Director): Star Wars: The Empire Strikes Back");
		ikAwards.add("Hugo Awards (Best Dramatic Presentation): Star Wars: The Empire Strikes Back");
		ikAwards.add("Cannes Film Festival (OCIC Award): Hoodlum Priest ");
		
		swEp5.getDirectors().get(0).setAwards(ikAwards);
		System.out.println("> " + "Kershner full awards list (after set): " + swEp5.getDirectors().get(0).getAwards());
		
		System.out.println("> " + "The Star Wars episode 5 language is: " + swEp5.getLanguage().getDisplayLanguage(LANGUAGE));
		System.out.println("> " + "Ocho apellidos vascos language is: " + vascos.getLanguage().getDisplayLanguage(LANGUAGE));
		System.out.println("> " + "Ocho apellidos catalanes duration is: " + catalan.getDuration().toMinutes() + " minutes");
		System.out.println("> " + "Ocho apellidos catalanes rating is: " + catalan.getRating());
		System.out.println("> " + "Star Wars II film ID is: " + swEp2.getFilmId());
		
		
	// 3.7. TESTING EQUALS METHOD
		
		System.out.println("\nTesting EQUALS method: ");
		System.out.println("> " + "Is Star Wars IV equals to Star Wars IV?: " + swEp4.equals(swEp4));
		System.out.println("> " + "Is Star Wars IV equals to Star Wars V?: " + swEp4.equals(swEp5));
				
	// 3.8. TESTING TOSTRING METHOD
		
		System.out.println("\nTesting TOSTRING method: ");
		System.out.println( swEp2.toString());
				
	// 3.9. TESTING CREATE FILM COLLECTIONS
		
		System.out.println("\nTesting CREATE FILM COLLECTIONS methods: ");
		
		// 3.9.1. Create a collection with Star Wars episodes 4 and 5: "original" Star Wars collection
		
		List<Film> originalStarWars = swEp5.newFilmCollection(swEp4);
		
		System.out.println("> " + "Original Star Wars Collection: " + originalStarWars.get(0).getTitle() + ", " + originalStarWars.get(1).getTitle());
		
		// 3.9.2. create a collection with Star Wars episode 2 and "original" Star Wars collection (originalStarWars)
		
		List<Film> extendedStarWars = swEp2.newFilmCollection(originalStarWars);
		
		System.out.println("> " + "Extended Star Wars Collection: " + extendedStarWars.get(0).getTitle() + ", " + extendedStarWars.get(1).getTitle() + ", " + extendedStarWars.get(2).getTitle());
	
	// 3.10. TESTING SET ID WITH ADMIN SESSION
		
		System.out.println("\nTesting SETFILMID method (with admin session): ");
		System.out.println("> " + "Original Star Wars II filmId: " + swEp2.getFilmId());
		
		// 3.11. filmId modification attempt with admin with wrong password
		
		Admin adminWrong = new Admin("cesar","thisisthepassword1234");
		System.out.println("> " + "Modification attempt with admin with wrong password: ");
		swEp2.setFilmId(100, adminWrong);
		
		// 3.12. filmId modification attempt with admin with correct password
		
		System.out.println("> " + "Modification attempt with admin with correct password: ");
		Admin adminCorrect = new Admin("cesar","1234pass");
		swEp2.setFilmId(100, adminCorrect);
		System.out.println("> " + "Admin modified Star Wars II filmId: " + swEp2.getFilmId());
		
		
	//////////////////////////////
	// 4. TESTING EPISODE CLASS //
	/////////////////////////////
		
		System.out.println("\n\nTESTING EPISODE CLASS...\n");
		
	// 4.1. CREATING DIRECTORS LIST
		
		// 4.1.1. Creating directors list for Game of Thrones Season1  Episode 1
		
		List<Director> gotDirectorsS1Ep1 = new ArrayList<Director>();
		gotDirectorsS1Ep1.add(vanPatten);
		
		// 4.1.2. Creating directors list for GOT Season1 Episode 2
		
		List<Director> gotDirectorsS1Ep2 = gotDirectorsS1Ep1;
		
		// 4.1.3. Creating directors list for GOT Season1 Episode 3
		
		List<Director> gotDirectorsS1Ep3 = new ArrayList<Director>();
		gotDirectorsS1Ep3.add(kirkBrian);
		
		// 4.1.4. Creating directors list for GOT Season1 Episode 4
		
		List<Director> gotDirectorsS1Ep4 = gotDirectorsS1Ep3;
		
		// 4.1.5. Creating directors list for GOT Season2 Episode 1
		
		List<Director> gotDirectorsS2Ep1 = new ArrayList<Director>();
		gotDirectorsS2Ep1.add(taylorAlan);
		
		// 4.1.6. Creating directors list for GOT Season2 Episode 2
		
		List<Director> gotDirectorsS2Ep2 = gotDirectorsS2Ep1;
		
		// 4.1.7. Creating directors list for The Pacific Season 1 Episode 1
		
		List<Director> pacDirectorsS1Ep1 = new ArrayList<Director>();
		pacDirectorsS1Ep1.add(vanPatten);
		
	// 4.2. CREATING CAST LIST
		
		// 4.2.1. Creating cast list for GOT S1
		
		List<Actor> gotCastS1 = new ArrayList<Actor>();
		gotCastS1.add(turnerSophie);
		gotCastS1.add(haringtonKit);
		
		// 4.2.2. Creating cast list for GOT S2
		
		List<Actor> gotCastS2 = gotCastS1;
		
	// 4.3. CREATING EPISODES
		
		// 4.3.1. Creating Game of Thrones Season 1, episode 1
		
		Episode gotS1Ep1 = new Episode("Winter Is Coming","As the first episode of the series, it introduces the setting and the main characters of the show. The episode centers on the Stark family, and how its lord, Eddard \"Ned\" Stark, gets involved in the court politics after the king chooses Eddard to replace his recently deceased chief administrator)"
										,LocalDate.of(2011,4,17),Locale.ENGLISH,Duration.ofMinutes(62),gotDirectorsS1Ep1,gotCastS1);
		
		// 4.3.2. Creating GoT Season 1, episode 2
		
		Episode gotS1Ep2 = new Episode("The Kingsroad","Nearly all the action of the episode happens during travel: Eddard Stark and his daughters accompany the king's entourage to King's Landing to occupy the post of Hand of the King"
										,LocalDate.of(2011,4,24),Locale.ENGLISH,Duration.ofMinutes(56),gotDirectorsS1Ep2,gotCastS1);
		
		// 4.3.3. Creating GoT Season 1, episode 3
		
		Episode gotS1Ep3 = new Episode("Lord Snow","The plot follows Jon Snow's training at The Wall; Eddard's arrival at King's Landing, followed by Catelyn, looking for Bran's would-be murderer; Arya reveals her desire to learn sword fighting to her father; Joffrey is given a lesson in ruling the Kingdom by Cersei, and Robert longs for the glory of his past."
										,LocalDate.of(2011,5,1),Locale.ENGLISH,Duration.ofMinutes(58),gotDirectorsS1Ep3,gotCastS1);
		
		// 4.3.4. Creating GoT Season 1, episode 4
		
		Episode gotS1Ep4 = new Episode("Cripples, Bastards, and Broken Things","'Cripples, Bastards, and Broken Things' is the fourth episode of the first season of the HBO medieval fantasy television series Game of Thrones, which first aired on May 8, 2011. ... In this episode Lord Eddard Stark, the new Hand of the King, investigates the sudden death of his predecessor."
										,LocalDate.of(2011,5,8),Locale.ENGLISH,Duration.ofMinutes(56),gotDirectorsS1Ep4,gotCastS1);
		
		// 4.3.5. Creating GoT Season 2, episode 1
		
		Episode gotS2Ep1 = new Episode("The North Remembers","With a war on the horizon, the Seven Kingdoms are witnessing an ever-growing clash of kings. The boy king Joffrey Baratheon (Jack Gleeson) sits on the Iron Throne guided by cruelty and deceit, while his honorable counterpart Robb Stark (Richard Madden) of the North heads south to avenge his father's death."
										,LocalDate.of(2012,4,1),Locale.ENGLISH,Duration.ofMinutes(53),gotDirectorsS2Ep1,gotCastS2);
		
		// 4.3.6. Creating GoT Season 2, episode 2
		
		Episode gotS2Ep2 = new Episode("The Night Lands","The title refers to the Night Lands, the land of the dead in Dothraki religion. Irri is devastated that Rakharo will not go to the Night Lands because his body was mutilated by his killers without being burned."
										,LocalDate.of(2012,4,8),Locale.ENGLISH,Duration.ofMinutes(54),gotDirectorsS2Ep2,gotCastS2);
		
		// 4.3.7. Creating The Pacific: Season 1, episode 1
		
		Episode pacS1Ep1 = new Episode("Guadalcanal/Leckie","In Episode One, the story focuses primarily on Leckie, whose brief, chaste encounter with a neighborhood girl and chilly farewell from his father set the tone for thousands of unmoored boys dropped into tin cans and shipped thousands of miles across a sea they've never even seen"
										,LocalDate.of(2010,3,14),Locale.ENGLISH,Duration.ofMinutes(52),pacDirectorsS1Ep1,new ArrayList<>());
				
		
	// 4.4. TESTING GETTERS AND SETTERS
		
		System.out.println("Testing GET and SET methods: ");
		System.out.println("> " + "Game of Thrones Season 1, episode 3: " + gotS1Ep3.getTitle());
		System.out.println("> " + "Game of Thrones Season 2, episode 2 Directors: " + gotS2Ep1.getDirectors());
		System.out.println("> " + "The Pacific, season 1, episode 1 languaje: " + pacS1Ep1.getLanguage().getDisplayLanguage(LANGUAGE));
		
		
	/////////////////////////////
	// 5. TESTING SEASON CLASS //
	////////////////////////////
		
		System.out.println("\n\nTESTING SEASON CLASS...\n");
		
	// 5.1. CREATING LIST OF EPISODES
		
		// 5.1.1. Creating list of episodes: Season 1 Game Of Thrones
		
		List<Episode> gotS1Episodes= new ArrayList<Episode>();
		gotS1Episodes.add(gotS1Ep1);
		gotS1Episodes.add(gotS1Ep2);
		gotS1Episodes.add(gotS1Ep3);
		gotS1Episodes.add(gotS1Ep4);
		
		// 5.1.2. Creating list of episodes: Season 2 Game Of Thrones
		
		List<Episode> gotS2Episodes= new ArrayList<Episode>();
		gotS2Episodes.add(gotS2Ep1);
		gotS2Episodes.add(gotS2Ep2);
		
		// 5.1.3. Creating list of episodes: Season 2 Game Of Thrones
		
		List<Episode> pacS1Episodes= new ArrayList<Episode>();
		pacS1Episodes.add(pacS1Ep1);
		
	// 5.2. CREATING SEASONS
		
		Season gotS1, gotS2, gotS3, pacS1;
		Season emptySeason = new Season();
		
		// 5.2.1. Try to create Season 1 and 2: Game Of Thrones
		
		try {
			gotS1 = new Season("GOT S1", "The fist season of Game of Thrones", Locale.ENGLISH, gotS1Episodes);
		} catch (Exception e){
			gotS1 = new Season();
		}
		
		if (gotS1.equals(emptySeason)) {
			System.out.println("> " + "Error: Cannot create Game of Thrones Season 1, no episodes found\n");
		}
		
		try {
			gotS2 = new Season("GOT S2", "The second season of Game of Thrones", Locale.ENGLISH, gotS2Episodes);
		} catch (Exception e){
			gotS2 = new Season();
		}
		
		if (gotS2.equals(emptySeason)) {
			System.out.println("> " + "Error: Cannot create Game of Thrones Season 2, no episodes found\n");
		}	
		
		// 5.2.2. Try to create empty season 3 Game Of Thrones
		
		System.out.println("Trying to create a season without episodes: ");
		
		try {
			gotS3 = new Season("GOT S3", "The third season of Game of Thrones", Locale.ENGLISH, new ArrayList<Episode>());
		} catch (Exception e){
			gotS3 = new Season();
		}
		if (gotS3.equals(emptySeason)) {
			System.out.println(">"  + "Error: Cannot create Game of Thrones Season 3, no episodes found\n");
		}
		
		// 5.2.3. Trying to create season 1, The Pacific
		
		try {
			pacS1 = new Season("The Pacific S1", "The first season of The Pacific miniseries", Locale.ENGLISH, pacS1Episodes);
		} catch (Exception e){
			pacS1 = new Season();
		}
		if (pacS1.equals(emptySeason)) {
			System.out.println("> " + "Error: Cannot create The Pacific Season 1, no episodes found");
		}
		
	// 5.3. TESTING GETTERs AND SETTERs
		
		System.out.println("Testing GET and SET methods: ");
		System.out.println("> " + "GoT: The first emision of the second season was: " + gotS2.getReleaseDate());
		System.out.println("> " + "GoT: The cast the second season was: " + gotS2.getCast());
		System.out.println("> " + "The total duration of GoT first season is: " + gotS1.getDuration().toMinutes() + " minutes");
		System.out.println("> " + "The total duration of The Pacific first season is: " + pacS1.getDuration().toMinutes() + " minutes");
		
		
		// TESTING EQUALS METHOD
		
		System.out.println("\nTesting EQUALS method: ");
		System.out.println("> " + "Is Game of Thrones Season 2 equals to The pacific season 1?: " + gotS2.equals(pacS1));
		System.out.println("> " + "Is Game of Thrones Season 1 equals to Game of Thrones season 1?: " + gotS1.equals(gotS1));
		
		
	/////////////////////////////
	// 6. TESTING SERIE CLASS //
	////////////////////////////
		
		System.out.println("\n\nTESTING SERIE CLASS...\n");
		
	// 6.1. CREATING LIST OF SEASONS
		
		// 6.1.1. Creating list of seasons: Game Of Thrones Series
		
		List<Season> gotSeasons= new ArrayList<Season>();
		gotSeasons.add(gotS1);
		gotSeasons.add(gotS2); 

		// 6.1.2. Creating list of seasons: The Pacific Series
		
		List<Season> pacSeasons= new ArrayList<Season>();
		pacSeasons.add(pacS1);
		
	// 6.2. CREATING SERIES
		
		Serie gotSerie, pacSerie, friendsSerie;
		Serie emptySerie = new Serie();
		
		// 6.2.1. Trying to create Game of Thrones series
		
		try {
			gotSerie = new Serie("Game of Thrones","A fantasy series",false,Locale.ENGLISH,gotSeasons);
		} catch (Exception e){
			gotSerie = new Serie();
		}
		
		if (gotSerie.equals(emptySerie)) {
			System.out.println("> " + "Error: Cannot create Game of Thrones series, no seasons found");
		}
		
		// 6.2.2. Trying to create The Pacific miniseries
		
		try {
			pacSerie = new Serie("The Pacific","Directly following the attack on Pearl Harbor, Sgt. Jon Basilone ships out to fight the enemy somewhere in the Pacific, and young journalist, Robert Leckie, enlists in the Marine Corps. Sidney Phillips ships off to boot camp after saying farewell to his friend Eugene Sledge, who cannot go with him due to a heart murmur. Eight months later, Phillips and Leckie have completed boot camp and are sent to secure an airfield on Guadalcanal, and defend it against counterattack"
									,true,Locale.ENGLISH,pacSeasons);
		} catch (Exception e){
			pacSerie = new Serie();
		}
		
		if (pacSerie.equals(emptySerie)) {
			System.out.println("> " + "Error: Cannot create The Pacific series, no seasons found");
		}
	
		// 6.2.3. Trying to create "Friends" Serie
		
		System.out.println("Trying to create a series without seasons: ");
		
		try {
			friendsSerie = new Serie("Friends","A comedy series",true,Locale.ENGLISH,new ArrayList<Season>());
		} catch (Exception e){
			friendsSerie = new Serie();
		}
		
		if (friendsSerie.equals(emptySerie)) {
			System.out.println("> " + "Error: Cannot create 'Friends' series, no seasons found");
		}
		
		
	///////////////////////////////
	// 7. TESTING CATALOG CLASS //
	/////////////////////////////
		
		System.out.println("\n\nTESTING CATALOG CLASS...\n");
		
		// 7.1. We create a new empty catalog
		Catalog streamInCatalog = new Catalog();
		
		// 7.2. We add Film to the Catalog
		System.out.println("We add Star Wars Episode 2 Film to the Catalog: \n");
		streamInCatalog.addFilm(swEp2);
		
		// 7.3. We try to add repeated Film to the Catalog. Doesn't add swEp2 to the catalog
		System.out.println("We try to add repeated Film to the Catalog:\n");
		streamInCatalog.addFilm(swEp2);
		
		// 7.4. We add Film Collection to the Catalog. Note that swEp2 is repeated,
		// but in the catalog is only stored once.
		System.out.println("We add Film Collection: extendedStarWars to the Catalog:\n");
		streamInCatalog.addFilmCollection(extendedStarWars);
		
		// 7.5. We print the summary of the catalog films. 
		System.out.println("We print the summary of the catalog films:\n");
		streamInCatalog.summarizeFilmsCatalog();
		
		// 7.6. We add Game of thrones series to the catalog
		System.out.println("We add Game of thrones series to the catalog:\n");
		streamInCatalog.addSerie(gotSerie);
		
		// 7.7. We print the summary of the entire catalog
		System.out.println("We print the summary of the entire catalog:\n");
		streamInCatalog.summarizeCatalog();
		
		// 7.8. We remove Star Wars episode 2
		System.out.println("We remove Star wars episode 2: \n");
		streamInCatalog.removeFilm(swEp2);
		
		// 7.9. We try to remove Ocho apellidos vascos (is not include in the catalog)
		System.out.println("We try to remove Ocho apellidos vascos: \n");
		streamInCatalog.removeFilm(vascos);
			
		// 7.10. we add Ocho apellidos vascos Film to the catalog
		System.out.println("We add Ocho apellidos vascos film to the Catalog:\n");
		streamInCatalog.addFilm(vascos)
		;
		// 7.11. We print the summary of the entire catalog
		streamInCatalog.summarizeCatalog();
		
		streamInCatalog.addFilm(swEp2);
		// 7.12. We remove originalStarWars Collection
		System.out.println("We remove originalStarWars Collection:\n");
		streamInCatalog.removeFilmCollection(originalStarWars);
		streamInCatalog.summarizeCatalog();
		
		// 7.13. We remove the entire Film list from the catalog
		System.out.println("We remove the entire Film list from the catalog:\n");
		streamInCatalog.removeAllFilms();
		streamInCatalog.summarizeCatalog();
		
		// 7.14. We remove the GOT Series from the catalog
		System.out.println("We remove the GOT series from the catalog:\n");
		streamInCatalog.removeSerie(gotSerie);
		
		System.out.println("We try to remove again the GOT series from the catalog:\n");
		streamInCatalog.removeSerie(gotSerie);
		
		streamInCatalog.summarizeSeriesCatalog();
		
		// 7.15. We add all the content we have create to the catalog
		System.out.println("We summarize the full Catalog:\n");
		streamInCatalog.addFilmCollection(extendedStarWars);
		streamInCatalog.addFilm(vascos);
		streamInCatalog.addSerie(gotSerie);
		streamInCatalog.addSerie(pacSerie);
		
		streamInCatalog.summarizeCatalog();
		
		
	///////////////////////////////////////
	// 8. TESTING USER and ADMIN CLASSES //
	///////////////////////////////////////
		
		System.out.println("\nTESTING USER and ADMIN CLASSES...\n");
		
		// CREATING NEW USERS
		
		// creating an adult user. Note that the "adult" is implicit in the age.
		// the program set automatically the awolled contents based on the user age.
		
		User adultUser = new User("John","Smith",LocalDate.of(1999, 9, 1), "25466578Y",Contract.PREMIUM,streamInCatalog);
		
		// creating a childen user. Note that the "chidren" is implicit in the age.
		// the program set automatically the awolled contents based on the user age.
		
		User childUser = new User("Maria","López",LocalDate.of(2009, 10, 23), "28997578C",Contract.NORMAL,streamInCatalog);
		
		// We add the entire catalog to the adultUser playlist
		adultUser.addCatalogToPlaylist();
		
		System.out.println("The entire user's catalog if is an adult:\n");
		adultUser.summarizePlaylist();
		
		// We add the entire catalog to the childUser playlist
		childUser.addCatalogToPlaylist();
		
		System.out.println("The entire user's catalog if is a child:\n");
		childUser.summarizePlaylist();
		
		// We change the birth date of the child user (with admin permissions)
		System.out.println("We change the childUser age to an adult age (with admin permissions):\n");
		childUser.setBirthDate(LocalDate.of(1999, 3, 8), adminCorrect);
		
		// We summarize the new childUser catalog
		childUser.clearPlaylist();
		childUser.addCatalogToPlaylist();
		System.out.println("The new catalog for childUser is: ");
		childUser.summarizePlaylist();
		
		
		// We remove all the films included in playlist
		adultUser.removeFilmsInPlaylist();
		
		// We add the Star Wars Film Episode 2: Attack of the clones to the playlist
		adultUser.addFilmToPlaylist(swEp2, Duration.ofMinutes(33));
		
		System.out.println("User playlist after removing all the films and adding Star Wars episode 2:\n");
		adultUser.summarizePlaylist();
		
		// Trying to add again the same film
		System.out.println("Trying to add repeated film: ");
		adultUser.addFilmToPlaylist(swEp2, Duration.ofMinutes(33));
		
		// Removing all the playlist contents
		adultUser.clearPlaylist();
		
		// We add all the Catalog series to our playlist
		adultUser.addSeriesToPlaylist();
		
		System.out.println("User playlist after removing all the series and adding all catalog series 2:\n");
		adultUser.summarizePlaylist();
		
		// We remove the Game of Thrones series
		adultUser.removeSerieInPlaylist(gotSerie);
		
		// We try to remove again the Game of Thrones series
		System.out.println("Trying to add repeated series: ");
		adultUser.removeSerieInPlaylist(gotSerie);
		
		// We try to add to the playlist a film that exists but is not in the catalog
		System.out.println("\nTrying to add to playlist a film not included the catalog: ");
		adultUser.addFilmToPlaylist(catalan, Duration.ofMinutes(12));

	}
	
}
