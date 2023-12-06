package Zoo;

import java.util.ArrayList;

import Zoo.Prompts.CommandHandler;
import Zoo.Prompts.Message;
import Zoo.Animals.Creature;

public class FantasticZoo {

	private static void testThreads(){
		Enclosure Encl = new Enclosure("test",20,12,"Clean");
		Thread t1 = new Thread(Encl);
		Aquarium Aqua = new Aquarium("test",20,12,"Clean", 2, 35);
		Thread t2 = new Thread(Aqua);
		Aviary avia = new Aviary("test",20,12,"Clean", 2);
		Thread t3 = new Thread(avia);
		t1.start();
		t2.start();
		t3.start();
	}

	public static void main(String[] args) {
		GameEngine game = new GameEngine();
		while (true) {
			game.showChoices();
			try {
				CommandHandler.executeCommand(Message.registerCommand(4), game);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
		
	public FantasticZoo(String name, ZooMaster zooMaster, int maxNumberEnclosures) {
		super();
		this.name = name;
		this.zooMaster = zooMaster;
		this.maxNumberEnclosures = maxNumberEnclosures;
		this.existingEnclosures = new ArrayList<Enclosure>();
	}

	private String name;
	private ZooMaster zooMaster;
	private final int maxNumberEnclosures;
	private ArrayList<Enclosure> existingEnclosures;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ZooMaster getZooMaster() {
		return zooMaster;
	}

	public void setZooMaster(ZooMaster zooMaster) {
		this.zooMaster = zooMaster;
	}

	public int getMaxNumberEnclosures() {
		return maxNumberEnclosures;
	}
	
	public ArrayList<Enclosure> getExistingEnclosures() {
		return existingEnclosures;
	}

	public void setExistingEnclosures(ArrayList<Enclosure> existingEnclosures) {
		this.existingEnclosures = existingEnclosures;
	}

	
	
	@Override
	public String toString() {
		return "FantasticZoo [name=" + name + ", zooMaster=" + zooMaster + ", maxNumberEnclosures="
				+ maxNumberEnclosures + ", existingEnclosures=" + existingEnclosures + "]";
	}
	public int Comptcreature() {
		int NumberAnimals = 0; 
		for (Enclosure enclo : existingEnclosures) {
			NumberAnimals += enclo.getCurrentNumberCreatures();
		}
		return NumberAnimals;
	}

	public void showTotalCreatures() {
		System.out.println("In the FantasticZoo " + this.getName() + " there is " + this.Comptcreature() + " creature");
	} 
	
	public void showAllCreatures(){
		System.out.println("All creature atribute :");
		for (Enclosure enclo : existingEnclosures) {
			for (Creature creatur : enclo.getPresentCreatures()) {
				System.out.println(creatur.toString());
			}
		}
	}
	
	public void addNewEnclosure(Enclosure newEnclosure) {
		if ( existingEnclosures.size() < this.getMaxNumberEnclosures()) {
			this.existingEnclosures.add(newEnclosure);
			System.out.println("The new enclosure " + newEnclosure.getName() + " was added in the FantasticZoo");
		}
		else {
			System.out.println("Le nombre max d'enclo a déja était atteint (je sais pas écrire c abusé)");
		}
	}
	
	public void removeEnclosure(int oldEnclosureIndex) {
		Enclosure oldEnclosure = existingEnclosures.get(oldEnclosureIndex);
		if ( oldEnclosure.getCurrentNumberCreatures() == 0) {
			existingEnclosures.remove(oldEnclosure);
			System.out.println("The enclosure " + oldEnclosure.getName() + " was remove from the FantasticZoo");
			System.gc();
		}
		else {
			System.out.println("The enclosure " + oldEnclosure.getName() + " cannot be remove, creature still live in !");
		}	}
	
	public void removeEnclosure(Enclosure oldEnclosure) {
		if ( oldEnclosure.getCurrentNumberCreatures() == 0) {
			existingEnclosures.remove(oldEnclosure);
			System.out.println("The enclosure " + oldEnclosure.getName() + " was remove from the FantasticZoo");
			System.gc();
		}
		else {
			System.out.println("The enclosure " + oldEnclosure.getName() + " cannot be remove, creature still live in !");
		}
	}
	
	/* ------------------------------------------------- */
	

}
