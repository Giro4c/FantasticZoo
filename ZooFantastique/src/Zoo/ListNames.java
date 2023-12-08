package Zoo;

import java.util.ArrayList;
import java.util.Random;

public class ListNames {

	private static ArrayList<String> namesFemales = initNamesFemales();
	private static ArrayList<String> namesMales = initNamesMales();
	private static ArrayList<String> namesDiseases = initNamesDiseases();
	
	public static ArrayList<String> getNamesFemales() {
		return namesFemales;
	}

	public static ArrayList<String> getNamesMales() {
		return namesMales;
	}

	private static ArrayList<String> initNamesFemales(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("Fenya");
		list.add("Victory");
		list.add("Zara");
		list.add("Valery");
		list.add("Selene");
		list.add("Calista");
		list.add("Evadne");
		list.add("Elysia");
		list.add("Athena");
		list.add("Zephyra");
		list.add("Oriana");
		list.add("Caelia");
		list.add("Lorelei");
		list.add("Ophelia");
		list.add("Nyx");
		list.add("Elowen");
		list.add("Morgana");
		list.add("Aria");
		list.add("Sylvara");
		list.add("Faela");
		list.add("Thalia");
		list.add("Artemis");
		list.add("Eowyn");
		list.add("Lilith");
		list.add("Isolde");
		list.add("Seraphina");
		list.add("Mystic");
		list.add("Elara");
		list.add("Arya");
		list.add("Luna");
		list.add("Yvaine");
		list.add("Cordelia");
		list.add("Astraea");
		list.add("Rhiannon");
		list.add("Elysium");
		list.add("Evadne");
		list.add("Mira");
		list.add("Mina");
		list.add("Lirael");
		list.add("Hylde");
		list.add("Freya");
		list.add("Eirlys");
		list.add("Zelda");
		list.add("Ondine");
		list.add("Amalthea");
		list.add("Fiora");
		list.add("Isabelle");
		list.add("Melisandre");
		list.add("Zephyrine");
		list.add("Celestia");
		list.add("Astrid");
		list.add("Nocturna");
		list.add("Thalassa");
		list.add("Persephone");
		list.add("Evangeline");
		list.add("Lyra");
		list.add("Aurora");
		list.add("Calypso");
		list.add("Illyria");
		list.add("Circe");
		
		return list;
	}
	
	private static ArrayList<String> initNamesMales(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("Moundir");
		list.add("Robin");
		list.add("Chiheb");
		list.add("Icarus");
		list.add("Zeus");
		list.add("Prometheus");
		list.add("Odinson");
		list.add("Mickael");
		list.add("Angelo");
		list.add("Alexis");
		list.add("Valentin");
		list.add("Clement");
		list.add("Mathias");
		list.add("Lucas");
		list.add("Ronan");
		list.add("Theon");
		list.add("Alastor");
		list.add("Arthur");
		list.add("Merlin");
		list.add("Ezekiel");
		list.add("Grimm");
		list.add("Hollow");
		list.add("Caelum");
		list.add("Raphael");
		list.add("Ayoub");
		list.add("Gabin");
		list.add("Yoann");
		list.add("Maximus");
		list.add("Valentino");
		list.add("Romanus");
		list.add("Tymeo");
		list.add("Matteo");
		list.add("Lucius");
		list.add("Lucifer");
		list.add("Erwan");
		list.add("Mathieu");
		list.add("Tom");
		list.add("Dorian");
		list.add("Orion");
		list.add("Zephyr");
		list.add("Thorne");
		list.add("Lysander");
		list.add("Soron");
		list.add("Cyrus");
		list.add("Axel");
		
		return list;
	}
	
	private static ArrayList<String> initNamesDiseases() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("COVID-19");
		list.add("Pest");
		list.add("Common cold");
		list.add("Flu");
		list.add("Conjunctivitis ");
		list.add("Cancer");
		list.add("Diabetes");
		return list;
	}
	
	public static String assignRandomNameFemale() {
		if (ListNames.namesFemales.size() == 0) return null;
		Random rand = new Random();
		int indexName = rand.nextInt(0, ListNames.namesFemales.size());
		return ListNames.namesFemales.remove(indexName);
	}
	
	public static void addNameFemale(String name) {
		if (name == null) return;
		ListNames.namesFemales.add(name);
	}
	
	public static String assignRandomNameMale() {
		if (ListNames.namesMales.size() == 0) return null;
		Random rand = new Random();
		int indexName = rand.nextInt(0, ListNames.namesMales.size());
		return ListNames.namesMales.remove(indexName);
	}
	
	public static void addNameMale(String name) {
		if (name == null) return;
		ListNames.namesMales.add(name);
	}
	
	public static String getRandomNameDisease() {
		if (ListNames.namesDiseases.size() == 0) return null;
		Random rand = new Random();
		int indexName = rand.nextInt(0, ListNames.namesDiseases.size());
		return ListNames.namesDiseases.get(indexName);
	}
	
}
