package Colony;

import java.util.ArrayList;

public class Colony {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private ArrayList<Territory> territories;
	
	public void showAllWerewolves() {
		
	}
	
	/**
	 * Looks into all territories and verifies if the conditions for the creation of a new pack are met :
	 * No pack in the territory but one male and one female lone wolves.
	 * If the conditions are met, create the new pack in the territory.
	 * @return true if a new pack can be created (and has been). False if no new pack can be created.
	 */
	public boolean canNewPackBeCreated() {
		// A IMPLEMENTER
		return false;
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
		
	}
	
	/**
	 * Make all werewolves age / grow older.
	 */
	public void ageWerewolves() {
		
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
	

}
