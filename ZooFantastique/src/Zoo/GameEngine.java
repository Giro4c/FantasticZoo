package Zoo;

import Zoo.Prompts.Message;
import Zoo.Prompts.Prompt;
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
	 * </ul>
	 * </p>
	 */
	private int situationIndicator;
	private int subSituationIndicator;

	public GameEngine() {
		super();
		this.promptGenerator = new Prompt();
		this.zoo = new FantasticZoo("Zoo", new ZooMaster("Camille", false, 19), 5);
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
	
	public void init() {
		this.zoo = Message.zooCreation();
		// Create 10 enclosures
			// Enclosure 1
		Enclosure enclosure = new Enclosure("Savanaria", 150, 10, Enclosure.CLEANNESS_STATES[0]);
		enclosure.addCreature(new Nymphe(null, null, false, situationIndicator, situationIndicator, situationIndicator, null, false, null, situationIndicator, situationIndicator, enclosure));
		this.zoo.addNewEnclosure(new Enclosure("Savanaria", 150, 10, Enclosure.CLEANNESS_STATES[0])); 			// 0
		this.zoo.addNewEnclosure(new Enclosure("Babil", 175, 12, Enclosure.CLEANNESS_STATES[0])); 				// 1
		this.zoo.addNewEnclosure(new Enclosure("Leon's Gate", 205, 15, Enclosure.CLEANNESS_STATES[0])); 		// 2
		this.zoo.addNewEnclosure(new Enclosure("Well", 136, 8, Enclosure.CLEANNESS_STATES[0])); 				// 3
		this.zoo.addNewEnclosure(new Enclosure("ArraLa", 103, 5, Enclosure.CLEANNESS_STATES[0])); 				// 4
		this.zoo.addNewEnclosure(new Aquarium("AquaSea", 100, 10, Enclosure.CLEANNESS_STATES[0], 30, 39)); 		// 5
		this.zoo.addNewEnclosure(new Aquarium("Seallusion", 130, 16, Enclosure.CLEANNESS_STATES[0], 38, 38)); 	// 6
		this.zoo.addNewEnclosure(new Aquarium("Lake Accuity", 90, 9, Enclosure.CLEANNESS_STATES[0], 15, 10)); 	// 7
		this.zoo.addNewEnclosure(new Aviary("Great Aviary", 150, 15, Enclosure.CLEANNESS_STATES[0], 30)); 		// 8
		this.zoo.addNewEnclosure(new Aviary("Smallviary", 60, 6, Enclosure.CLEANNESS_STATES[0], 20)); 			// 9
		// Fill all enclosures
			// Enclosure 1
		this.zoo.getExistingEnclosures().get(0);
		
		
	}
	
	/* ------------------- SET UP FOR TESTING ----------------- */
	
	public void initForTests() {
		// Initialize enclosures
		this.zoo.getExistingEnclosures().add(new Enclosure("Enclosure 1", 100, 15, "ok"));
		this.zoo.getExistingEnclosures().add(new Aviary("Aviary 2", 100, 15, "ok", 20));
		this.zoo.getExistingEnclosures().add(new Aquarium("Aquarium 3", 100, 15, "ok", 15, 30));
		this.zoo.getExistingEnclosures().add(new Enclosure("Enclosure 4", 100, 15, "ok"));
		// Initialize some creatures
		
	}
	
}
