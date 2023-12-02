package Colony;

public class AlphaCouple {

	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					   ATTRIBUTES
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	private Werewolf male;
	private Werewolf female;
	private Pack pack;
	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					GETTERS / SETTERS
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	public Werewolf getMale() {
		return male;
	}
	public void setMale(Werewolf male) {
		this.male = male;
	}
	public Werewolf getFemale() {
		return female;
	}
	public void setFemale(Werewolf female) {
		this.female = female;
	}
	public Pack getPack() {
		return pack;
	}
	public void setPack(Pack pack) {
		this.pack = pack;
	}
	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					  CONSTRUCTORS
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	public AlphaCouple(Werewolf male, Werewolf female, Pack pack) {
		super();
		this.male = male;
		this.female = female;
		this.pack = pack;
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
		return "AlphaCouple [male=" + male + ", female=" + female + ", pack=" + pack + "]";
	}
	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					   METHODS
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	/**
	 * The alpha couple reproduces which create 1 to 7 newborn pack members.
	 */
	public void reproduce() {
		
	}
	
	/**
	 * Shows the characteristics of the alpha couple
	 */
	public void showCharacteristics() {
		System.out.println(this.toString());
	}
	
}
