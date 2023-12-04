package Zoo;

import java.util.ArrayList;

import Zoo.Animals.Creature;

public class FantasticZoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
			for (Creature creatur : enclo.getPresentCreatures()) {
				NumberAnimals += 1;
			}
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
		System.out.println("The new enclosure " + newEnclosure.getName() + " was added in the FantasticZoo");
	}
	
	public void removeEnclosure(Enclosure oldEnclosure) {
		System.out.println("The new enclosure " + oldEnclosure.getName() + " was remove from the FantasticZoo");
	}
}
