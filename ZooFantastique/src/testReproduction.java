import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Zoo.Enclosure;
import Zoo.Animals.Mammal;
import Zoo.Animals.Oviparous;

class testReproduction {

	@Test
	void test() {
		
	}
	@Test
	void ajoutMammalApresReproduction() {
	    Enclosure m = new Enclosure("Test mammals enclo", 100, 10, "Clean");
        Mammal m1 = new Mammal("specie1", "m1", false, 30, 20, 8, "Full", false, "Good", 3, 0, m);
        Mammal m2 = new Mammal("specie1", "m1", true, 30, 20, 8, "Full", false, "Good", 3, 0, m);
	    m.addCreature(m1);
	    m.addCreature(m2);
	    m.reproduction();
	    Thread reproductionThread = m1.getIncubationThread();
	    try {
	        if (reproductionThread != null) {
	            reproductionThread.join();
	        }
	    } catch (InterruptedException e) {
	    	fail("Bug Thread");
	    }
	    
	    assertEquals(m.getCurrentNumberCreatures(), 3);
	}
	@Test
	void ajoutOviparousApresReproduction() {
		Enclosure o = new Enclosure("Test oviparous Enclosure", 100, 10, "Clean");
		Oviparous oviparous1 = new Oviparous("Species1", "Oviparous1", true, 50, 30, 5, "Full", false, "Good", o);
        Oviparous oviparous2 = new Oviparous("Species2", "Oviparous2", false, 45, 28, 4, "Full", false, "Excellent", o);
        o.addCreature(oviparous1);
	    o.addCreature(oviparous2);
	    o.reproduction();
	    
	    assertEquals(o.getCurrentNumberCreatures(), 3);
	}
	public static void main(String[] args) {
	    ajoutAnimalApresReproduction();
	}

}
