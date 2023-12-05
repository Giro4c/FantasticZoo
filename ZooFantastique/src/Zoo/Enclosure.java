package Zoo;

import java.util.ArrayList;
import java.util.Random;

import Zoo.Animals.Creature;
import Zoo.Animals.Egg;
import Zoo.Animals.Mammal;
import Zoo.Animals.Oviparous;

public class Enclosure {
	public static final String[] CLEANNESS_STATES = {"Clean", "Normal", "Dirty", "Moundir's Room"};
	
	private String name;
	private int surface;
	private final int maxNumberCreatures;
	private int currentNumberCreatures;
	private ArrayList<Creature> presentCreatures;
	private String cleanness;
	private ArrayList<Egg> eggs;
	public Enclosure(String name, int surface, int maxNumberCreatures, String cleanness) {
		super();
		this.name = name;
		this.surface = surface;
		this.maxNumberCreatures = maxNumberCreatures;
		this.cleanness = cleanness;
		this.presentCreatures = new ArrayList<Creature>();
		this.currentNumberCreatures = this.presentCreatures.size();
		this.eggs = new ArrayList<Egg>();
	}
	
	

	public String getName() {
		return name;
	}

	public ArrayList<Egg> getEggs(){
		return this.eggs;
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
		return this.presentCreatures.size();
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
	
	public void addCreature(Creature c) {
		presentCreatures.add(c);
		c.setEnclosure(this);
		++currentNumberCreatures;
	}
	
	public void removeCreature(Creature creature) {
	    if (presentCreatures != null) {
	        presentCreatures.remove(creature);
	    }
	}
	
	public void feedCreatures() {
		for( Creature creature : this.presentCreatures) {
			creature.eat();
		}
	}
	public void becomeLessClean() {
		if(this.cleanness.equals("Dirty")) {this.cleanness = "Moundir's Room";}
		if(this.cleanness.equals("Normal")) {this.cleanness = "Dirty";}
		if(this.cleanness.equals("Clean")) {this.cleanness = "Normal";}
	}
	
	public void clean() {
		if(this.cleanness.equals("Normal")) {this.cleanness = "Clean";}
		if(this.cleanness.equals("Dirty")) {this.cleanness = "Normal";}
		if(this.cleanness.equals("Moundir's Room")) {this.cleanness = "Dirty";}
	}
	public void removeEgg(Egg egg) {
		eggs.remove(egg);
	}
	public void reproduction(){
		//Vérifie si le nombre de créatures est strictement inférieur au nombre de créatures maximum dans l'enclos.
		if(currentNumberCreatures<maxNumberCreatures){
			Boolean theresmale = false;
			ArrayList<Creature> females = new ArrayList<>();
			Random rand = new Random();
			//On parcours toutes les créatures dans l'enclos
			for (Creature currentCreature : presentCreatures) {
				//Si dans les créatures il y a minimum 1 male
				if (currentCreature.isMale()==true) {
					theresmale = true;
				}
				//Met toutes les femelles dans une liste
				if(currentCreature.isMale()==false){
					females.add(currentCreature);

				}
				//Si le nombre de femelles est strictement supérieur à 0
				if (females.size()>0 && theresmale) {
					int randomIndex = rand.nextInt(females.size());
					//On récupère une femelle aléatoire dans la liste
					Creature pregnantFemale = females.get(randomIndex);
					//La femelle choisis aléatoirement devient enceinte
					
					if(Oviparous.class.isAssignableFrom(pregnantFemale.getClass())){
						Oviparous female = (Oviparous) pregnantFemale;
						eggs.add(female.layEgg());
						++currentNumberCreatures;
					}
					if(Mammal.class.isAssignableFrom(pregnantFemale.getClass())){
						Mammal female = (Mammal) pregnantFemale;
						female.reproduction();
						//On augmente le nombre de créatures dans l'enclos de 1
						++currentNumberCreatures;
					}
				}
			}
		}
		else{
			System.out.println("Trop d'animaux dans l'enclos, la reproduction ne peut pas avoir lieu !");
		}
	}
}
