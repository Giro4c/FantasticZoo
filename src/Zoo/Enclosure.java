package Zoo;

import java.util.ArrayList;
import Zoo.Animals.Creature;

public class Enclosure {

	private String name;
	private int surface;
	private final int maxNumberCreatures;
	private int currentNumberCreatures;
	private ArrayList<Creature> presentCreatures;
	private String cleanness;
	
	public Enclosure(String name, int surface, int maxNumberCreatures, String cleanness) {
		super();
		this.name = name;
		this.surface = surface;
		this.maxNumberCreatures = maxNumberCreatures;
		this.cleanness = cleanness;
		this.presentCreatures = new ArrayList<Creature>();
		this.currentNumberCreatures = this.presentCreatures.size();
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getSurface() {
		return surface;
	}



	public void setSurface(int surface) {
		this.surface = surface;
	}



	public int getCurrentNumberCreatures() {
		return currentNumberCreatures;
	}



	public void setCurrentNumberCreatures(int currentNumberCreatures) {
		this.currentNumberCreatures = currentNumberCreatures;
	}



	public ArrayList<Creature> getPresentCreatures() {
		return presentCreatures;
	}



	public void setPresentCreatures(ArrayList<Creature> presentCreatures) {
		this.presentCreatures = presentCreatures;
	}



	public String getCleanness() {
		return cleanness;
	}



	public void setCleanness(String cleanness) {
		this.cleanness = cleanness;
	}



	public int getMaxNumberCreatures() {
		return maxNumberCreatures;
	}



	public void showCreaturesCaracteristics() {
		
	}
	
	public void addCreature(Creature newCreature) {
		
	}
	
	public Creature removeCreature(int indexCreature) {
		
	}
	
	public void feedCreatures() {
		
	}
	
	public void clean() {
		
	}
	
}
