package Colony;
import java.util.Random;
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
	
	private Territory territory;
	/**
	 * The strength of the werewolf. 
	 * from 0 to 10
	 */
	private int strength;
	
	/**
	 * The domination factor of the werewolf.<br>
	 * Corresponds to the number of dominations exerted minus the ones received.
	 */
	private int dominationFactor = 0;
	
	/**
	 * The werewolf's domination rank within its pack. 
	 * Hierarchy follows the Greek alphabet. 
	 */
	private Character rank = ' ';
	
	/**
	 * The subjective quality criteria for the werewolf.<br>
	 * Depends on the age category, the strength, the domination factor and the rank of the werewolf.
	 * from 0 to 20
	 */
	private int level;
	
	/**
	 * The arrogance factor of the werewolf. 
	 * Will have an impact on whether or not it will try a domination on a fellow pack member.
	 * from 0 to 5
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

	/**
	 * the threshold of the dominating factor, when this seuil is excedeed, the dominating rank goes down
	 */
	private final int THRESHOLD_DOMINATING_FACTOR = -5;
	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					GETTERS / SETTERS
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */

	public Territory getTerritory() {
		return this.territory;
	}
	
	public void setTerritory (Territory territory) {
		this.territory = territory;
	}
	
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
	
	
	public Werewolf(Pack pack) {
		super();
		
	    Random random = new Random();
	    int randomStrength = random.nextInt(11);
	    this.strength = randomStrength;
	    
        Random randomArrog = new Random();
        int randomArrogFactor = randomArrog.nextInt(11);
        this.arroganceFactor = randomArrogFactor;
        
		this.pack = pack;
		
		
		this.level = Utils.calculateLevel(this.getAgeRange(), strength, arroganceFactor, rank); 
	}
	
	public Werewolf(Territory territory) {
		super();
		
	    Random random = new Random();
	    int randomStrength = random.nextInt(11);
	    this.strength = randomStrength;
	    
        Random randomArrog = new Random();
        int randomArrogFactor = randomArrog.nextInt(11);
        this.arroganceFactor = randomArrogFactor;

		this.pack = null;
		this.territory = territory;
		this.territory.addWolf(this);
		
		this.level = Utils.calculateLevel(this.getAgeRange(), strength, arroganceFactor, rank); 
	}

	
	//; calculé en fonction de la catégorie d’âge, de la force, du facteur de domination et
	//du rang) ;
	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					   TO_STRING
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	@Override
	public String toString() {
		return "Werewolf [strength=" + strength + ", dominationFactor=" + dominationFactor + ", rank=" + rank
				+ ", level=" + level + ", arroganceFactor=" + arroganceFactor
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
		this.pack = null;
	}
	
	/**
	 * The werewolf joins a pack to become a pack member.
	 */
	public void joinPack(Pack newPack) {
		System.out.println(this.getName() + " joins a pack.");
		newPack.packMemberJoins(this);
		this.pack = newPack;
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
		w.aggress(this);
		this.dominationFactor -=1;
		if(Utils.isDominant(this.rank, w.getRank())) {
			char tmp = w.getRank();
			w.setRank(this.getRank());
			this.setRank(tmp);
		}
		w.setDominationFactor(w.getDominationFactor()+1);
		
		// a few chance to quit its pack after losing a domination
		Random random = new Random();
        int randomNumber = random.nextInt(8) + 1;
        if (randomNumber == 1)
        	this.leavePack();
	}
	
	/* 
	 * Ces fonctions peuvent etre utiles.
	 * Je les laisse là vous pouvez les remplir ou non. 
	 * Comme vous voulez, elles devront juste avoir un lien avec howl quelque part.
	 */
	public void submit() {
		
	}
	
	/**
	 * this tell us if the aggressor can dare to dominate the target 
	 * @param target
	 * @return
	 */
	public boolean canDominate(Werewolf target) {
	    boolean candominate = false;
	    
	    if (this.getPack() != null) {
    	if (this.strength >= target.strength && this.getPack().getAlphaCouple().getFemale() != target) {
    		
    		if (target == target.getPack().getAlphaCouple().getMale() && this.getAgeRange() != "Adult")
    			return candominate;
    		else
    			if (this.getArroganceFactor() > 4) {
    			candominate = true;
    			}
    			else if (this.getArroganceFactor() == 4) {
    			candominate = Math.random() < 3 / 4;
    			}
    			else if (this.getArroganceFactor() == 3) {
    			candominate = Math.round(Math.random()) == 0; }
    		
    			else if (this.getArroganceFactor() == 2) {
    			candominate = Math.random() < 1 / 3;
    			}
    			else if (this.getArroganceFactor() == 1) {
    			candominate = Math.random() < 1 / 4;
    			}
	    } }

	    return candominate;
	}
	

	
	public void dominate(Werewolf w) {
		System.out.println(super.getName() + " essaye de dominer "+ w.getName());
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
	
	public void aggress(Werewolf wolfTarget) {
		System.out.println(super.getName() + " se montre agressif ! envers : " + wolfTarget.getName());
	}
	
	/**
	 * Check if the wolf have to be deranked (if his dominating factor is less than the threshold)
	 */
	public void naturalRankDecrease() {
	    if (this.dominationFactor < THRESHOLD_DOMINATING_FACTOR && this.getRank() != 'ω') {
	        boolean isLastOfSexWithCurrentRank = true;

	        for (Werewolf wolf : this.getPack().getMembers()) {
	            if (this.getRank() == wolf.getRank() && this != wolf && this.isMale() == wolf.isMale()) {
	                isLastOfSexWithCurrentRank = false;
	                break;
	            }
	        }

	        if (isLastOfSexWithCurrentRank) {
	            this.rank++;
	            this.dominationFactor = 0;
	        }
	    }
	}
	
	public boolean isLoner () {
		return this.getPack() == null;
	}
	
	/**
	 * Chances of omegas wolfes leaving pack
	 */
	public void chancesOmegaLeaving () {
		if (this.getRank() == 'ω') {
			Random random = new Random();
			int randomNumber = random.nextInt(5) + 1;
			if (randomNumber == 1) 
				this.leavePack(); 	
	}
		}
	
	public void die() {   
		if (this.getPack() != null)	
			this.getPack().packMemberLeaves(this);
		if (this.territory != null) {
	        this.territory.removeWolf(this);
	}
	}
	
	
	}
