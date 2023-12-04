package Colony;

import java.util.ArrayList;

public class Territory {

	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					   ATTRIBUTES
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	private Pack currentPack;
	private ArrayList<Werewolf> loners;
	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					GETTERS / SETTERS
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	public Pack getCurrentPack() {
		return currentPack;
	}
	
	public void setCurrentPack(Pack currentPack) {
		this.currentPack = currentPack;
	}
	
	public ArrayList<Werewolf> getLoners() {
		return loners;
	}
	
	public void setLoners(ArrayList<Werewolf> loners) {
		this.loners = loners;
	}
	
	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					  CONSTRUCTORS
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	public Territory(Pack currentPack, ArrayList<Werewolf> loners) {
		super();
		this.currentPack = currentPack;
		this.loners = loners;
	}
	
	public Territory(ArrayList<Werewolf> loners) {
		super();
		this.loners = loners;
		this.currentPack = null;
	}
	
	public Territory(Pack currentPack) {
		super();
		this.currentPack = currentPack;
		this.loners = new ArrayList<Werewolf>();
	}
	
	public Territory() {
		super();
		this.currentPack = null;
		this.loners = new ArrayList<Werewolf>();
	}

	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					   TO_STRING
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	/**
	 * A CHANGER
	 */
	@Override
	public String toString() {
		return "Territory [currentPack=" + currentPack + ", loners=" + loners + "]";
	}
	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					   METHODS
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	
	
	
}
