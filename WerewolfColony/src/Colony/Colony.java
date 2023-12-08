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
	                if (wolf.getAge() > 100 && wolf.isDead() != true) {
	                    System.out.println(wolf.getName() + " is dead, he was too old");
	                    wolf.die();
	                }
	            }
	        }
	        if (territory.getLoners() != null) {
	            for (Werewolf wolf : territory.getLoners()) {
	                if (wolf.getAge() > 100 && wolf.isDead() != true) {
	                    System.out.println(wolf.getName() + " is dead, he was too old");
	                    wolf.die();
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

        
    	Territory territory = new Territory();
    	this.addTerritory(territory);
    	Territory territory2 = new Territory();
    	this.addTerritory(territory2);
    	Territory territory3 = new Territory();
    	this.addTerritory(territory3);
        
        while (true) {
        	updateAllPackHierarchies();
        	
            // Display main menu
            System.out.println("=========== Main Menu ===========");
            System.out.println("1. Continue");
            System.out.println("2. Stop Simulation");
            System.out.println("3. Show Territories");

            // Prompt user for choice
            System.out.print("Enter the number of your choice: ");
            String choice = scanner.nextLine();

            // Process user choice
            switch (choice) {
            	case "1":
            		System.out.println("what will happen this year...");
            		break;
                case "2":
                    System.out.println("Stopping simulation...");
                    System.exit(0);
                    break;
                case "3":
                    showTerritoriesMenu(scanner);
                    break;
                // Add more cases for additional options

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            canNewPackBeCreated();
            

            // Simulate time passing
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ageWerewolves();
        }
    }

    private void showTerritoriesMenu(Scanner scanner) {
        // Display Territories menu
        System.out.println("=========== Territories ===========");
        for (int i = 0; i < territories.size(); i++) {
            System.out.println((i + 1) + ". " + "Territory " + territories.get(i).getId());
        }
        System.out.println("0. Back to Main Menu");

        // Prompt user for territory choice
        System.out.print("Enter territory number (0 to go back): ");
        int territoryChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (territoryChoice == 0) {
            return;  // Go back to the main menu
        }

        // Process selected territory
        Territory selectedTerritory = territories.get(territoryChoice - 1);

        // Display Territory submenu
        System.out.println("=========== " + selectedTerritory.getId() + " ===========");
        System.out.println("1. Show All Wolves");
        System.out.println("2. Show All Packs");
        // Add more options as needed

        // Prompt user for territory action
        System.out.print("Enter your choice: ");
        String territoryAction = scanner.nextLine();

        // Process user choice for the selected territory
        switch (territoryAction) {
            case "1":
                // Implement logic to show all wolves in the selected territory
                break;
            case "2":
                // Implement logic to show all packs in the selected territory
                break;
            // Add more cases for additional options

            default:
                System.out.println("Invalid choice. Returning to Territories menu.");
        }
    }

    // ... (other methods)
}
