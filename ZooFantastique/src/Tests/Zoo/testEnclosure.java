package Tests.Zoo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Zoo.Desease;
import Zoo.Enclosure;
import Zoo.Animals.Creature;
import Zoo.Animals.Dragon;

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
		Dragon dragon1 = new Dragon("test", "test", false, 10, 10, 10, "test", false, "test", enclosure);
		Dragon dragon2 = new Dragon("test", "test", false, 10, 10, 10, "test", false, "test", enclosure);
		presentCreatures.add(dragon1);
		presentCreatures.add(dragon2);
		enclosure.setPresentCreatures(presentCreatures);
		assertEquals(enclosure.getPresentCreatures(),presentCreatures);
	}
		
	@Test
	void testsetCurrentNumberCreatures() {
		Enclosure enclosure = new Enclosure("enclo test 1", 100, 10, "Dirty");
		ArrayList<Creature> presentCreatures = new ArrayList<Creature>();
		Dragon dragon1 = new Dragon("test", "test", false, 10, 10, 10, "test", false, "test", enclosure);
		Dragon dragon2 = new Dragon("test", "test", false, 10, 10, 10, "test", false, "test", enclosure);
		presentCreatures.add(dragon1);
		presentCreatures.add(dragon2);
		enclosure.setPresentCreatures(presentCreatures);
		assertEquals(enclosure.getCurrentNumberCreatures(),2);
	}
	
	@Test
	void becomeMoreClean() {
		Enclosure enclosure = new Enclosure("enclo test 1", 100, 10, "Dirty");
		enclosure.clean();
		assertEquals(enclosure.getCleanness(), "Normal");
	}
	@Test
	void becomeMoreDirty() {
		Enclosure enclosure = new Enclosure("enclo test 1", 100, 10, "Normal");
		enclosure.becomeLessClean();
		assertEquals(enclosure.getCleanness(), "Dirty");
	}
	@Test
	void feedingAnimals() {
		Enclosure enclosure = new Enclosure("enclo test 1", 100, 10, "Normal");
		Creature c3 = new Creature("shiny", "animal feedingAnimals", false, 0, 0, 0, "Normal", false, "Perfect", enclosure);
		enclosure.feedCreatures();
		assertEquals(c3.getIndicatorHunger(), "Full");
	}
	@Test
	void treatAnimals() {
		Enclosure enclosure = new Enclosure("enclo test 1", 100, 10, "Normal");
		Creature c4 = new Creature("shiny", "animal treatAnimals", false, 0, 0, 0, "Normal", false, "Perfect", enclosure);
		Creature c5 = new Creature("animal iii", "animal treatAnimals", false, 0, 0, 0, "Normal", false, "Perfect", enclosure);
		Desease maladie = new Desease(1,2,3,c4);
		Desease maladie2 = new Desease(1,2,3,c5);
		assertTrue(c4.isSick);
		assertTrue(c5.isSick);
		enclosure.treatAnimals();
		assertFalse(c4.isSick);
		assertFalse(c5.isSick);
	}
	
	
	
}
