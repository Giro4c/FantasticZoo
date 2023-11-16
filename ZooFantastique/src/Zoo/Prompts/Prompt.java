package Zoo.Prompts;

import java.util.ArrayList;

import Zoo.Enclosure;
import Zoo.FantasticZoo;

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

	public int getSituationIndicator() {
		return situationIndicator;
	}

	public void setSituationIndicator(int situationIndicator) {
		this.situationIndicator = situationIndicator;
	}
	
	public Prompt(int situationIndicator) {
		super();
		this.situationIndicator = situationIndicator;
	}
	
	public ArrayList<String> getFullPrompt(FantasticZoo zoo, Enclosure enclosure){
		
		if (this.situationIndicator == 1) {
			return this.getPromptZoo();
		}
		else if (this.situationIndicator == 2) {
			return this.getPromptEnclosure();
		}
		else if (this.situationIndicator == 3) {
			return this.getPromptTransfert();
		}
		else if (this.situationIndicator == 4) {
			return this.getPromptRemove();
		}
		else if (this.situationIndicator == 5) {
			return this.getPromptHeal();
		}
		else if (this.situationIndicator == 6) {
			
		}
		return null;
	}
	
	public ArrayList<String> getPromptZoo(){
		ArrayList<String> prompt = new ArrayList<String>();
		prompt.add("Show info Zoo");
		prompt.add("Show info ZooMaster");
		prompt.add("Go to enclosure");
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
	
	public ArrayList<String> getPromptTransfert(){
		ArrayList<String> prompt = new ArrayList<String>();
		prompt.add("Which creature to transfer ?");
		prompt.add("Available :");
		prompt.add("Send to which enclosure ?");
		prompt.add("Available :");
		prompt.add("Cancel");
		return prompt;
	}
	
	public ArrayList<String> getPromptRemove(){
		ArrayList<String> prompt = new ArrayList<String>();
		prompt.add("Which creature to remove from the zoo ?");
		prompt.add("Available :");
		prompt.add("Are you sure ? Yes/No");
		prompt.add("Cancel");
		return prompt;
	}
	
	public ArrayList<String> getPromptHeal(){
		ArrayList<String> prompt = new ArrayList<String>();
		prompt.add("Which creature to heal ?");
		prompt.add("Available :");
		prompt.add("Cancel");
		return prompt;
	}

}
