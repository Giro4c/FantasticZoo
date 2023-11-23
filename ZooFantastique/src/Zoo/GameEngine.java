package Zoo;

import Zoo.Prompts.Prompt;

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
