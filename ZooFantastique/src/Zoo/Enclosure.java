package Zoo;

import java.util.ArrayList;
import Zoo.Animals.Creature;
import java.util.Random;

public class Enclosure implements Runnable{
	
	public static final String[] CLEANNESS_STATES = {"Clean", "Normal", "Dirty", "Moundir's Room"};

	private String name;
	private int surface;
	private final int maxNumberCreatures;
	private int currentNumberCreatures;
	private ArrayList<Creature> presentCreatures;
	private int indexcleanness = 0;
	private String cleanness = CLEANNESS_STATES[indexcleanness];
	
	public Enclosure(String name, int surface, int maxNumberCreatures, String cleanness) {
		super();
		this.name = name;
		this.surface = surface;
		this.maxNumberCreatures = maxNumberCreatures;
		this.cleanness = cleanness;
		this.presentCreatures = new ArrayList<Creature>();
		this.currentNumberCreatures = this.presentCreatures.size();
	}
	
	@Override
	public void run() {
		Random random = new Random();
		while(true) {
			try {
				synchronized (this) {
					int randomNumberSleep = random.nextInt(10001) + 10000;
					this.wait(randomNumberSleep);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int RandomNumber = random.nextInt(100);
			if ( RandomNumber < 5) {
				if(this.getIndexcleanness() < CLEANNESS_STATES.length-1) {
					this.setIndexcleanness(this.getIndexcleanness()+1);
					System.out.println("The enclosure " + this.getName() + " gets dirty !");
				}
			}
		}
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getIndexcleanness() {
		return indexcleanness;
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

	private void setIndexcleanness(int indexcleanness) {
		 this.indexcleanness = indexcleanness;
		 this.cleanness = CLEANNESS_STATES[indexcleanness];
	}


	public void showCreaturesCaracteristics() {
		System.out.println("Creatures Caracteristics in the " + this.name + " : ");
		for (int i = 0;i <= presentCreatures.size();i++) {
			System.out.println("Creatures Caracteristics : " + presentCreatures.get(i).toString());
		}
		
	} 
	
	public void addCreature(Creature newCreature) {
		System.out.println("A new creature " + newCreature.toString() + "was added in the" + this.getName());
	}
	
	public Creature removeCreature(int indexCreature) {
		System.out.println("A new creature " + this.presentCreatures.get(indexCreature).getName()+ "was remove in the" + this.getName());
		return null;
	}
	
	public void feedCreatures() {
		System.out.println("The creature in the " + this.getName() + " was feeded");
	}
	
	public void clean() {
		System.out.println("The enclosure " + this.getName() + " was cleaned !");
	}




	
}
