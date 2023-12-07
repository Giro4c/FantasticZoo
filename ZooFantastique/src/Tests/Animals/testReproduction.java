	package Tests.Animals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Zoo.Enclosure;
import Zoo.Animals.Creature;
import Zoo.Animals.Egg;
import Zoo.Animals.Kraken;
import Zoo.Animals.Mammal;
import Zoo.Animals.Nymphe;
import Zoo.Animals.Oviparous;

class testReproduction {
	@Test
	void ajoutMammalApresReproduction() {
	    Enclosure m = new Enclosure("Test mammals enclo", 100, 10, "Clean");
	    Nymphe m1 = new Nymphe("specie1", "m1", false, 30, 20, 8, "Full", false, "Good", 3, 0, m);
        Nymphe m2 = new Nymphe("specie1", "m1", true, 30, 20, 8, "Full", false, "Good", 3, 0, m);
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
		Kraken oviparous1 = new Kraken("kraken", "Oviparous1", true, 50, 30, 5, "Full", false, "Good", o);
		Kraken oviparous2 = new Kraken("kraken", "Oviparous2", false, 45, 28, 4, "Full", false, "Excellent", o);
	    o.reproduction();
	    ArrayList<Egg> eggs = new ArrayList<>();
	    eggs = o.getEggs();
	    Thread incubationThread = null;
	    for (Egg egg : eggs) {
	        Thread thread = egg.getIncubationThread();
	        incubationThread = thread; 
	    }
	    try {
	        if (incubationThread != null) {
	        	incubationThread.join();
	        }
	    } catch (InterruptedException e) {
	    	fail("Bug Thread");
	    }
	    
	    assertEquals(o.getCurrentNumberCreatures(), 3);
	}
	@Test
	void ajoutOeufDansEnclos() {
		Enclosure o = new Enclosure("Test oviparous Enclosure", 100, 10, "Clean");
		Kraken oviparous1 = new Kraken("kraken", "Oviparous1", true, 50, 30, 5, "Full", false, "Good", o);
		Kraken oviparous2 = new Kraken("kraken", "Oviparous2", false, 45, 28, 4, "Full", false, "Excellent", o);
        o.addCreature(oviparous1);
	    o.addCreature(oviparous2);
	    o.reproduction();
	    assertEquals(o.getEggs().size(), 1);
	}
	@Test
	void ajoutDeLaBonneCreatureApresReproduction() {
		Enclosure o = new Enclosure("Test oviparous Enclosure", 100, 10, "Clean");
		Kraken oviparous1 = new Kraken("kraken", "Oviparous1", true, 50, 30, 5, "Full", false, "Good", o);
		Kraken oviparous2 = new Kraken("kraken", "Oviparous2", false, 45, 28, 4, "Full", false, "Excellent", o);
	    o.reproduction();
	    ArrayList<Egg> eggs = new ArrayList<>();
	    eggs = o.getEggs();
	    Thread incubationThread = null;
	    for (Egg egg : eggs) {
	        Thread thread = egg.getIncubationThread();
	        incubationThread = thread; 
	    }
	    try {
	        if (incubationThread != null) {
	        	incubationThread.join();
	        }
	    } catch (InterruptedException e) {
	    	fail("Bug Thread");
	    }
	    ArrayList<Creature> animals = new ArrayList<>();
	    animals = o.getPresentCreatures();
	    for (Creature a : animals) {
	    	assertTrue(a instanceof Oviparous, "Pas un oviparous mais un :  " + a.getClass());
	    }
	}

}
