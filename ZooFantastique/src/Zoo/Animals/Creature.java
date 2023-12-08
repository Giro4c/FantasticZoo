package Zoo.Animals;

import java.util.Random;
import Zoo.Desease;
import Zoo.Enclosure;
import Zoo.Animals.*;
import Zoo.Prompts.Message;

public class Creature implements Runnable{
	
	public static final String[] HUNGER_STATES = {"Full", "Normal", "Hungry", "Famished", "Dead"};
	public static final String[] HEALTH_STATES = {"Perfect", "Normal", "Sick", "Very Sick", "Dead"};
	
	
	private String specie;
	private String name;
	private boolean isMale;
	private int weight;
	private int height;
	private int age;
	private String indicatorHunger;
	private boolean isSleeping;
	private String indicatorHealth;
	private Enclosure enclosure;
	private Desease desease;
	// Thread will run until creature dies or is deleted
	private Thread lifeThread;
	
	public void startLife() {
		this.lifeThread.start();
	}
	private void endLife() {
		this.lifeThread.interrupt();
		this.lifeThread = null;
	}
	
	public boolean isSick() {
		return isSick;
	}
	public void setSick(boolean isSick) {
		this.isSick = isSick;
	}
	public Enclosure getEnclosure() {
		return enclosure;
	}
	public int getHeightMin() {
		return heightMin;
	}
	public int getHeightMax() {
		return heightMax;
	}
	public int getWeightMin() {
		return weightMin;
	}
	public int getWeightMax() {
		return weightMax;
	}
	public void setDesease(Desease desease) {
		this.desease = desease;
	}
	public boolean isSick;

	public String getSpecie() {
			return specie;
	}
	public void becomeSick(Desease d){
		this.desease = d;
		this.isSick = true;
	}

	public void removeDesease() {
		this.desease =null;
    }
	public void setSpecie(String specie) {
		this.specie = specie;
	}

	private int heightMin;
	private int heightMax;
	private int weightMin;
	private int weightMax;
	public void setHeightMin(int min){
		this.heightMin = min;
	}
	public void setHeightMax(int max) {
		this.heightMax = max;
	}
	public void setWeightMin(int min){
		this.weightMin = min;
	}
	public void setWeightMax(int max) {
		this.weightMax = max;
	}
	public Creature(String specie, String name, boolean isMale, int weight, int height, int age, Enclosure enclosure) {
		super();
		this.specie = specie;
		this.name = name;
		this.isMale = isMale;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.enclosure = enclosure;	
		
		// Default values
		this.desease = null;
		this.isSick = false;
		this.isSleeping = false;
		this.indicatorHealth = HEALTH_STATES[0];
		this.indicatorHunger = HUNGER_STATES[0];
		
		this.lifeThread = new Thread(this);
	}
	
	public Creature(String specie, boolean isMale, int weight, int height, int age, Enclosure enclosure) {
			super();
			this.specie = specie;
			this.isMale = isMale;
			if (isMale) {
				this.name = ListNames.assignRandomNameMale();
			}
			else {
				this.name = ListNames.assignRandomNameFemale();
			}
			this.weight = weight;
			this.height = height;
			this.age = age;
			this.enclosure = enclosure;
			
			// Default values
			this.desease = null;
			this.isSick = false;
			this.isSleeping = false;
			this.indicatorHealth = HEALTH_STATES[0];
			this.indicatorHunger = HUNGER_STATES[0];
			
			this.lifeThread = new Thread(this);
	}
	
	
	
	public Creature(String specie, boolean isMale, int age, Enclosure enclosure, int heightMin, int heightMax,
			int weightMin, int weightMax) {
		super();
		this.specie = specie;
		this.isMale = isMale;
		if (isMale) {
			this.name = ListNames.assignRandomNameMale();
		}
		else {
			this.name = ListNames.assignRandomNameFemale();
		}
		this.age = age;
		this.enclosure = enclosure;
		this.heightMin = heightMin;
		this.heightMax = heightMax;
		this.weightMin = weightMin;
		this.weightMax = weightMax;
		
		// Default values
		this.desease = null;
		this.isSick = false;
		this.isSleeping = false;
		Random rand = new Random();
		this.height = rand.nextInt(heightMin, heightMax + 1);
		this.weight = rand.nextInt(weightMin, weightMax + 1);
		this.indicatorHealth = HEALTH_STATES[0];
		this.indicatorHunger = HUNGER_STATES[0];
		
		this.lifeThread = new Thread(this);
	}
	
	// Will be stopped when the creature is deleted or dies
	@Override 
	public void run() {
	    
	    Random random = new Random(); // For random number
	    
	    while(true) { 
	        
	        try {
	            synchronized (this) {
	                int randomNumberSleep = random.nextInt(5001) + 5000;
	                this.wait(randomNumberSleep); // Sleeps the thread between 15 and 25 seconds
	            }
	        } catch (InterruptedException e) {
	            break; // Thread only interrupted if creature dies or is deleted
	        }
	        this.getOlder();
	        
	        int RandomNumber; // Number used for the probabilities.
	        
	        // Determines if creature must become sick
	        if (!this.isSick) {
	        	RandomNumber = random.nextInt(250);
	        	if (RandomNumber <= this.percentageSick()) { // ?% chance that the creature gets sick
		        	this.desease = new Desease(1, random.nextInt(1, 4), random.nextInt(1, 6), this);
		        	this.isSick = true;
		        }
	        }
	        
	        // If it's sleeping, do something ?
	        if (this.isSleeping) { // If it is sleeping
	        	RandomNumber = random.nextInt(100);
	        	if ( RandomNumber < 20) { // 20% chance that the creature wakes up
	                this.wake();
//	                System.out.println("Wake");
	            }
	        }
	        // If it's awake, do something ?
	        else { // If it is not sleeping
	        	RandomNumber = random.nextInt(100);
	        	if ( RandomNumber < 8) { // 8% chance that the creature falls asleep (because 0 included)
	                this.sleep();
//	                System.out.println("Sleep");
	            }
	            if ( RandomNumber >= 8 && RandomNumber < 11) { // 3% chance that the creature emits a sound
	                this.emitSound();
	            }
	            if ( RandomNumber >= 11 && RandomNumber < 26) { // 15% chance that the creature gets hungry
	                this.becomeMoreHungry();
//	                System.out.println("Get Hungry");
	            }
	        }
	    }
	}
	
	/**
	 * 
	 * This method calculates the percentage chance that a creature will fall sick, ill depending on its state of hunger, the cleanliness of the enclosure and whether there are already sick creatures in the same enclosure.
	 * 
	 * @return int percentage : the percentage calculated
	 */
	public int percentageSick () {
		int percentage = 1;
		
		if (this.indicatorHunger.equals("Normal")) {
			percentage += 1;
		}
		else if (this.indicatorHunger.equals("Hungry")) {
			percentage += 2;
		}
		else if (this.indicatorHunger.equals("Famished")) {
			percentage += 3;
		}
		
		if (this.getEnclosure().getCleanness().equals("Normal")) {
			percentage += 1;
		}
		else if (this.getEnclosure().getCleanness().equals("Dirty")) {
			percentage += 2;
		}
		else if (this.getEnclosure().getCleanness().equals("Moundir's Room")) {
			percentage += 3;
		}
		
		for (Creature crea : this.getEnclosure().getPresentCreatures()) {
			if ( crea.isSick ) {
				percentage += 1;
			}
		}
		
		return percentage;		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public boolean isMale() {
		return isMale;
	}

	public void setIsSick(boolean isSick) {
		this.isSick = isSick;
	}
	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getIndicatorHunger() {
		return indicatorHunger;
	}

	public void setEnclosure(Enclosure enclosure) {
		this.enclosure = enclosure;
	}

	public void setIndicatorHunger(String indicatorHunger) {
		this.indicatorHunger = indicatorHunger;
	}
	public void becomeMoreHungry() {
		
		if (this.indicatorHunger.equals("Famished")) {
			this.indicatorHunger = "Dead";
			this.die();
		}
		if (this.indicatorHunger.equals("Hungry")) {
			this.indicatorHunger = "Famished";
		}
		if(this.indicatorHunger.equals("Normal")) {
			this.indicatorHunger = "Hungry";
		}
		if (this.indicatorHunger.equals("Full")) {
			this.indicatorHunger = "Normal";
		}
	}

	//NE PAS MODIFIER L'ORDRE !!!
	//l'animal devient de plus en plus malade
	public void becomeMoreSick(){
		if(this.indicatorHealth.equals("Very Sick")){
			this.indicatorHealth="Dead";
//			System.out.println("Death by sickness.");
			this.die();
		}
		if(this.indicatorHealth.equals("Sick")){
			this.indicatorHealth="Very Sick";
		}
		if(this.indicatorHealth.equals("Normal")){
			this.indicatorHealth="Sick";
		}
		if(this.indicatorHealth.equals("Perfect")){
			this.indicatorHealth="Normal";
		}
	}
	public Desease getDesease() {
		return this.desease;
	}


	public boolean isSleeping() {
		return isSleeping;
	}


	public void setSleeping(boolean isSleeping) {
		this.isSleeping = isSleeping;
	}


	public String getIndicatorHealth() {
		return indicatorHealth;
	}


	public void setIndicatorHealth(String indicatorHealth) {
		this.indicatorHealth = indicatorHealth;
	}
	
	@Override
	public String toString() {
		String genre;
		String sleep;
		if (isMale==true) {genre = "Man";}
		else {genre = "Woman";}
		if(isSleeping==true) {sleep= "sleeping";}
		else {sleep="not sleeping";}
		return "The Creature " + name + ", of species " + specie + ", is a " + genre + ", weighing " + weight + ", and measuring " + height +
		        ", at the age of " + age + " years. Its hunger indicator is " + indicatorHunger + ", and it is " + sleep +
		        ". Its health indicator is: " + indicatorHealth;

	}

	//fonction qui permet à un animal d'être traité de la maladie
	public void treat(){
		System.out.println("L'animal " + this.getName()+ " à reçu un remède contre la maladie "+ this.desease.getName());
		this.desease.remove(this);
	}
	public void eat() {
		if (this.indicatorHunger.equals("Normal")) {
			this.indicatorHunger = "Full";
		}
		else if (this.indicatorHunger.equals("Hungry")) {
			this.indicatorHunger = "Normal";
		}
		else if (this.indicatorHunger.equals("Famished")) {
			this.indicatorHunger = "Hungry";
		}
		System.out.println(this.getSpecie() + " " + this.getName() + " eats.");
	}
	
	public void emitSound() {
		System.out.println("The " + this.specie + " " + this.name + " emits a sound !");
	}
	//fonction qui permet à un animal de se soigner 
	public void heal() {
		this.treat();		
		if (this.indicatorHunger.equals("Very Sick")) {
			this.indicatorHunger = "Sick";
		}
		else if (this.indicatorHunger.equals("Sick")) {
			this.indicatorHunger = "Normal";
		}
		else if (this.indicatorHunger.equals("Normal")) {
			this.indicatorHunger = "Perfect";
		}
		System.out.println("The creature "+ this.getName() + " has been healed, its health is now : "+ this.indicatorHealth);
	}
	
	public void sleep() {
		this.isSleeping = true;
	}
	
	public void wake() {
		this.isSleeping = false;
	}
		
	public void getOlder() {
		this.setAge(this.getAge()+ 1);
	}

	//méthode qui permet de faire en sorte qu'un animal meurt
	public void die() {
		System.out.println("The creature " + this.getName() + " is dead !");
		this.delete();
	}
	
	public void delete() {
		if (this.enclosure != null) {
			this.enclosure.removeCreature(this);
			this.enclosure = null;
		}
		if (this.desease != null) {
			this.desease.setAnimal(null);
			this.desease = null;
		}
		// Put back the name in the static list for female or male creatures
		if (this.isMale) {
			ListNames.addNameMale(this.name);
		}
		else {
			ListNames.addNameFemale(this.name);
		}
		this.endLife();
		System.gc();
	}


}
