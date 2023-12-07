package Tests.Zoo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Zoo.Desease;
import Zoo.Enclosure;
import Zoo.Animals.Creature;
import Zoo.Animals.Dragon;
import Zoo.Animals.Kraken;
import Zoo.Animals.Licorne;

class testEnclosure {
	
	@Test
	void testconstruct(){
		Enclosure enclosure = new Enclosure("enclo test 1", 100, 10, "Dirty");
		assertNotNull(enclosure);
	}
	
	@Test
	void testSetName() {
		Enclosure enclosure = new Enclosure("enclo test 1", 100, 10, "Dirty");
		String newName = "enclo test 2";
		enclosure.setName(newName);
		assertEquals(enclosure.getName(),newName);
    }

	@Test
	void testsetSurface() {
		Enclosure enclosure = new Enclosure("enclo test 1", 100, 10, "Dirty");
		int newSuperficie = 110;
		enclosure.setSurface(newSuperficie);
		assertEquals(enclosure.getSurface(),newSuperficie);
	}
	@Test
	void testsetPresentCreatures( ) {
		Enclosure enclosure = new Enclosure("enclo test 1", 100, 10, "Dirty");
		ArrayList<Creature> presentCreatures = new ArrayList<Creature>();
		Dragon dragon1 = new Dragon(false, 10, enclosure);
		Dragon dragon2 = new Dragon(false, 10, enclosure);
		presentCreatures.add(dragon1);
		presentCreatures.add(dragon2);
		enclosure.setPresentCreatures(presentCreatures);
		assertEquals(enclosure.getPresentCreatures(),presentCreatures);
	}
		
	@Test
	void testsetCurrentNumberCreatures() {
		Enclosure enclosure = new Enclosure("enclo test 1", 100, 10, "Dirty");
		ArrayList<Creature> presentCreatures = new ArrayList<Creature>();
		Dragon dragon1 = new Dragon(false, 10, enclosure);
		Dragon dragon2 = new Dragon(false, 10, enclosure);
		presentCreatures.add(dragon1);
		presentCreatures.add(dragon2);
		enclosure.setPresentCreatures(presentCreatures);
		assertEquals(enclosure.getCurrentNumberCreatures(),2);
	}
	
	@Test
	void testsetCleanness() {
		Enclosure enclosure = new Enclosure("enclo test 1", 100, 10, "Dirty");
		enclosure.setCleanness("Clean");
		assertEquals(enclosure.getCleanness(),"Clean");
	}
	
	@Test
	void testsetIndexcleanness() {
		Enclosure enclosure = new Enclosure("enclo test 1", 100, 10, "Dirty");
		enclosure.setIndexcleanness(0);
		assertEquals(enclosure.getCleanness(),"Clean");
		
	}
	@Test
	void testaddCreature() {
		Enclosure enclosure = new Enclosure("enclo test 1", 100, 10, "Dirty");
		Dragon dragon1 = new Dragon(false, 10, enclosure);
		Dragon dragon2 = new Dragon(false, 10, enclosure);
		Dragon dragon3 = new Dragon(false, 10, enclosure);
		
		assert(enclosure.addCreature(dragon1));
		enclosure.addCreature(dragon1);
		assert(enclosure.addCreature(dragon2));
		enclosure.addCreature(dragon2);
		assert((enclosure.addCreature(dragon3)));
		enclosure.addCreature(dragon3);
	}
	
	

	void becomeMoreClean() {
		Enclosure enclosure = new Enclosure("enclo test 1", 100, 10, "Dirty");
		enclosure.clean();
		assertEquals(enclosure.getCleanness(), "Normal");
	}
	
	void becomeMoreDirty() {
		Enclosure enclosure = new Enclosure("enclo test 1", 100, 10, "Normal");
		enclosure.becomeLessClean();
		assertEquals(enclosure.getCleanness(), "Dirty");
	}
	void feedingAnimals() {
		Enclosure enclosure = new Enclosure("enclo test 1", 100, 10, "Normal");
		Licorne c3 = new Licorne(false, 0, enclosure);
		enclosure.feedCreatures();
		assertEquals(c3.getIndicatorHunger(), "Full");
	}
	
	void treatAnimals() {
		Enclosure enclosure = new Enclosure("enclo test 1", 100, 10, "Normal");
		Kraken c4 = new Kraken(false, 0, enclosure);
		Kraken c5 = new Kraken(false, 0, enclosure);
		Desease maladie = new Desease(1,2,3,c4);
		Desease maladie2 = new Desease(1,2,3,c5);
		System.out.println(c4.toString());
		System.out.println(c5.toString());
		assertTrue(c4.isSick);
		assertTrue(c5.isSick);
		enclosure.treatAnimals();
		assertFalse(c4.isSick);
		assertFalse(c5.isSick);
	}
	
	
	
}
