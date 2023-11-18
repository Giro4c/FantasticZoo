package Zoo;

import java.util.ArrayList;

import Zoo.Animals.Egg;
import Zoo.Animals.Oviparous;

public class Main {
	public static void main(String[] args) {
	    // Create an instance of the Enclosure class
	    Enclosure enclosure = new Enclosure("Test Enclosure", 100, 10, "Clean");

	    // Add instances of the Oviparous class to the enclosure
	    Oviparous oviparous1 = new Oviparous("Species1", "Oviparous1", true, 50, 30, 5, "Full", false, "Good", enclosure);
        Oviparous oviparous2 = new Oviparous("Species2", "Oviparous2", false, 45, 28, 4, "Full", false, "Excellent", enclosure);

	    enclosure.addCreature(oviparous1);
	    enclosure.addCreature(oviparous2);

	    // Call the reproduction function to test it
	    enclosure.reproduction();
	    ArrayList<Egg> eggs = enclosure.getEggs();
	    System.out.println(eggs.size());
	    ArrayList<Egg> eggsToHatch = new ArrayList<>();
	    for(Egg egg : eggs) {
	    	System.out.println(egg.toString());
	    	eggsToHatch.add(egg);
	    }
	    for (Egg egg : eggsToHatch) {
	    	egg.hatch(egg);
	    }
	    

	    // Print the number of creatures after reproduction
	    System.out.println("Number of creatures after reproduction: " + enclosure.getCurrentNumberCreatures());
	}
}
