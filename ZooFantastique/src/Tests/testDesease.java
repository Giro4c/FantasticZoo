package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Zoo.Desease;
import Zoo.Enclosure;
import Zoo.Animals.Creature;

class testDesease {

	@Test
	void test() {
		
	}
	@Test
	void testAnimalHasdesease() {
		Enclosure enclo = new Enclosure("enlo de caca", 100, 10, "propre");
		Creature c1 = new Creature("un", "animalMalade", false, 0, 0, 0, "Full", false, "Perfect", enclo);
		Desease maladie = new Desease("Covid",1,2,3,c1);
		assertTrue(c1.isSick);
		assertEquals(c1.getDesease(), maladie);
	}	
	@Test
	void testAnimalCanBeTreat() throws InterruptedException {
		Enclosure enclo = new Enclosure("enlo de caca", 100, 10, "propre");
		Creature c1 = new Creature("un", "animalMalade", false, 0, 0, 0, "Full", false, "Perfect", enclo);
		Desease maladie = new Desease("Covid",1,2,3,c1);
		assertTrue(c1.isSick);
		assertEquals(c1.getDesease(), maladie);
		c1.treat();
		Thread thread = maladie.deseaseThread;
	    try {
	        if (thread != null) {
	        	thread.join();
	        }
	    } catch (InterruptedException e) {
	    	fail("Bug Thread");
	    }		
	}
}

