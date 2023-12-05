package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Zoo.Enclosure;
import Zoo.Animals.Creature;

class testEnclosure {

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

}
