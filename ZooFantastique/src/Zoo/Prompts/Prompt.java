package Zoo.Prompts;

import java.util.ArrayList;

import Zoo.Enclosure;
import Zoo.FantasticZoo;
import Zoo.Animals.Creature;

public class Prompt {
	
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

	public Prompt(int situationIndicator) {
		super();
		this.situationIndicator = situationIndicator;
		this.subSituationIndicator = 0;
	}
	
	public String getChoicePrompt(FantasticZoo zoo, Enclosure enclosure){
		String promptChoice = "";
		if (this.situationIndicator == 1) {
			promptChoice = "What do you want to do ?\n";
			for (String action : this.getPromptZoo()) {
				promptChoice = promptChoice + "\n\t" + action;
			}
		}
		else if (this.situationIndicator == 2) {
			promptChoice = "What do you want to do ?\n";
			for (String action : this.getPromptEnclosure()) {
				promptChoice = promptChoice + "\n\t" + action;
			}
		}
		else if (this.situationIndicator == 3) {
			promptChoice = this.getSubSituationString(this.getPromptTransfert(enclosure, zoo));
		}
		else if (this.situationIndicator == 4) {
			promptChoice = this.getSubSituationString(this.getPromptRemove(enclosure));
		}
		else if (this.situationIndicator == 5) {
			promptChoice = this.getSubSituationString(this.getPromptHeal(enclosure));
		}
		else if (this.situationIndicator == 6) {
			
		}
		return promptChoice;
	}
	
	public ArrayList<String> getPromptZoo(){
		ArrayList<String> prompt = new ArrayList<String>();
		prompt.add("Show info Zoo");
		prompt.add("Show info ZooMaster");
		prompt.add("Go to enclosure");
		prompt.add("New enclosure");
		prompt.add("New aquarium");
		prompt.add("New aviary");
		return prompt;
	}
	
	public ArrayList<String> getPromptEnclosure(){
		ArrayList<String> prompt = new ArrayList<String>();
		prompt.add("Show info ZooMaster");
		prompt.add("Examine enclosure");
		prompt.add("Show enclosure details");
		prompt.add("Transfer creature");
		prompt.add("Remove creature");
		prompt.add("Feed");
		prompt.add("Clean enclosure");
		prompt.add("Heal");
		prompt.add("Leave");
		return prompt;
	}
	
	public ArrayList<String> getPromptTransfert(Enclosure currentEnclosure, FantasticZoo zoo){
		ArrayList<String> prompt = new ArrayList<String>();
		String actionPrompt = "Which creature to transfer ?\nAvailable :";
		for (Creature creature : currentEnclosure.getPresentCreatures()) {
			actionPrompt = actionPrompt + "\n\t- " + creature.getName();
		}
		prompt.add(actionPrompt);
		actionPrompt = "Send to which enclosure ?\\nAvailable :";
		for (Enclosure enclosure : zoo.getExistingEnclosures()) {
			actionPrompt = actionPrompt + "\n\t- " + enclosure.getName();
		}
		prompt.add(actionPrompt);
		prompt.add("Cancel");
		return prompt;
	}
	
	public ArrayList<String> getPromptRemove(Enclosure currentEnclosure){
		ArrayList<String> prompt = new ArrayList<String>();
		String actionPrompt = "Which creature to remove from the zoo ?\nAvailable :";
		for (Creature creature : currentEnclosure.getPresentCreatures()) {
			actionPrompt = actionPrompt + "\n\t- " + creature.getName();
		}
		prompt.add(actionPrompt);
		prompt.add("Are you sure ? Yes/No");
		prompt.add("Cancel");
		return prompt;
	}
	
	public ArrayList<String> getPromptHeal(Enclosure currentEnclosure){
		ArrayList<String> prompt = new ArrayList<String>();
		String actionPrompt = "Which creature to heal ?\nAvailable :";
		for (Creature creature : currentEnclosure.getPresentCreatures()) {
			actionPrompt = actionPrompt + "\n\t- " + creature.getName();
		}
		prompt.add(actionPrompt);
		prompt.add("Cancel");
		return prompt;
	}
	
	private String getSubSituationString(ArrayList<String> promptList) {
		String str = "";
		if (this.subSituationIndicator < promptList.size()-1) {
			str = promptList.get(subSituationIndicator);
		}
		else {
			str = promptList.get(promptList.size()-2);
		}
		str = str + promptList.get(promptList.size()-1);
		return str;
	}

}
