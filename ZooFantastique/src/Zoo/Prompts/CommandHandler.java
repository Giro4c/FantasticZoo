package Zoo.Prompts;

import Zoo.GameEngine;

public class CommandHandler {
	
	/**
	 * Determines which action to execute outside of a fight depending on the command input
	 * @param command the String array which contains the command entered by the player
	 * @param gameEngine the GameEngine object which contains all entities and necessary parameters for the game
	 * @throws Exception
	 */
	public static boolean executeCommand(String[] command, GameEngine gameEngine) throws Exception {
		
		if (gameEngine.getSituationIndicator() == 1) {
			
		}
		else if (gameEngine.getSituationIndicator() == 2) {
			
		}
		else if (gameEngine.getSituationIndicator() == 3) {
			
		}
		else if (gameEngine.getSituationIndicator() == 4) {
			
		}
		else if (gameEngine.getSituationIndicator() == 5) {
			
		}
		else if (gameEngine.getSituationIndicator() == 6) {
			
		}
		
		else {
			Message.notRecognized();
		}
		
		
		return true;
	}
	
	private static boolean executeCommandZoo(String[] command, GameEngine gameEngine) throws Exception {
		if (command.length == 0) {
			throw new Exception(Message.notRecognized());
		}
		return true;
	}
	
	private static boolean executeCommandEnclosure(String[] command, GameEngine gameEngine) {
		
		return true;
	}
	private static boolean executeCommandTransfert(String[] command, GameEngine gameEngine) {
		
		return true;
	}
	private static boolean executeCommandRemove(String[] command, GameEngine gameEngine) {
		
		return true;
	}
	private static boolean executeCommandHeal(String[] command, GameEngine gameEngine) {
		
		return true;
	}
	
	
}
