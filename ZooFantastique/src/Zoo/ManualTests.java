package Zoo;

import Zoo.Animals.*;

/**
 * A Class for manual tests and experimentations with code that could be useful for developing functionalities or fixing bugs.
 * @author Camille (HorsCo)
 *
 */
public class ManualTests {
	public static void main(String[] args) {
	    
//		testCloneCreature();
//		testThreads();
		testDisableAndReablePrint();
	}
	
	private static void testCloneCreature() {
		// Want to check if the use of Object.clone() keeps the class.
		
		Dragon dragon1 = new Dragon(true, 20, null);
		System.out.println(dragon1.toString());
		System.out.println(dragon1.getClass().getName());
		System.out.println();
		
		System.out.println();
		
		Creature dragon3 = new Dragon(true, 20, null);
		System.out.println(dragon3.toString());
		System.out.println(dragon3.getClass().getName());
		System.out.println();
		
		System.out.println(Dragon.class.getSimpleName());
		
	}
	
	private static void testThreads() {
		Enclosure enclosure = new Enclosure("Test Enclosure", 100, 10, Enclosure.CLEANNESS_STATES[0]);
		Dragon dragon1 = new Dragon(true, 20, enclosure);
		dragon1.startLife();
	}
	
	private static void testDisableAndReablePrint() {
		System.out.println("Before desableling");
		System.out.println("After desableling");
		// Only works on terminal. Does not work on IDE.
		System.out.print("\033[H\033[2J");  
	    System.out.flush();
		System.out.println("After reableling");
	}
}
