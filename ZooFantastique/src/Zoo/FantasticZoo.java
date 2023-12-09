package Zoo;

import java.util.ArrayList;

import Zoo.Prompts.CommandHandler;
import Zoo.Prompts.Message;
import Zoo.Animals.Creature;

/**
 * The FantasticZoo class represents a zoo with various functionalities,
 * including managing enclosures, creatures, and a zoo master.
 */
public class FantasticZoo {
    
	public static void main(String[] args) {
		GameEngine game = new GameEngine();
		game.init();
		while (true) {
			game.showChoices();
			System.out.println();
			try {
				CommandHandler.executeCommand(Message.registerCommand(4), game);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	// Fields
    
    /**
     * The name of the FantasticZoo.
     */
    private String name;
    
    /**
     * The zoo master responsible for managing the FantasticZoo.
     */
    private ZooMaster zooMaster;
    
    /**
     * The maximum number of enclosures allowed in the FantasticZoo.
     */
    private final int maxNumberEnclosures;
    
    /**
     * List of existing enclosures in the FantasticZoo.
     */
    private ArrayList<Enclosure> existingEnclosures;

    // Constructors
    
    /**
     * Constructs a new FantasticZoo with the specified name, zoo master, and maximum number of enclosures.
     * 
     * @param name                The name of the FantasticZoo.
     * @param zooMaster           The zoo master managing the zoo.
     * @param maxNumberEnclosures The maximum number of enclosures allowed in the zoo.
     */
    public FantasticZoo(String name, ZooMaster zooMaster, int maxNumberEnclosures) {
        this.name = name;
        this.zooMaster = zooMaster;
        this.maxNumberEnclosures = maxNumberEnclosures;
        this.existingEnclosures = new ArrayList<Enclosure>();
    }
    
    @Override
	public String toString() {
		return	"The FantasticZoo is named: " + name + ", the zooMaster is " + zooMaster.getName() + ", the maximum number of enclosures is " + 
	maxNumberEnclosures + ", and the existing enclosures are: " + existingEnclosures;
	}

    // Accessor Methods
    
    /**
     * Gets the name of the FantasticZoo.
     * 
     * @return The name of the FantasticZoo.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the FantasticZoo.
     * 
     * @param name The new name for the FantasticZoo.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the zoo master of the FantasticZoo.
     * 
     * @return The zoo master of the FantasticZoo.
     */
    public ZooMaster getZooMaster() {
        return zooMaster;
    }

    /**
     * Sets the zoo master of the FantasticZoo.
     * 
     * @param zooMaster The new zoo master for the FantasticZoo.
     */
    public void setZooMaster(ZooMaster zooMaster) {
        this.zooMaster = zooMaster;
    }

    /**
     * Gets the maximum number of enclosures allowed in the FantasticZoo.
     * 
     * @return The maximum number of enclosures allowed in the FantasticZoo.
     */
    public int getMaxNumberEnclosures() {
        return maxNumberEnclosures;
    }

    /**
     * Gets the list of existing enclosures in the FantasticZoo.
     * 
     * @return The list of existing enclosures.
     */
    public ArrayList<Enclosure> getExistingEnclosures() {
        return existingEnclosures;
    }
    
    /**
     * Counts the creatures in the zoo.
     * @return the number of creatures in the zoo
     */
    public int countCreatures() {
		int NumberAnimals = 0; 
		for (Enclosure enclo : existingEnclosures) {
			NumberAnimals += enclo.getCurrentNumberCreatures();
		}
		return NumberAnimals;
	}

    /**
     * Displays the total number of creatures in the FantasticZoo.
     */	
    public void showTotalCreatures() {
		System.out.println("In the FantasticZoo " + this.getName() + " there is " + this.countCreatures() + " creature");
	} 
	
    /**
     * Displays attributes of all creatures present in the FantasticZoo.
     */
	public void showAllCreatures(){
		System.out.println("All creatures atributes :");
		for (Enclosure enclo : existingEnclosures) {
			for (Creature creature : enclo.getPresentCreatures()) {
				System.out.println('\t' + creature.toString());
			}
		}
	}
	
    /**
     * Adds a new enclosure to the FantasticZoo if the maximum limit is not reached.
     * 
     * @param newEnclosure The new enclosure to be added.
     */
	public void addNewEnclosure(Enclosure newEnclosure) {
		if ( existingEnclosures.size() < this.getMaxNumberEnclosures()) {
			this.existingEnclosures.add(newEnclosure);
			System.out.println("The new " + newEnclosure.getClass().getSimpleName() + " " + newEnclosure.getName() + " was added in the FantasticZoo");
		}
		else {
			System.out.println("The maximum number of enclosures has already been reached"); 
		}
	}
	
    /**
     * Removes an enclosure from the FantasticZoo based on its index, if it is empty.
     * 
     * @param oldEnclosureIndex The index of the enclosure to be removed.
     */
	public void removeEnclosure(int oldEnclosureIndex) {
		Enclosure oldEnclosure = existingEnclosures.get(oldEnclosureIndex);
		if ( oldEnclosure.getCurrentNumberCreatures() == 0) {
			existingEnclosures.remove(oldEnclosure);
			System.out.println("The " + oldEnclosure.getClass().getSimpleName() + " " + oldEnclosure.getName() + " was removed from the FantasticZoo");
			System.gc();
		}
		else {
			System.out.println("The " + oldEnclosure.getClass().getSimpleName() + " " + oldEnclosure.getName() + " cannot be removed, creature still live in !");
		}	
    }
	
    /**
     * Removes an enclosure from the FantasticZoo if it is empty or explicitly specified,
     * otherwise, displays a message indicating that creatures are still present.
     * 
     * @param oldEnclosure The enclosure to be removed.
     */
	public void removeEnclosure(Enclosure oldEnclosure) {
		if (oldEnclosure.getCurrentNumberCreatures() != 0 && ! this.existingEnclosures.remove(oldEnclosure)) {
			System.out.println("The " + oldEnclosure.getClass().getSimpleName() + " " + oldEnclosure.getName() + " was removed from the FantasticZoo");
			oldEnclosure.delete();
			System.gc();
		}
		else {
			System.out.println("The enclosure " + oldEnclosure.getName() + " cannot bed remove, creature still live in !");
		}
	}
	
	/* ------------------------------------------------- */
	

}
