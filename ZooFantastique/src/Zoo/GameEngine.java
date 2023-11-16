package Zoo;

import Zoo.Prompts.Prompt;

public class GameEngine {

	private Prompt promptGenerator;
	private FantasticZoo zoo;

	public GameEngine() {
		super();
		this.promptGenerator = new Prompt(1);
		this.zoo = new FantasticZoo("Zoo", new ZooMaster("Camille", false, 19), 3);
	}

	public Prompt getPromptGenerator() {
		return promptGenerator;
	}
	
	public FantasticZoo getZoo() {
		return zoo;
	}

	public void showChoices() {
		if (this.promptGenerator.getSituationIndicator() < 3) {
			System.out.println("What do you want to do ?");
			for (String action : this.promptGenerator.getFullPrompt(zoo, null)) {
				System.out.println('\t' + action);
			}
		}
	}
	
}
