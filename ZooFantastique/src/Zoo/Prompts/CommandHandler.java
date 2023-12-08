package Zoo.Prompts;

import java.util.Scanner;

import Zoo.Aquarium;
import Zoo.Aviary;
import Zoo.Enclosure;
import Zoo.GameEngine;
import Zoo.Animals.Creature;

public class CommandHandler {
	
	/**
	 * Determines which action to execute outside of a fight depending on the command input
	 * @param command the String array which contains the command entered by the player
	 * @param gameEngine the GameEngine object which contains all entities and necessary parameters for the game
	 * @throws Exception
	 */
	public static boolean executeCommand(String[] command, GameEngine gameEngine) throws Exception {
		
		if (gameEngine.getSituationIndicator() == 1) {
			return executeCommandZoo(command, gameEngine);
		}
		else if (gameEngine.getSituationIndicator() == 2) {
			return executeCommandEnclosure(command, gameEngine);
		}
		
		throw new Exception("Unknown situation");
	}
	
	private static boolean executeCommandZoo(String[] command, GameEngine gameEngine) throws Exception {

		if (command.length == 2) {
			if (command[0].toLowerCase().equals("new")) {
				if(command[1].toLowerCase().equals(Enclosure.class.getSimpleName().toLowerCase()) 
						|| command[1].toLowerCase().equals(Aquarium.class.getSimpleName().toLowerCase()) 
						|| command[1].toLowerCase().equals(Aviary.class.getSimpleName().toLowerCase())) {
					return handleNewEnclosure(gameEngine, command[1].toLowerCase());					
				}
				else throw new Exception(Message.notExists("New element type"));
			}
			else throw new Exception(Message.notSpecified("New element type"));
		}
		
		else if (command.length == 3) {
			if (command[0].toLowerCase().equals("show") && command[1].toLowerCase().equals("info")) {
				if (command[2].toLowerCase().equals("zoo")) {
					System.out.println(gameEngine.getZoo().toString());
					return true;
				}
				else if (command[2].toLowerCase().equals("zoomaster")) {
					System.out.println(gameEngine.getZoo().getZooMaster().toString());
					return true;
				}
			}
		}
		
		else if (command.length == 4) {
			if (command[0].toLowerCase().equals("go") && command[1].toLowerCase().equals("to") && command[2].toLowerCase().equals("enclosure")) {
				for (Enclosure enclosure : gameEngine.getZoo().getExistingEnclosures()) {
					if (command[3].equals(enclosure.getName())) {
						gameEngine.setCurrentEnclosure(enclosure);
						gameEngine.setSituationIndicator(2);
						return true;
					}
				}
				throw new Exception(Message.notExists("The enclosure " + command[3]));
			}
		}
		throw new Exception(Message.notRecognized());
	}
	
	private static boolean executeCommandEnclosure(String[] command, GameEngine gameEngine) throws Exception {
		
		if (command.length == 1) {
			if (command[0].toLowerCase().equals("feed")) {
				gameEngine.getZoo().getZooMaster().feedCreaturesInEnclosure(gameEngine.getCurrentEnclosure());
				return true;
			}
			else if (command[0].toLowerCase().equals("heal")) {
				return handleHeal(gameEngine);
			}
			else if (command[0].toLowerCase().equals("leave")) {
				gameEngine.setSituationIndicator(1);
				gameEngine.setCurrentEnclosure(null);
				return true;
			}
		}
		
		else if (command.length == 2) {
			if (command[0].toLowerCase().equals("examine") && command[1].toLowerCase().equals("enclosure")) {
				gameEngine.getZoo().getZooMaster().examineEnclosure(gameEngine.getCurrentEnclosure());
				return true;
			}
			else if (command[0].toLowerCase().equals("transfer") && command[1].toLowerCase().equals("creature")) {
				return handleTransfert(gameEngine);
			}
			else if (command[0].toLowerCase().equals("remove") && command[1].toLowerCase().equals("creature")) {
				return handleRemove(gameEngine);
			}
			else if (command[0].toLowerCase().equals("clean") && command[1].toLowerCase().equals("enclosure")) {
				gameEngine.getZoo().getZooMaster().cleanEnclosure(gameEngine.getCurrentEnclosure());
				return true;
			}
		}
		
		else if (command.length == 3) {
			if (command[0].toLowerCase().equals("show")) {
				if (command[1].toLowerCase().equals("info") && command[2].toLowerCase().equals("zoomaster")) {
					System.out.println(gameEngine.getZoo().getZooMaster().toString());
					return true;
				}
				else if (command[1].toLowerCase().equals("enclosure") && command[2].toLowerCase().equals("details")) {
					System.out.println(gameEngine.getCurrentEnclosure().toString());
					return true;
				}
			}
		}
		// No valid command detected
		throw new Exception(Message.notRecognized());
		
	}
	
	
	private static boolean handleTransfert(GameEngine gameEngine) {
		gameEngine.setSituationIndicator(3);
		Scanner in = new Scanner(System.in);
		// Necessary variables to memorize
		int transfertCreatureIndex = 0;
		int transfertEnclosureIndex = 0;
		
		
		
		// Handle first command --> Creature selection
		String singleCommand = "";
		boolean validCommand = false;
		while(true) {
			System.out.println(gameEngine.getPromptGenerator().getChoicePrompt(gameEngine));
			singleCommand = in.nextLine();
			if (singleCommand.toLowerCase().equals("cancel")) {
				gameEngine.setSituationIndicator(2);
				return false;
			}
			for (int indexC = 0 ; indexC < gameEngine.getCurrentEnclosure().getPresentCreatures().size() ; ++indexC) {
				if (singleCommand.equals(gameEngine.getCurrentEnclosure().getPresentCreatures().get(indexC).getName())) {
					transfertCreatureIndex = indexC;
					validCommand = true;
					break;
				}
			}
			if (!validCommand) {
				System.out.println(Message.incorrectEntry());
			}
			else {
				gameEngine.setSubSituationIndicator(gameEngine.getSubSituationIndicator() + 1);
				break;
			}
		}
		
		// Handle second command --> Enclosure selection
//		singleCommand = "";
		validCommand = false;
		while(true) {
			System.out.println(gameEngine.getPromptGenerator().getChoicePrompt(gameEngine));
			singleCommand = in.nextLine();
			if (singleCommand.toLowerCase().equals("cancel")) {
				gameEngine.setSituationIndicator(2);
				return false;
			}
			for (int indexE = 0 ; indexE < gameEngine.getZoo().getExistingEnclosures().size() ; ++indexE) {
				if (singleCommand.equals(gameEngine.getZoo().getExistingEnclosures().get(indexE).getName())) {
					if (!gameEngine.getZoo().getExistingEnclosures().get(indexE).checkCompatibility(gameEngine.getCurrentEnclosure().getPresentCreatures().get(transfertCreatureIndex))) {
						System.out.println("Creature not compatible with this enclosure");
					}
					else {
						transfertEnclosureIndex = indexE;
						validCommand = true;
					}
					break;
				}
			}
			if (!validCommand) {
				System.out.println(Message.incorrectEntry());
			}
			else {
				gameEngine.setSubSituationIndicator(gameEngine.getSubSituationIndicator() + 1);
				break;
			}
		}
		
		// Execute transfer
		gameEngine.getZoo().getZooMaster().tranfertCreature(gameEngine.getCurrentEnclosure(), transfertCreatureIndex, gameEngine.getZoo().getExistingEnclosures().get(transfertEnclosureIndex));
//		gameEngine.getZoo().getExistingEnclosures().get(transfertEnclosureIndex).addCreature(gameEngine.getCurrentEnclosure().removeCreature(transfertCreatureIndex));
		gameEngine.setSituationIndicator(2);
		
		return true;
	}
	
	
	private static boolean handleRemove(GameEngine gameEngine) {
		gameEngine.setSituationIndicator(4);
		Scanner in = new Scanner(System.in);
		
		// Handle first command --> Creature selection
		String singleCommand = "";
		boolean invalidCommand = true;
		while(true) {
			System.out.println(gameEngine.getPromptGenerator().getChoicePrompt(gameEngine));
			singleCommand = in.nextLine();
			if (singleCommand.toLowerCase().equals("cancel")) {
				gameEngine.setSituationIndicator(2);
				return false;
			}
			for (int indexC = 0 ; indexC < gameEngine.getCurrentEnclosure().getPresentCreatures().size() ; ++indexC) {
				if (singleCommand.equals(gameEngine.getCurrentEnclosure().getPresentCreatures().get(indexC).getName())) {
					gameEngine.setSubSituationIndicator(gameEngine.getSubSituationIndicator() + 1);
					System.out.println(gameEngine.getPromptGenerator().getChoicePrompt(gameEngine));
					
					// Handle second command --> validation selection
					singleCommand = in.nextLine();
					if (singleCommand.toLowerCase().equals("yes") || singleCommand.toLowerCase().equals("y")) {
						gameEngine.getCurrentEnclosure().removeCreature(indexC).delete();;
						gameEngine.setSituationIndicator(2);
						return true;
					}
					else {
						gameEngine.setSubSituationIndicator(gameEngine.getSubSituationIndicator() - 1);
						invalidCommand = false;
						break;
					}
				}
			}
			if (invalidCommand) {
				System.out.println(Message.incorrectEntry());
			}
			
		}
		
	}
	private static boolean handleHeal(GameEngine gameEngine) {
		gameEngine.setSituationIndicator(5);
		Scanner in = new Scanner(System.in);
		
		// Handle first command --> Creature selection
		String singleCommand = "";
		while(true) {
			System.out.println(gameEngine.getPromptGenerator().getChoicePrompt(gameEngine));
			singleCommand = in.nextLine();
			if (singleCommand.toLowerCase().equals("cancel")) {
				gameEngine.setSituationIndicator(2);
				return false;
			}
			for (Creature creature : gameEngine.getCurrentEnclosure().getPresentCreatures()) {
				if (singleCommand.equals(creature.getName())) {
					creature.heal();
					gameEngine.setSituationIndicator(2);
					return true;
				}
			}
			// Creature name not correct
			System.out.println(Message.incorrectEntry());
		}
		
	}
	private static boolean handleNewEnclosure(GameEngine gameEngine, String enclosureClass) {
//		gameEngine.setSituationIndicator(-1);
		Scanner in = new Scanner(System.in);
		
		// Name the enclosure
		String command = "";
		String name = "";
		boolean valid = false;
		while (!valid) {
			System.out.println("Name the new " + enclosureClass + " : ");
			name = in.nextLine();
			if (name.toLowerCase().equals("cancel")) return false;
			valid = true;
			for (Enclosure enclosure : gameEngine.getZoo().getExistingEnclosures()) {
				if (name.equals(enclosure.getName())) {
					valid = false;
					System.out.println("Name " + name + " is already taken.");
					break;
				}
			}
		}
		
		// Determine max number creatures
		System.out.println("Indicate the maximum number of creatures : ");
		command = in.nextLine();
		if (command.toLowerCase().equals("cancel")) return false;
		int maxCreatures = Integer.valueOf(command);
		
		// Surface
		System.out.println("Indicate the surface : ");
		command = in.nextLine();
		if (command.toLowerCase().equals("cancel")) return false;
		int surface = Integer.valueOf(command);
		
		// For Aquarium
		if (enclosureClass.equals(Aquarium.class.getSimpleName().toLowerCase())) {
			// Depth
			System.out.println("Indicate the depth : ");
			command = in.nextLine();
			if (command.toLowerCase().equals("cancel")) return false;
			int depth = Integer.valueOf(command);
			
			// Salinity
			System.out.println("Indicate the salinity : ");
			command = in.nextLine();
			if (command.toLowerCase().equals("cancel")) return false;
			int salinity = Integer.valueOf(command);
			
			gameEngine.getZoo().addNewEnclosure(new Aquarium(name, surface, maxCreatures, Enclosure.CLEANNESS_STATES[0], depth, salinity));
		}
		// For Aviary
		else if (enclosureClass.equals(Aviary.class.getSimpleName().toLowerCase())) {
			// Height
			System.out.println("Indicate the height : ");
			command = in.nextLine();
			if (command.toLowerCase().equals("cancel")) return false;
			int height = Integer.valueOf(command);
			
			gameEngine.getZoo().addNewEnclosure(new Aviary(name, surface, maxCreatures, Enclosure.CLEANNESS_STATES[0], height));
		}
		// For normal enclosure
		else {
			gameEngine.getZoo().addNewEnclosure(new Enclosure(name, surface, maxCreatures, Enclosure.CLEANNESS_STATES[0]));
		}
		return true;
	}
	
	
}
