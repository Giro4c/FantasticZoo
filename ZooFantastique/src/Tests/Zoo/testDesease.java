package Tests.Zoo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Zoo.Desease;
import Zoo.Enclosure;
import Zoo.Animals.Creature;
import Zoo.Animals.Dragon;
import Zoo.Animals.Kraken;
import Zoo.Animals.Nymphe;
import Zoo.Animals.Sirene;

class testDesease {

	@Test
	void test() {
		
	}
	@Test
	void testAnimalHasdesease() {
		Enclosure enclo = new Enclosure("enlo", 100, 10, "propre");
		Kraken c1 = new Kraken(false, 2, enclo);
		Desease maladie = new Desease(1,2,3,c1);
		assertTrue(c1.isSick);
		assertEquals(c1.getDesease(), maladie);
	}	
	@Test
	void testAnimalCanBeTreat() throws InterruptedException {
		Enclosure enclo = new Enclosure("enlo", 100, 10, "propre");
		Nymphe c3 = new Nymphe(false, 3, enclo);
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
		Sirene c2 = new Sirene(false, 2, enclo);
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
		Dragon c2 = new Dragon(false, 2, enclo);
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

