	package Tests.Animals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Zoo.Enclosure;
import Zoo.Animals.Creature;
import Zoo.Animals.Egg;
import Zoo.Animals.Kraken;
import Zoo.Animals.Mammal;
import Zoo.Animals.Nymph;
import Zoo.Animals.Oviparous;

class testReproduction {
	
	@Test
	void testAjoutMammalApresReproduction() {
	    Enclosure m = new Enclosure("Test mammals enclo", 100, 10, "Clean");
	    Nymph m1 = new Nymph(false, 30, m);
        Nymph m2 = new Nymph(true, 30, m);
        m.addCreature(m2);
        m.addCreature(m1);
	    m.reproduction();
	    Thread reproductionThread = m1.getIncubationThread();
	    try {
	        if (reproductionThread != null) {
	            reproductionThread.join();
	        }
	    } catch (InterruptedException e) {
	    	fail("Bug Thread");
	    }
	    for(Creature creature : m.getPresentCreatures() ) {
	    	assertEquals(creature.getClass(), m1.getClass());
	    }
	    assertEquals(m.getCurrentNumberCreatures(), 3);
	}
	
	@Test
	void testAjoutOviparousApresReproduction() {
		Enclosure o = new Enclosure("Test oviparous Enclosure", 100, 10, "Clean");
		Kraken oviparous1 = new Kraken(true, 50, o);
		Kraken oviparous2 = new Kraken(false, 45, o);
		System.out.println("iiiiii");
		o.addCreature(oviparous2);
		o.addCreature(oviparous1);
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

	    for(Creature creature : o.getPresentCreatures() ) {
	    	assertEquals(creature.getClass(), oviparous1.getClass());
	    }
	    assertEquals(o.getCurrentNumberCreatures(), 3);
	}
	
	@Test
	void testAjoutOeufDansEnclos() {
		Enclosure o = new Enclosure("Test oviparous Enclosure", 100, 10, "Clean");
		Kraken oviparous1 = new Kraken(true, 50, o);
		Kraken oviparous2 = new Kraken(false, 45, 28, 4, o);
        o.addCreature(oviparous1);
	    o.addCreature(oviparous2);
	    o.reproduction();
	    assertEquals(o.getEggs().size(), 1);
	}
	@Test
	void testAjoutDeLaBonneCreatureApresReproduction() {
		Enclosure o = new Enclosure("Test oviparous Enclosure", 100, 10, "Clean");
		Kraken oviparous1 = new Kraken(true, 50, o);
		Kraken oviparous2 = new Kraken(false, 45, o);
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
