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
		Enclosure enclo = new Enclosure("enlo", 100, 10, "propre");
		Creature c1 = new Creature("un", "animal testAnimalHasdesease", false, 0, 0, 0, "Full", false, "Perfect", enclo);
		Desease maladie = new Desease(1,2,3,c1);
		assertTrue(c1.isSick);
		assertEquals(c1.getDesease(), maladie);
	}	
	@Test
	void testAnimalCanBeTreat() throws InterruptedException {
		Enclosure enclo = new Enclosure("enlo", 100, 10, "propre");
		Creature c3 = new Creature("un", "animal testAnimalCanBeTreat", false, 0, 0, 0, "Full", false, "Perfect", enclo);
		Desease maladie = new Desease(1,2,3,c3);
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
	    assertFalse(c3.isSick);
		assertNotEquals(c3.getDesease(), maladie);
	}
	@Test
	void testAnimalBecomeMoreSick() {
		Enclosure enclo = new Enclosure("enlo", 100, 10, "propre");
		Creature c2 = new Creature("un", "animal testAnimalBecomeMoreSick", false, 0, 0, 0, "Full", false, "Perfect", enclo);
		Desease maladie = new Desease(1,1,2,c2);
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
	@Test 
	void testSeverity3() {
		Enclosure enclo = new Enclosure("enlo", 100, 10, "propre");
		Creature c2 = new Creature("un", "animal testSeverity3", false, 0, 0, 0, "Full", false, "Perfect", enclo);
		Desease maladie = new Desease(1,3,1,c2);
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
	    assertEquals(c2.getIndicatorHealth(), "Dead");
	}
}

