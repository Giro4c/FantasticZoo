package Zoo;

import java.util.ArrayList;

import Zoo.Animals.Egg;
import Zoo.Animals.Mammal;
import Zoo.Animals.Oviparous;

public class ManualTests {
	public static void main(String[] args) {
	    
	    
	}
	
	private static void testReproduction() {
		Enclosure enclosure = new Enclosure("Test Enclosure", 100, 10, "Clean");
	    Enclosure m = new Enclosure("Test m enclo", 100, 10, "Clean");
	    Oviparous oviparous1 = new Oviparous("Species1", "Oviparous1", true, 50, 30, 5, "Full", false, "Good", enclosure);
        Oviparous oviparous2 = new Oviparous("Species2", "Oviparous2", false, 45, 28, 4, "Full", false, "Excellent", enclosure);

        Mammal m1 = new Mammal("specie1", "m1", false, 30, 20, 8, "Full", false, "Good", 3, 0, m);
        Mammal m2 = new Mammal("specie1", "m1", true, 30, 20, 8, "Full", false, "Good", 3, 0, m);
	    enclosure.addCreature(oviparous1);
	    enclosure.addCreature(oviparous2);
	    m.addCreature(m1);
	    m.addCreature(m2);
	    m.reproduction();
	    enclosure.reproduction();
	    System.out.println("Number of creatures after reproduction: " + enclosure.getCurrentNumberCreatures());
	}
	
	private static void testCloneCreature() {
		// Want to check if the use of Object.clone()
	}
}
