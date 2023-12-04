package Colony;

import java.util.ArrayList;

public class Pack {

	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					   ATTRIBUTES
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	private ArrayList<Werewolf> members;
	private Territory territory;
	private AlphaCouple alphaCouple;
	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					GETTERS / SETTERS
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	public ArrayList<Werewolf> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<Werewolf> members) {
		this.members = members;
	}

	public Territory getTerritory() {
		return territory;
	}

	public void setTerritory(Territory territory) {
		this.territory = territory;
	}

	public AlphaCouple getAlphaCouple() {
		return alphaCouple;
	}

	public void setAlphaCouple(AlphaCouple alphaCouple) {
		this.alphaCouple = alphaCouple;
	}
	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					  CONSTRUCTORS
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	public Pack(ArrayList<Werewolf> members, Territory territory) {
		super();
		this.members = members;
		this.territory = territory;
		// Faire appel aux fonctions de mise à jour de hierarchie après avoir choisi un male alpha (le plus fort lors de la création)
	}
	public Pack(Territory territory) {
		super();
		this.territory = territory;
		this.members = new ArrayList<>();
		// Faire appel aux fonctions de mise à jour de hierarchie après avoir choisi un male alpha (le plus fort lors de la création)
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
		return "Pack [members=" + members + ", territory=" + territory + ", alphaCouple=" + alphaCouple + "]";
	}
	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					   METHODS
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	/**
	 * Show the characteristics of the pack.
	 */
	public void showCharacteristics() {
		System.out.println(this.toString());
	}
	

	/**
	 * Show the characteristics of all members of the pack.
	 */
	public void showAllPackMembers() {
		System.out.println("All pack members :\n");
		for (Werewolf member : this.members) {
			member.showCharacteristics();
		}
	}
	
	/**
	 * A REMPLIR. 
	 * Modifies the rank hierarchy of a wolf pack by changing/setting the rank of each wolf.
	 * @param pack the pack whose hierarchy is changed
	 */
	public static void createNewHierarchy(Pack pack) {
		// A REMPLIR
	}
	
	/**
	 * Changes / Updates the hierarchy within the pack : Lower the ranks if necessary, constitute new alpha couple if necessary, etc...
	 * 
	 */
	public void updateHierarchy() {
		// A REMPLIR
	}
	
	/**
	 * Constitutes a new alpha couple depending from an alpha werewolf. 
	 * The chosen alpha female is the strongest female in the pack when the new couple is formed. 
	 * If its a new couple, the fallen alpha female takes the rank of her previous mate.
	 * @param maleAlpha the new alpha male of the couple
	 */
	public void constituteAlphaCouple(Werewolf maleAlpha) {
		if (this.alphaCouple != null && maleAlpha == this.alphaCouple.getMale()) return;
		// Déchoir l'ancien couple
		this.alphaCouple = null;

		// Rechercher femelle la plus forte
		Werewolf strongestFemale = null;
		
		for (Werewolf member : this.members )
			if (member.isMale() == false) {
	            if (strongestFemale == null || Utils.isDominant(member.getRank(), strongestFemale.getRank())) {
	                strongestFemale = member;
	            }
	        }
		
		// Constituer nouveau couple alpha
		if (strongestFemale == null) {
		this.alphaCouple.setPack(this);
		this.alphaCouple.setMale(maleAlpha);
		this.alphaCouple.setFemale(strongestFemale); }
		else {
			System.out.println("Aucune femelle trouvée pour constituer le nouveau couple");
		}
	}
	
	/**
	 * Change the werewolves' rank to omega (lowest rank) for any werewolf with lower than pack average strength.
	 */
	public void declareOmegas() {
		// Calculer force moyenne dans la meute
		// Parcourir la liste de loup et changer le rang quand la force est strictement inférieure à la moyenne.
		// Attention, cas particulier : tous les loups ont la meme force -> un des loups qui n'est pas alpha devient omega
	}
	
	/**
	 * Add a previously lone werewolf to the pack.
	 * @param newPackMember the lone werewolf that joins the pack
	 */
	public void packMemberJoins(Werewolf newPackMember) {
		// Remplir le reste (affichages, mises à jour, etc...)
		this.territory.getLoners().remove(newPackMember);
		newPackMember.setPack(this);
		this.members.add(newPackMember);
		
	}
	
	/**
	 * Removes a wolf from the pack and make it a lone werewolf.
	 * @param oldPackMember the werewolf leaving the pack
	 */
	public void packMemberLeaves(Werewolf oldPackMember) {
		// Remplir le reste (affichages, mises à jour, etc...)
		this.members.remove(oldPackMember);
		oldPackMember.setPack(null);
		this.territory.getLoners().add(oldPackMember);
	}
	
	/**
	 * Launches a reproduction within the Pack. 
	 * Only the alpha couple can reproduce in a pack. 
	 * 
	 * OUBLIEZ PAS DE METTRE A JOUR LA HIERARCHIE MERCI.
	 */
	public void launchReproduction() {
		this.alphaCouple.reproduce();
	}
	
	
}
