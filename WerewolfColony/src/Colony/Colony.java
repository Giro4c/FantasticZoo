package Colony;

import java.util.ArrayList;
import java.util.Scanner;

public class Colony {
	
	private ColonyMaster colonymaster;
	private ArrayList<Territory> territories;
	
	public Colony() {
        this.territories = new ArrayList<>();
        this.colonymaster = new ColonyMaster("", false, 0);
    }

	
	public static void main(String[] args) {
		Colony colony = new Colony();
		colony.runColonySimulation();
	}
	
	
	
	public void showAllWerewolves() {
		
	}
	
	/**
	 * Looks into all territories and verifies if the conditions for the creation of a new pack are met :
	 * No pack in the territory but one male and one female lone wolves.
	 * If the conditions are met, create the new pack in the territory.
	 */
	public void canNewPackBeCreated() {
        for (Territory territory : territories) {
        	if (territory.getCurrentPack() == null) 
        		if (territory.getLoners() != null) {
        			Werewolf strongestLonerMale;
        			Werewolf strongestLonerFemale;
        			
        			if (territory.getStrongestLonerMale() == null) {
        				continue; }
        			else {
        			    strongestLonerMale = territory.getStrongestLonerMale(); }
        			
        			if (territory.getStrongestLonerFemale() == null) {
        				continue; }
        			else {
        			strongestLonerFemale = territory.getStrongestLonerFemale(); }
        			
        			AlphaCouple newCouple = new AlphaCouple(strongestLonerMale, strongestLonerFemale, null);
                	Pack newPack = new Pack(newCouple.getCouple(), territory);
                	System.out.println("Une nouvelle meute est née naturellement au : " + territory.getId());
        		       	}
        }
	}
	
	/**
	 * Checks if the mating season has started and starts the reproductions if yes.
	 * @return true if the mating season has started, false otherwise.
	 */
	public static boolean matingSeason() {
		return Utils.isMeating();
	}
	
	/**
	 * Updates the hierarchy of all packs in the Colony.
	 */
	 public void updateAllPackHierarchies() {
	        for (Territory territory : territories) {
	        	if (territory.getCurrentPack() != null)
	        		territory.getCurrentPack().updateHierarchy();
	        }
	    }
	
	/**
	 * Make all werewolves age / grow older.
	 */
	public void ageWerewolves() {
		for (Territory territory : territories) {
			if (territory.getCurrentPack() != null) {
				for (Werewolf wolf : territory.getCurrentPack().getMembers()) {
					wolf.getOlder();
				}
			}
			if (territory.getLoners() != null) {
				for (Werewolf wolf : territory.getLoners()) {
					wolf.getOlder();
				}
			}
		}
	}
	
	
	/**
	 * Check if wolfs are too old and kill the ones too old (after 100year)
	 */
	public void oldAgeDeath() {
	    for (Territory territory : territories) {
	        if (territory.getCurrentPack() != null) {
	            for (Werewolf wolf : territory.getCurrentPack().getMembers()) {
	                if (wolf.getAge() > 100) {
	                    System.out.println(wolf.getName() + " is dead, he was too old");
	                    wolf.die();
	                    territory.removeWolf(wolf);
	                }
	            }
	        }
	        if (territory.getLoners() != null) {
	            for (Werewolf wolf : territory.getLoners()) {
	                if (wolf.getAge() > 100) {
	                    System.out.println(wolf.getName() + " is dead, he was too old");
	                    wolf.die();
	                    territory.removeWolf(wolf);
	                }
	            }
	        }
	    }
	}
	
	/**
	 * Randomly generates howl between werewolves.
	 */
	public void generateRandomHowls() {
		
	}
	
	/**
	 * Transform some werewolves in their human or wolf form.
	 */
	public void transformWerewolves() {
		
	}
	
	public void addTerritory(Territory territory) {
		this.territories.add(territory);
	}
	
	
	

	 public void runColonySimulation() {
		 Scanner scanner = new Scanner(System.in);
		 
		/*.out.println("WELCOME TO YOUR COLONY !");
		 System.out.println("Press Enter to continue...");
		 scanner.nextLine();
		 
		 System.out.println("AT FIRST, CREATE YOUT COLONY MASTER : ");
		 System.out.println("Tape the name of your colony master : ");
		 String name = scanner.nextLine();
		 System.out.println("Now his sex : ");
		 boolean isMale = scanner.nextBoolean();
		 System.out.println("Finally his age : ");
		 int age = scanner.nextInt();
		 
		 this.colonymaster = new ColonyMaster(name, isMale, age);*/
		 Territory cage = new Territory();
		 this.addTerritory(cage);
		 Werewolf wolf1 = new Werewolf(cage);
		 Werewolf wolf2 = new Werewolf(cage);
		 Werewolf wolf3 = new Werewolf(cage);
		 Werewolf wolf4 = new Werewolf(cage);
		 Werewolf wolf5 = new Werewolf(cage);
		 Werewolf wolf6 = new Werewolf(cage);
		 Werewolf wolf7 = new Werewolf(cage);
		 Werewolf wolf8 = new Werewolf(cage);
		 Werewolf wolf9 = new Werewolf(cage);
		 
		 while (true) {
			 
			 
			 
	         // Perform periodic actions
	         /* if (matingSeason()) {
	                generateRandomHowls();
	                updateAllPackHierarchies();
	            }*/

	         //   transformWerewolves();

			 
	         // Check and create new packs
	         canNewPackBeCreated();
	            
	         // launch randoms dominations of a pack
	         for (Territory territory : territories) {
	         	if (territory.getCurrentPack() != null) {
	            	territory.getCurrentPack().launchDominations();
	            }
	            }
	            
	         System.out.println("caca");

	            
	         // Display information
	         // showAllWerewolves();

	         // Pause to simulate time passing (adjust sleep duration as needed)
	         try {
	             Thread.sleep(500);
	         } catch (InterruptedException e) {
	             e.printStackTrace();
	         }
	         
			 // grow older
	         ageWerewolves();
	         //check if too old and kill this ones
	         oldAgeDeath();
	         
	        }
	    


	 }
}
