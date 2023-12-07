package Zoo;

import java.util.ArrayList;
import java.util.Random;

import Zoo.Animals.Creature;
import Zoo.Animals.Egg;
import Zoo.Animals.Mammal;
import Zoo.Animals.Oviparous;

/**
 * Represents an Enclosure for managing and simulating various creatures.
 */
public class Enclosure implements Runnable {

    public static final String[] CLEANNESS_STATES = {"Clean", "Normal", "Dirty", "Moundir's Room"};

    private String name;
    private int surface;
    private final int maxNumberCreatures;
    private int currentNumberCreatures;
    private ArrayList<Creature> presentCreatures;
    private int indexcleanness = 0;
    private String cleanness = CLEANNESS_STATES[indexcleanness];
    private ArrayList<Egg> eggs;

    /**
     * Constructor for the Enclosure class.
     *
     * @param name              The name of the enclosure.
     * @param surface           The surface area of the enclosure.
     * @param maxNumberCreatures The maximum number of creatures the enclosure can hold.
     * @param cleanness         The initial cleanliness state of the enclosure.
     */
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

    /**
     * Thread for enclosures where cleanliness may increase.
     */
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
            if ( RandomNumber < 5) { // 5% chance that the enclosure gets dirty 
                if(this.getIndexcleanness() < CLEANNESS_STATES.length-1) {
                    this.setIndexcleanness(this.getIndexcleanness()+1);
                    System.out.println("The enclosure " + this.getName() + " gets dirty !");
                }
            }
        }
    }

    /**
     * Get the name of the enclosure.
     *
     * @return The name of the enclosure.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the list of eggs in the enclosure.
     *
     * @return The list of eggs in the enclosure.
     */
    public ArrayList<Egg> getEggs() {
        return this.eggs;
    }

    /**
     * Set the name of the enclosure.
     *
     * @param name The new name of the enclosure.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the index of cleanliness of the enclosure.
     *
     * @return The index of cleanliness of the enclosure.
     */
    public int getIndexcleanness() {
        return indexcleanness;
    }

    /**
     * Get the surface area of the enclosure.
     *
     * @return The surface area of the enclosure.
     */
    public int getSurface() {
        return surface;
    }

    /**
     * Set the surface area of the enclosure.
     *
     * @param surface The new surface area of the enclosure.
     */
    public void setSurface(int surface) {
        this.surface = surface;
    }

    /**
     * Get the current number of creatures in the enclosure.
     *
     * @return The current number of creatures in the enclosure.
     */
    public int getCurrentNumberCreatures() {
        return this.presentCreatures.size();
    }

    /**
     * Set the current number of creatures in the enclosure.
     *
     * @param currentNumberCreatures The new current number of creatures in the enclosure.
     */
    public void setCurrentNumberCreatures(int currentNumberCreatures) {
        this.currentNumberCreatures = currentNumberCreatures;
    }

    /**
     * Get the list of present creatures in the enclosure.
     *
     * @return The list of present creatures in the enclosure.
     */
    public ArrayList<Creature> getPresentCreatures() {
        return presentCreatures;
    }

    /**
     * Set the list of present creatures in the enclosure.
     *
     * @param presentCreatures The new list of present creatures in the enclosure.
     */
    public void setPresentCreatures(ArrayList<Creature> presentCreatures) {
        this.presentCreatures = presentCreatures;
    }

    /**
     * Get the cleanliness status of the enclosure.
     *
     * @return The cleanliness status of the enclosure.
     */
    public String getCleanness() {
        return cleanness;
    }

    /**
     * Set the cleanliness status of the enclosure.
     *
     * @param cleanness The new cleanliness status of the enclosure.
     */
    public void setCleanness(String cleanness) {
        this.cleanness = cleanness;
    }

    /**
     * Get the maximum number of creatures the enclosure can hold.
     *
     * @return The maximum number of creatures the enclosure can hold.
     */
    public int getMaxNumberCreatures() {
        return maxNumberCreatures;
    }

    /**
     * Set the index of cleanliness of the enclosure and update the cleanliness status accordingly.
     *
     * @param indexcleanness The new index of cleanliness of the enclosure.
     */
    public void setIndexcleanness(int indexcleanness) {
        this.indexcleanness = indexcleanness;
        this.cleanness = CLEANNESS_STATES[indexcleanness];
    }


    /**
     * Display creatures' characteristics in the enclosure.
     */
    public void showCreaturesCaracteristics() {
        System.out.println("Creatures Characteristics in the " + this.name + " : ");
        for (Creature currentCreature : presentCreatures) {
            System.out.println("Creature Characteristics: " + currentCreature.toString());
        }
    } 

    /**
     * Add a creature to the enclosure.
     *
     * @param newCreature The creature to be added.
     * @return False if creature is null or addition failed. True if success.
     */
    public boolean addCreature(Creature newCreature) {
    	if (checkCompatibilité(newCreature)) {
            if (newCreature == null) return false;
        	if (!presentCreatures.add(newCreature)) return false;
            newCreature.setEnclosure(this);
            ++currentNumberCreatures;
            System.out.println("A new creature " + newCreature.toString() + " was added to " + this.getName());
            return true;
    	}
    	else {
    		return false;
    	}
    
    
    }
    public boolean checkCompatibilité(Creature creature) {
		if ( this.presentCreatures.size() == 0) {
			return true;
		}
		else if ( this.presentCreatures.get(0).getSpecie().equals(creature.getSpecie())){
			return true;
		}
		else {
			return false;
		}    
    }

    /**
     * Remove a creature from the enclosure by searching the object.
     *
     * @param creatureIndex The index of the creature to be removed.
     * @return The creature removed from the zoo. Returns null if there is no creature in the enclosure or the creature is null.
     */
    public Creature removeCreature(int creatureIndex) {
        if (presentCreatures == null || creatureIndex < 0 || !(creatureIndex < this.presentCreatures.size()) ) return null;
        Creature creature = presentCreatures.remove(creatureIndex);
        --currentNumberCreatures;
        if (creature == null) return null;
        creature.setEnclosure(null);
        System.out.println("The " + creature.getSpecie() + " " + creature.getName()+ " was removed from " + this.getName());
        return creature;
        
    }
    
    /**
     * Remove a creature from the enclosure.
     *
     * @param creature The creature to be removed.
     * @return The creature removed from the zoo. Returns null if there is no creature in the enclosure or the creature is null.
     */
    public Creature removeCreature(Creature creature) {
        if (presentCreatures == null || creature == null) return null;
        presentCreatures.remove(creature);
        --currentNumberCreatures;
        creature.setEnclosure(null);
        System.out.println("The " + creature.getSpecie() + " " + creature.getName()+ " was removed from " + this.getName());
        return creature;
        
    }

    public void treatAnimals() {
		for (Creature creature : this.presentCreatures) {
			if(creature.isSick && creature.getDesease().canBeTreatedWithMedecine) {
				creature.treat();
			}
		}
	}
    /**
     * Feed the creatures in the enclosure.
     */
    public void feedCreatures() {
    	for(Creature creature : this.presentCreatures) {
    		creature.eat();
    	}
        System.out.println("The creatures in the " + this.getName() + " were fed.");
    }

    /**
     * Clean the enclosure to maintain hygiene.
     */
    public void clean() {
    	if(this.canBeCleaned()) {
            if(this.cleanness.equals("Normal")) {this.cleanness = "Clean";}
    		if(this.cleanness.equals("Dirty")) {this.cleanness = "Normal";}
    		if(this.cleanness.equals("Moundir's Room")) {this.cleanness = "Dirty";}
    	    System.out.println("The enclosure " + this.getName() + " was cleaned !");	
    	}
    	else {
    		System.out.println("The enclosure " + this.getName() + " cannot be cleaned, there are animals");
    	}
    }


    /**
     * Remove an egg from the enclosure.
     *
     * @param egg The egg to be removed.
     */
    public void removeEgg(Egg egg) {
        eggs.remove(egg);
    }

    /**
     * Handle the reproduction process in the enclosure.
     */
    public void reproduction() {
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
			}
				//Si le nombre de femelles est strictement supérieur à 0
				if (females.size()>0 && theresmale) {
					int randomIndex = rand.nextInt(females.size());
					//On récupère une femelle aléatoire dans la liste
					Creature pregnantFemale = females.get(randomIndex);
					//La femelle choisis aléatoirement devient enceinte
					System.out.println("ouiii");
					if(Oviparous.class.isAssignableFrom(pregnantFemale.getClass())){
						Oviparous female = (Oviparous) pregnantFemale;
						eggs.add(female.layEgg());
					}
					if(Mammal.class.isAssignableFrom(pregnantFemale.getClass())){
						Mammal female = (Mammal) pregnantFemale;
						female.reproduction();
					}
				}
			}
        else {
            System.out.println("Too many animals in the enclosure, reproduction cannot take place!");
        }
    }
	public boolean canBeCleaned() {
		if(this.presentCreatures.isEmpty()) {
			return true;
		}
		else {
			System.out.println("The enclosure " + this.getName() + " cannot be cleaned, there are animals");
			return false;
		}
	}
	public void becomeLessClean() {
		if(this.cleanness.equals("Dirty")) {this.cleanness = "Moundir's Room";}
		if(this.cleanness.equals("Normal")) {this.cleanness = "Dirty";}
		if(this.cleanness.equals("Clean")) {this.cleanness = "Normal";}
	}

	public void checkCompatibilité() {
		// TODO Auto-generated method stub
		
	}
	
	
}
                   

