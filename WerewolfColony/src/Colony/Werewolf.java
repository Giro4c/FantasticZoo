package Colony;
import Colony.Utils;
/**
 * A class representing a werewolf and its behavior
 * @author Giro4c
 *
 */
public class Werewolf extends Creature {
	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					   ATTRIBUTES
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	/**
	 * The strength of the werewolf.
	 */
	private int strength;
	
	/**
	 * The domination factor of the werewolf.<br>
	 * Corresponds to the number of dominations exerted minus the ones received.
	 */
	private int dominationFactor;
	
	/**
	 * The werewolf's domination rank within its pack. 
	 * Hierarchy follows the Greek alphabet. 
	 */
	private char rank;
	
	/**
	 * The subjective quality criteria for the werewolf.<br>
	 * Depends on the age category, the strength, the domination factor and the rank of the werewolf.
	 */
	private int level;
	
	/**
	 * The arrogance factor of the werewolf. 
	 * Will have an impact on whether or not it will try a domination on a fellow pack member.
	 */
	private int arroganceFactor;
	
	/**
	 * The pack to which belongs the werewolf. If the werewolf is a loner then the attribute's value is null.
	 */
	private Pack pack;
	
	/**
	 * Indicates whether or not the werewolf is currently in its human form.
	 */
	private boolean currentlyHuman;

	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					GETTERS / SETTERS
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDominationFactor() {
		return dominationFactor;
	}

	public void setDominationFactor(int dominationFactor) {
		this.dominationFactor = dominationFactor;
	}

	public char getRank() {
		return rank;
	}

	public void setRank(char rank) {
		this.rank = rank;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getArroganceFactor() {
		return arroganceFactor;
	}

	public void setArroganceFactor(int arroganceFactor) {
		this.arroganceFactor = arroganceFactor;
	}

	public Pack getPack() {
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	public boolean isCurrentlyHuman() {
		return currentlyHuman;
	}

	public void setCurrentlyHuman(boolean currentlyHuman) {
		this.currentlyHuman = currentlyHuman;
	}
		
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					  CONSTRUCTORS
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	
	public Werewolf(String specie, String name, boolean isMale, int weight, int height, int age, String ageRange,
			boolean isSleeping, int strength, int dominationFactor, char rank, int level, int arroganceFactor,
			Pack pack) {
		super(specie, name, isMale, weight, height, age, ageRange, isSleeping);
		this.strength = strength;
		this.dominationFactor = dominationFactor;
		this.rank = rank;
		this.level = level;
		this.arroganceFactor = arroganceFactor;
		this.pack = pack;
	}

	
	
	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					   TO_STRING
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	@Override
	public String toString() {
		return "Werewolf [strength=" + strength + ", dominationFactor=" + dominationFactor + ", rank=" + rank
				+ ", level=" + level + ", arroganceFactor=" + arroganceFactor + ", pack=" + pack + ", toString()="
				+ super.toString() + "]";
	}
	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					   EQUALS
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	
	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					   METHODS
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	/**
	 * Emits a different howl depending on the typeID given :
	 * <ul>
	 * <li>0 -> Pack belonging</li>
	 * <li>1 -> Express domination</li>
	 * <li>2 -> Express submission (answer to successful domination)</li>
	 * <li>3 -> Express aggression (answer to failed domination or toward omega pack member)</li>
	 * </ul>
	 * No matter the type, the howl shows the werewolf's characteristics.
	 * @param howlTypeID The id of the howl's type.
	 * @throws ExceptionHowl The howl that will be propagated to be heard by the rest of the werewolfs in the pack.
	 */
	public void howl(int howlTypeID) throws ExceptionHowl {
		
	}
	
	/**
	 * Show the caracteristics of the werewolf.
	 */
	public void showCharacteristics() {
		System.out.println(this.toString());
	} // Il faut modif toString dans Creature et Werewolf
	
	
	/**
	 * Defines the behavior of the werewolf when he hears a howl.
	 * @param howl The ExceptionHowl that corresponds to the howl the werewolf hears.
	 */
	public void hearHowl(ExceptionHowl howl) {
		
	}
	
	/**
	 * Indicates if the werewolf can hear a howl or not depending on specific factors.
	 * @return A boolean that indicates whether a howl can be heard (true) or not (false)
	 */
	public boolean canHearHowl() {
		if (!this.isSleeping()) return true;
		return false;
	}
	
	/**
	 * The werewolf leaves its pack to become a loner.
	 */
	public void leavePack() {
		System.out.println(this.getName() + " leaves its pack.");
		this.getPack().packMemberLeaves(this);
	}
	
	/**
	 * The werewolf joins a pack to become a pack member.
	 */
	public void joinPack(Pack newPack) {
		System.out.println(this.getName() + " joins a pack.");
		newPack.packMemberJoins(this);
	}
	
	/**
	 * The werewolf shift form :
	 * <ul>
	 * <li>If in wolf form then transform into human form</li>
	 * <li>If in human form then transform into wolf form</li>
	 */
	public void transform() {
		this.currentlyHuman = !this.currentlyHuman;
	}
	public void winDomination(Werewolf w) {
		System.out.println(this.getName()+ " gagne la domination !");
		this.dominationFactor +=1;
		if(!Utils.isDominant(this.rank, w.getRank())) {
			char tmp = w.getRank();
			w.setRank(this.getRank());
			this.setRank(tmp);
		}
		w.setDominationFactor(w.getDominationFactor()-1);
	}
	public void loseDomination(Werewolf w) {
		System.out.println(this.getName()+ " perd la domination !");
		this.dominationFactor -=1;
		if(Utils.isDominant(this.rank, w.getRank())) {
			char tmp = w.getRank();
			w.setRank(this.getRank());
			this.setRank(tmp);
		}
		w.setDominationFactor(w.getDominationFactor()+1);
	}
	/* 
	 * Ces fonctions peuvent etre utiles.
	 * Je les laisse là vous pouvez les remplir ou non. 
	 * Comme vous voulez, elles devront juste avoir un lien avec howl quelque part.
	 */
	public void submit() {
		
	}
	public void dominate(Werewolf w) {
		System.out.println(super.getName() + " essaye de dominer "+ w.getName());
		if(this.strength > w.strength && w.getRank()!='α') {
			if(this.level>w.level||w.rank == 'ω') {
				this.winDomination(w);
			}
			else if(this.level == w.getLevel()) {
                System.out.println(super.getName() + " et " + w.getName() + " ont le même niveau le combat sera donc aléatoire ");
                long random = Math.round(Math.random());
                // si 1 this gagne sinon this perd
                if (0 < random) {
                    this.winDomination(w);
                } else {
                    this.loseDomination(w);
                }
            }
			else {
				this.loseDomination(w);
			}
		}
		else {
			this.loseDomination(w);
		}
	}
	public void aggress() {
		System.out.println(super.getName() + " se montre agressif !");
	}
	
	
}
