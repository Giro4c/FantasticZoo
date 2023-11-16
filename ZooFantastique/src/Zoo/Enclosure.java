package Zoo;

import java.util.ArrayList;
import Zoo.Animals.Creature;
import Zoo.Animals.Oviparous;

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
		presentCreatures.add(newCreature);
	}
	
	public Creature removeCreature(int indexCreature) {
		
	}
	
	public void feedCreatures() {
		
	}
	
	public void clean() {
		
	}
	public void reproduction(){
		//Vérifie si le nombre de créatures est strictement inférieur au nombre de créatures maximum dans l'enclos.
		if(currentNumberCreatures<maxNumberCreatures){
			bool theresmale = false;
			ArrayList<Creature> females = new ArrayList<>();
			Random rand;
			//On parcours toutes les créatures dans l'enclos
			for (int i = 0; i < currentNumberCreatures; i++) {
				Creature currentCreature = getPresentCreatures().get(i);
				//Si dans les créatures il y a minimum 1 male
				if (currentCreature.isMale()==true) {
					theresmale = true;
				}
				//Met toutes les femelles dans une liste
				if(currentCreature.isMale()==false){
					females.add(currentCreature);

				}
				//Si le nombre de femelles est strictement supérieur à 0
				if (theresfemale.size>0 && theresmale) {
					int randomIndex = random.nextInt(females.size());
					//On récupère une femelle aléatoire dans la liste
					Creature pregnantFemale = females.get(randomIndex);
					//La femelle choisis aléatoirement devient enceinte
					
					if(Oviparous.class.isAssignableFrom(pregnantFemale.class)){
						Oviparous female = (Oviparous) pregnantFemale;
						this.addCreature(female.layEgg());
					}
					if(Mammal.class.isAssignableFrom(pregnantFemale.class)){
						Mammal female = (Mammal) pregnantFemale;
						female.reproduction();
						//On augmente le nombre de créatures dans l'enclos de 1
						++currentNumberCreatures;
					}
					
				}
			}
		}
		else{
			System.out.printerr("Trop d'animaux dans l'enclos, la reproduction ne peut pas avoir lieu !");
		}
	}
}
