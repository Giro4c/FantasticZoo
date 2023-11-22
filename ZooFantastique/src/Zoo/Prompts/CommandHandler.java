package Zoo.Prompts;

import java.util.ArrayList;
import java.util.Scanner;

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
		else {
			if (command.length == 2) {
				if (command[0].toLowerCase().equals("new")) {
					if(command[1].toLowerCase().equals("enclosure") 
							|| command[1].toLowerCase().equals("aquarium") 
							|| command[1].toLowerCase().equals("aviary")) {
						handleNewEnclosure(gameEngine, command[1].toLowerCase());					
					}
					else throw new Exception(Message.notExists("New element type"));
				}
				else throw new Exception(Message.notSpecified("New element type"));
			}
			else if (command.length == 3) {
				if (command[0].toLowerCase().equals("show") && command[1].toLowerCase().equals("info")) {
					if (command[2].toLowerCase().equals("zoo")) {
						gameEngine.getZoo().toString();
					}
					else if (command[2].toLowerCase().equals("zoomaster")) {
						gameEngine.getZoo().getZooMaster().toString();
					}
				}
			}
			else if (command.length == 4) {
				if (command[0].toLowerCase().equals("go") && command[1].toLowerCase().equals("to") && command[2].toLowerCase().equals("enclosure")) {
					for (Enclosure enclosure : gameEngine.getZoo().getExistingEnclosures()) {
						if (command[3].equals(enclosure.getName())) {
							gameEngine.setCurrentEnclosure(enclosure);
							gameEngine.setSituationIndicator(2);
							break;
						}
					}
				}
			}
		}
		return true;
	}
	
	private static boolean executeCommandEnclosure(String[] command, GameEngine gameEngine) throws Exception {
		if (command.length == 0) {
			throw new Exception(Message.notRecognized());
		}
		else {
			if (command.length == 1) {
				if (command[0].toLowerCase().equals("feed")) {
					
				}
				else if (command[0].toLowerCase().equals("heal")) {
					
				}
				else if (command[0].toLowerCase().equals("leave")) {
					
				}
				else throw new Exception(Message.notRecognized());
			}
			else if (command.length == 2) {
				if (command[0].toLowerCase().equals("examine") && command[1].toLowerCase().equals("enclosure")) {
					
				}
				else if (command[0].toLowerCase().equals("transfer") && command[1].toLowerCase().equals("creature")) {
					
				}
				else if (command[0].toLowerCase().equals("remove") && command[1].toLowerCase().equals("creature")) {
					
				}
				else if (command[0].toLowerCase().equals("clean") && command[1].toLowerCase().equals("enclosure")) {
					
				}
				else throw new Exception(Message.notRecognized());
			}
			else if (command.length == 3) {
				if (command[0].toLowerCase().equals("show")) {
					if (command[1].toLowerCase().equals("info") && command[2].toLowerCase().equals("zoomaster")) {
						gameEngine.getZoo().getZooMaster().toString();
					}
					else if (command[1].toLowerCase().equals("enclosure") && command[2].toLowerCase().equals("details")) {
						gameEngine.getCurrentEnclosure().toString();
					}
				}
			}
		}
		return true;
	}
	
	
	private static boolean handleTransfert(GameEngine gameEngine) {
		gameEngine.setSituationIndicator(3);
		System.out.println(gameEngine.getPromptGenerator().getChoicePrompt(gameEngine));
		Scanner in = new Scanner(System.in);
		// Necessary variables to memorize
		int transfertCreatureIndex = 0;
		int transfertEnclosureIndex = 0;
		
		
		
		// Handle first command --> Creature selection
		String singleCommand = "";
		boolean validCommand = false;
		while(true) {
			singleCommand = in.nextLine();
			if (singleCommand.toLowerCase().equals("cancel")) {
				gameEngine.setSituationIndicator(2);
				return true;
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
				System.out.println(gameEngine.getPromptGenerator().getChoicePrompt(gameEngine));
			}
			else {
				gameEngine.setSubSituationIndicator(gameEngine.getSubSituationIndicator() + 1);
				break;
			}
		}
		
		// Handle second command --> Enclosure selection
		singleCommand = "";
		validCommand = false;
		while(true) {
			singleCommand = in.nextLine();
			if (singleCommand.toLowerCase().equals("cancel")) {
				gameEngine.setSituationIndicator(2);
				return true;
			}
			for (int indexE = 0 ; indexE < gameEngine.getZoo().getExistingEnclosures().size() ; ++indexE) {
				if (singleCommand.equals(gameEngine.getZoo().getExistingEnclosures().get(indexE).getName())) {
					transfertEnclosureIndex = indexE;
					validCommand = true;
					break;
				}
			}
			if (!validCommand) {
				System.out.println(Message.incorrectEntry());
				System.out.println(gameEngine.getPromptGenerator().getChoicePrompt(gameEngine));
			}
			else {
				gameEngine.setSubSituationIndicator(gameEngine.getSubSituationIndicator() + 1);
				break;
			}
		}
		
		// Execute transfer
		gameEngine.getZoo().getExistingEnclosures().get(transfertEnclosureIndex).addCreature(gameEngine.getCurrentEnclosure().removeCreature(transfertCreatureIndex));
		
		return true;
	}
	
	
	private static boolean handleRemove(GameEngine gameEngine) {
		gameEngine.setSituationIndicator(4);
		System.out.println(gameEngine.getPromptGenerator().getChoicePrompt(gameEngine));
		Scanner in = new Scanner(System.in);
		
		// Handle first command --> Creature selection
		String singleCommand = "";
		while(true) {
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
					if (singleCommand.toLowerCase().equals("yes")) {
						gameEngine.getCurrentEnclosure().removeCreature(indexC);
						return true;
					}
					else {
						return false;
					}
				}
			}
			System.out.println(Message.incorrectEntry());
			System.out.println(gameEngine.getPromptGenerator().getChoicePrompt(gameEngine));
		}
		
	}
	private static boolean handleHeal(GameEngine gameEngine) {
		gameEngine.setSituationIndicator(5);
		System.out.println(gameEngine.getPromptGenerator().getChoicePrompt(gameEngine));
		Scanner in = new Scanner(System.in);
		
		// Handle first command --> Creature selection
		String singleCommand = "";
		boolean validCommand = false;
		while(true) {
			singleCommand = in.nextLine();
			if (singleCommand.toLowerCase().equals("cancel")) {
				gameEngine.setSituationIndicator(2);
				return false;
			}
			for (Creature creature : gameEngine.getCurrentEnclosure().getPresentCreatures()) {
				if (singleCommand.equals(creature.getName())) {
					creature.heal();
					return true;
				}
			}
			// Creature name not correct
			System.out.println(Message.incorrectEntry());
			System.out.println(gameEngine.getPromptGenerator().getChoicePrompt(gameEngine));
		}
		
	}
	private static boolean handleNewEnclosure(GameEngine gameEngine, String enclosureClass) {
		
		return true;
	}
	
	
}
