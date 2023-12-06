package Zoo.Animals;

import Zoo.Desease;
import Zoo.Enclosure;
import Zoo.Animals.*;
import Zoo.Caracteristics.*;
public class Creature {
	
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
	public Creature(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger,
		boolean isSleeping, String indicatorHealth, Enclosure enclosure) {
		super();
		this.specie = specie;
		this.name = name;
		this.isMale = isMale;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.indicatorHunger = indicatorHunger;
		this.isSleeping = isSleeping;
		this.indicatorHealth = indicatorHealth;
		this.enclosure = enclosure;
		this.enclosure.addCreature(this);
	}
	
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


	public String getName() {
		return name;
	}

	public void setEnclosure(Enclosure enclosure) {
		this.enclosure = enclosure;
		
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


	public void setIndicatorHunger(String indicatorHunger) {
		this.indicatorHunger = indicatorHunger;
	}
	public void becomeMoreHungry() {
		
		if (this.indicatorHunger.equals("Famished")) {
			this.indicatorHunger = "Dead";
			System.out.println("L'animal "+this.getName()+" Meurt de faim !");
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
		return "Creature [specie=" + specie + ", isMale=" + isMale + ", weight=" + weight + ", height=" + height
				+ ", age=" + age + ", indicatorHunger=" + indicatorHunger + ", isSleeping=" + isSleeping
				+ ", indicatorHealth=" + indicatorHealth + "]";
	}

	//fonction qui permet à un animal d'être traité de la maladie
	public void treat(){
		System.out.println("L'animal "+this.getName()+ " à reçu un remède contre la maladie "+ this.desease.getName());
		this.desease.remove(this);
	}
	public void eat() {
		System.out.println(this.getSpecie() + " " + this.getName() + " eats.");
		if(this.indicatorHunger.equals("Normal")) {this.indicatorHunger = "Full";}
		if(this.indicatorHunger.equals("Hungry")) {this.indicatorHunger = "Normal";}
		if(this.indicatorHunger.equals("Famished")) {this.indicatorHunger = "Hungry";}
	}
	
	public void emitSound() {
		
	}
	//fonction qui permet à un animal de se soigner 
	public void heal() {
		this.treat();
		if(this.indicatorHealth.equals("Normal")){this.indicatorHealth="Perfect";}
		if (this.indicatorHealth.equals("Sick")){this.indicatorHealth="Normal";}
		if (this.indicatorHealth.equals("Very Sick")){this.indicatorHealth="Sick";}
		System.out.println("L'animal "+this.getName()+ " à été soigné, son état de santé est maintenant "+ this.indicatorHealth);
	}
	
	public void sleep() {
		
	}
	
	public void wake() {
		
	}
	
	public void getOlder() {
		
	}
	//méthode qui permet de faire en sorte qu'un animal meurt
	public void die() {
		this.enclosure.removeCreature(this);
		this.enclosure = null;
		this.desease = null;
		if(this.desease!=null) {this.desease.setAnimal(null);}
		System.out.println("L'animal "+this.getName()+" est mort !");
		System.gc();
	}


}
