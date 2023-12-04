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
		Creature c3 = new Creature("un", "animalMalade", false, 0, 0, 0, "Full", false, "Perfect", enclo);
		Desease maladie = new Desease("Covid",1,2,3,c3);
		assertTrue(c3.isSick);
		assertEquals(c3.getDesease(), maladie);
		c3.treat();
		Thread thread = maladie.deseaseThread;
	    try {
	        if (thread != null) {
	        	thread.join();
	        }
	    } catch (InterruptedException e) {
	    	fail("Bug Thread");
	    }
	    System.out.println(c3.isSick);
	    assertFalse(c3.isSick);
		assertNotEquals(c3.getDesease(), maladie);
	}
	@Test
	void testAnimalBecomeMoreSick() {
		Enclosure enclo = new Enclosure("enlo de caca", 100, 10, "propre");
		Creature c2 = new Creature("un", "animalMalade", false, 0, 0, 0, "Full", false, "Perfect", enclo);
		Desease maladie = new Desease("Covid",1,2,1,c2);
		assertTrue(c2.isSick);
		assertEquals(c2.getDesease(), maladie);
		Thread thread = maladie.deseaseThread;
	    try {
	        if (thread != null) {
	        	thread.join();
	        }
	    } catch (InterruptedException e) {
	    	fail("Bug Thread");
	    }
	    assertEquals(c2.getIndicatorHealth(), "Normal");
	}
}

