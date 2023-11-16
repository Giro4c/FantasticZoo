package Zoo;

import Zoo.Prompts.Prompt;

public class GameEngine {

	private Prompt promptGenerator;
	private FantasticZoo zoo;
	private Enclosure currentEnclosure;

	public GameEngine() {
		super();
		this.promptGenerator = new Prompt(1);
		this.zoo = new FantasticZoo("Zoo", new ZooMaster("Camille", false, 19), 3);
		this.currentEnclosure = null;
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

	public void showChoices() {
		System.out.println(this.promptGenerator.getChoicePrompt(zoo, currentEnclosure));
	}
	
}
