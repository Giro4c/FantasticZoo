package Zoo;

import Zoo.Prompts.Message;
import Zoo.Prompts.Prompt;

import java.util.ArrayList;

import Zoo.Animals.*;

public class GameEngine {

	private Prompt promptGenerator;
	private FantasticZoo zoo;
	private Enclosure currentEnclosure;
	
	/**
	 * <p>
	 * A variable that acts as an situation indicator : 
	 * <ul>
	 * 	<li>1 -> ZooMaster is in the Zoo Lobby </li>
	 * 	<li>2 -> ZooMaster is focused on a specific enclosure</li>
	 * 	<li>3 -> Transfer interface</li>
	 * 	<li>4 -> Remove creature interface</li>
	 * 	<li>5 -> Heal creature interface</li>
	 * 	<li>6 -> </li>
	 * 	<li>7 -> </li>
	 * </ul>
	 * </p>
	 */
	private int situationIndicator;
	private int subSituationIndicator;

	public GameEngine() {
		super();
		this.promptGenerator = new Prompt();
		this.zoo = new FantasticZoo("Zoo", new ZooMaster("Moundir le roi", false, 19), 5);
		this.currentEnclosure = null;
		this.setSituationIndicator(1);
	}

	public Prompt getPromptGenerator() {
		return promptGenerator;
	}
	
	public FantasticZoo getZoo() {
		return zoo;
	}

	public Enclosure getCurrentEnclosure() {
		return currentEnclosure;
	}
	
	public void setCurrentEnclosure(Enclosure currentEnclosure) {
		this.currentEnclosure = currentEnclosure;
	}

	public int getSituationIndicator() {
		return situationIndicator;
	}

	public void setSituationIndicator(int situationIndicator) {
		this.situationIndicator = situationIndicator;
		this.subSituationIndicator = 0;
	}	
	
	public int getSubSituationIndicator() {
		return subSituationIndicator;
	}
	
	public void setSubSituationIndicator(int subSituationIndicator) {
		this.subSituationIndicator = subSituationIndicator;
	}

	public void showChoices() {
		System.out.println(this.promptGenerator.getChoicePrompt(this));
	}
	
	/**
	 * Initialize the zoo for the game with enclosures of every type and creatures of every species.
	 */
	public void init() {
		this.zoo = Message.zooCreation();
		
		// Create 10 enclosures
			// Enclosure 1
		Enclosure enclosure = new Enclosure("Savanaria", 150, 10, Enclosure.CLEANNESS_STATES[0]);
		enclosure.addCreature(new Nymph(true, 20, enclosure));
		enclosure.addCreature(new Nymph(false, 24, enclosure));
		enclosure.addCreature(new Nymph(true, 40, enclosure));
		enclosure.addCreature(new Nymph(true, 31, enclosure));
		this.zoo.addNewEnclosure(enclosure); 			// 0
			// Enclosure 2
		enclosure = new Enclosure("Babil", 175, 12, Enclosure.CLEANNESS_STATES[0]);
		enclosure.addCreature(new Werewolf(true, 12, enclosure));
		enclosure.addCreature(new Werewolf(false, 5, enclosure));
		enclosure.addCreature(new Werewolf(false, 36, enclosure));
		enclosure.addCreature(new Werewolf(true, 31, enclosure));
		this.zoo.addNewEnclosure(enclosure); 			// 1
			// Enclosure 3
		enclosure = new Enclosure("Leon's Gate", 205, 15, Enclosure.CLEANNESS_STATES[0]);
		enclosure.addCreature(new Dragon(true, 150, enclosure));
		enclosure.addCreature(new Dragon(false, 200, enclosure));
		this.zoo.addNewEnclosure(enclosure); 			// 2
			// Enclosure 4
		enclosure = new Enclosure("Well", 136, 8, Enclosure.CLEANNESS_STATES[0]);
		enclosure.addCreature(new Unicorn(true, 14, enclosure));
		enclosure.addCreature(new Unicorn(false, 13, enclosure));
		this.zoo.addNewEnclosure(enclosure); 			// 3
			// Enclosure 5
		enclosure = new Enclosure("ArraLa", 103, 5, Enclosure.CLEANNESS_STATES[0]);
		this.zoo.addNewEnclosure(enclosure); 			// 4
			// Enclosure 6
		enclosure = new Aquarium("AquaSea", 100, 10, Enclosure.CLEANNESS_STATES[0], 30, 39);
		enclosure.addCreature(new Megalodon(true, 11, enclosure));
		enclosure.addCreature(new Megalodon(false, 21, enclosure));
		enclosure.addCreature(new Megalodon(true, 22, enclosure));
		this.zoo.addNewEnclosure(enclosure); 			// 5
			// Enclosure 7
		enclosure = new Aquarium("Seallusion", 130, 16, Enclosure.CLEANNESS_STATES[0], 38, 38);
		enclosure.addCreature(new Kraken(false, 99, enclosure));
		enclosure.addCreature(new Kraken(true, 103, enclosure));
		this.zoo.addNewEnclosure(enclosure); 			// 6
			// Enclosure 8
		enclosure = new Aquarium("Lake Accuity", 90, 9, Enclosure.CLEANNESS_STATES[0], 15, 10);
		enclosure.addCreature(new Mermaid(true, 45, enclosure));
		enclosure.addCreature(new Mermaid(false, 32, enclosure));
		enclosure.addCreature(new Mermaid(false, 40, enclosure));
		this.zoo.addNewEnclosure(enclosure); 			// 7
			// Enclosure 9
		enclosure = new Aviary("Great Aviary", 150, 15, Enclosure.CLEANNESS_STATES[0], 30);
		this.zoo.addNewEnclosure(enclosure); 			// 8
			// Enclosure 10
		enclosure = new Aviary("Smallviary", 60, 6, Enclosure.CLEANNESS_STATES[0], 20);
		enclosure.addCreature(new Phenix(true, 19, enclosure));
		enclosure.addCreature(new Phenix(false, 30, enclosure));
		enclosure.addCreature(new Phenix(false, 15, enclosure));
		enclosure.addCreature(new Phenix(true, 14, enclosure));
		this.zoo.addNewEnclosure(enclosure); 			// 9
		
		// Start all creature threads for the zoo (threads in enclosures are already started)
		for (Enclosure enclosureC : this.zoo.getExistingEnclosures()){
			for (int indexCreature = 0; indexCreature < enclosureC.getPresentCreatures().size(); ++indexCreature) {
				try {
					enclosureC.getPresentCreatures().get(indexCreature).startLife();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		// Clear screen of all prints done by addCreature during initialization
		// Only works on terminal. Does not work on IDE.
		System.out.print("\033[H\033[2J");  
	    System.out.flush();
				
	}
	
	/* ------------------- SET UP FOR TESTING ----------------- */
	
	public void getDeadCreatures() {
		for (Enclosure enclosureC : this.zoo.getExistingEnclosures()){
			for (Creature creature : enclosureC.getPresentCreatures()) {
				if (creature.getEnclosure() == null) {
					System.out.println(creature.getSpecie() + " " + creature.getName());
				}
			}
		}
		System.out.print(Message.ANSI_CYAN);
		for (Creature creature : this.zoo.getExistingEnclosures().get(2).getPresentCreatures()) {
			System.out.println(creature.getSpecie() + " " + creature.getName());
		}
		System.out.print(Message.ANSI_RESET);
	}
	
	public void initForTests() {
		// Initialize enclosures
		this.zoo.getExistingEnclosures().add(new Enclosure("Enclosure 1", 100, 15, "ok"));
		this.zoo.getExistingEnclosures().add(new Aviary("Aviary 2", 100, 15, "ok", 20));
		this.zoo.getExistingEnclosures().add(new Aquarium("Aquarium 3", 100, 15, "ok", 15, 30));
		this.zoo.getExistingEnclosures().add(new Enclosure("Enclosure 4", 100, 15, "ok"));
		// Initialize some creatures
		
	}
	
}
