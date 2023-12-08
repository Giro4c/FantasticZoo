package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Colony.AlphaCouple;
import Colony.Colony;
import Colony.Pack;
import Colony.Territory;
import Colony.Utils;
import Colony.Werewolf;
import junit.framework.Assert;

class testWolf {

	@Test
	void test() {
		
	}
	@Test
	void testDomination() {
		Territory ter = new Territory();
		Pack pack = new Pack(ter);
		Werewolf w1 = new Werewolf("Loup garou", "loup homme1", true, 80, 180, 2,
				"Adult", false, 5, 6, 
				'β', 2, 6, null);
		Werewolf w2 = new Werewolf("Loup garou", "loup homme2", true, 90, 190, 2,
				"Adult", false, 8, 7, 
				'γ', 1, 6, null);
		pack.packMemberJoins(w1);
		pack.packMemberJoins(w2);
		w1.dominate(w2);
		assertFalse(Utils.isDominant(w1.getRank(), w2.getRank()));
		assertEquals(w1.getRank(), 'γ');
		assertEquals(w2.getRank(), 'β');
	}
	@Test
	void testReproduction() {
		Territory ter = new Territory();
		Pack pack = new Pack(ter);
		Werewolf w1 = new Werewolf("Loup garou", "loup femme", false, 80, 180, 2,
				"Adult", false, 5, 6, 
				'α', 2, 6, pack);
		Werewolf w2 = new Werewolf("Loup garou", "loup homme", true, 90, 190, 2,
				"Adult", false, 8, 7, 
				'α', 1, 6, pack);
		pack.packMemberJoins(w1);
		pack.packMemberJoins(w2);
		int packSize1 = pack.getMembers().size();
		AlphaCouple couple = new AlphaCouple(w1, w2, w1.getPack());
		couple.reproduce();
		assertTrue(pack.getMembers().size()>packSize1);
		couple.showChildren();
	}

}
