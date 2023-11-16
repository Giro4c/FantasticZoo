package Zoo.Prompts;

import java.util.ArrayList;

import Zoo.Enclosure;
import Zoo.FantasticZoo;
import Zoo.GameEngine;
import Zoo.Animals.Creature;

public class Prompt {

	public Prompt() {
		super();
	}
	
	public String getChoicePrompt(GameEngine game){
		String promptChoice = "";
		if (game.getSituationIndicator() == 1) {
			promptChoice = "What do you want to do ?\n";
			for (String action : this.getPromptZoo()) {
				promptChoice = promptChoice + "\n\t" + action;
			}
		}
		else if (game.getSituationIndicator() == 2) {
			promptChoice = "What do you want to do ?\n";
			for (String action : this.getPromptEnclosure()) {
				promptChoice = promptChoice + "\n\t" + action;
			}
		}
		else if (game.getSituationIndicator() == 3) {
			promptChoice = this.getSubSituationString(this.getPromptTransfert(game.getCurrentEnclosure(), game.getZoo()), game.getSubSituationIndicator());
		}
		else if (game.getSituationIndicator() == 4) {
			promptChoice = this.getSubSituationString(this.getPromptRemove(game.getCurrentEnclosure()), game.getSubSituationIndicator());
		}
		else if (game.getSituationIndicator() == 5) {
			promptChoice = this.getSubSituationString(this.getPromptHeal(game.getCurrentEnclosure()), game.getSubSituationIndicator());
		}
		else if (game.getSituationIndicator() == 6) {
			
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
	
	private String getSubSituationString(ArrayList<String> promptList, int subSituationIndicator) {
		String str = "";
		if (subSituationIndicator < promptList.size()-1) {
			str = promptList.get(subSituationIndicator);
		}
		else {
			str = promptList.get(promptList.size()-2);
		}
		str = str + promptList.get(promptList.size()-1);
		return str;
	}

}
