package Colony;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Pack {

	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					   ATTRIBUTES
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	private static int idPack = 0;
	private ArrayList<Werewolf> members;
	private Territory territory;
	private AlphaCouple alphaCouple;

	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					GETTERS / SETTERS
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	public int getId() {
		return this.idPack;
	}
	
	public void setId(int id) {
		this.idPack = id; }
	
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
		
		if (members.size() < 2 || !Utils.containsMaleAndFemale(members)) 
	        throw new IllegalArgumentException("Le pack doit avoir au moins un mâle et une femelle.");
		
		if (territory.getCurrentPack() != null)
	        throw new IllegalArgumentException("Un territoire ne peut contenir qu'une seule meute");

		if (!Utils.containsMaleAndFemale(members))
	        throw new IllegalArgumentException("La meute ne peut être créer sans qu'il y ai au minimum un male et une femelle");
		
		this.members = members;
		this.territory = territory;
		this.territory.setCurrentPack(this);
		this.idPack += 1;
		
        createNewHierarchy(this);
		
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
	
	public String toStringWithoutAlphaCouple() {
	    return "Pack [members=" + members + ", territory=" + territory + "]";
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
	public void createNewHierarchy(Pack pack) {
		constituteAlphaCouple(pack.getStrongestMale());
		
	    Werewolf alphaMale = pack.getAlphaCouple().getMale();
	    Werewolf alphaFemale = pack.getAlphaCouple().getFemale();

	    // Pour les autres loups, on les classe et on leur attribue un rang
	    ArrayList<Werewolf> nonAlphas = new ArrayList<>(pack.getMembers());
	    nonAlphas.remove(alphaMale);
	    nonAlphas.remove(alphaFemale);

	    Collections.sort(nonAlphas, Comparator.comparingInt(Werewolf::getStrength).reversed().thenComparingInt(Werewolf::getLevel));

	    char currentRank = 'β'; // On commence avec le rang après Alpha

	    for (Werewolf wolf : nonAlphas) {

	        // Si le loup est le même niveau que le précédent, on ne change pas de rang
	        if (nonAlphas.indexOf(wolf) > 0) {
	            Werewolf previousWolf = nonAlphas.get(nonAlphas.indexOf(wolf) - 1);
	            if (wolf.getStrength() == previousWolf.getStrength() && wolf.getLevel() == previousWolf.getLevel()) {
	                wolf.setRank(previousWolf.getRank());
	            }
	        }

	        // Si on atteint Omega, on met tous dans le rang avant omega (pour omega ca sera apres)
	        if (currentRank == 'ω') {
	            currentRank = 'β';
	            wolf.setRank(currentRank);
	        } else {
	        	wolf.setRank(currentRank);
	            currentRank++;
	        }
	    }
	    declareOmegas();
	}
	
	/**
	 * Changes / Updates the hierarchy within the pack : Lower the ranks if necessary, constitute new alpha couple if necessary, etc...
	 * 
	 */
	public void updateHierarchy() {
	    for (Werewolf wolf : members) 
	        wolf.naturalRankDecrease();
	    
	    if (this.alphaCouple.getMale().getRank() != 'α') {
	    	this.alphaCouple.setMale(null);
	    	constituteAlphaCouple(this.getStrongestMale());
	    }
		}
	
	
	
	public Werewolf getStrongestWolf() {
	    if (members.isEmpty()) {
	    	System.out.print("la meute est vide");
	        return null; 
	    }


	    Collections.sort(members, Comparator.comparingInt(Werewolf::getStrength).reversed());
	    Werewolf strongestWolf = members.get(0);

	    for (int i = 1; i < members.size(); i++) {
	        Werewolf currentWolf = members.get(i);

	        if (currentWolf.getStrength() == strongestWolf.getStrength()) {
	            if (currentWolf.getLevel() > strongestWolf.getLevel()) {
	                strongestWolf = currentWolf;
	            } else if (currentWolf.getLevel() == strongestWolf.getLevel()) {
	            	if (Math.random() < 0.5) {
	                    strongestWolf = currentWolf;	      
	                
	                }
	            }
	        }
	    }
	    return strongestWolf;
	}
	
	
	public Werewolf getStrongestMale() {
	    if (members.isEmpty()) {
	    	System.out.print("la meute est vide");
	        return null; 
	    }

	    ArrayList<Werewolf> males = new ArrayList<>();
	    for (Werewolf member : members) {
	        if (member.isMale()) {
	            males.add(member);
	        }
	    }

	    if (males.isEmpty()) {
	    	System.out.print("Aucun male trouvé dans la meute");
	        return null; 
	    }

	    Collections.sort(males, Comparator.comparingInt(Werewolf::getStrength).reversed());
	    Werewolf strongestMale = males.get(0);

	    for (int i = 1; i < males.size(); i++) {
	        Werewolf currentMale = males.get(i);

	        if (currentMale.getStrength() == strongestMale.getStrength()) {
	            if (currentMale.getLevel() > strongestMale.getLevel()) {
	                strongestMale = currentMale;
	            } else if (currentMale.getLevel() == strongestMale.getLevel()) {
	            	if (Math.random() < 0.5) {
	                    strongestMale = currentMale;	      
	                
	                }
	            }
	        }
	    }
	    return strongestMale;
	}

	 
	 
	public Werewolf getStrongestFemale() {
	    if (members.isEmpty()) {
	    	System.out.print("la meute est vide");
	        return null; 
	    }

	    ArrayList<Werewolf> females = new ArrayList<>();
	    for (Werewolf member : members) {
	        if (!member.isMale()) {
	            females.add(member);
	        }
	    }

	    if (females.isEmpty()) {
	    	System.out.print("Aucune femelle trouvée dans la meute");
	        return null; 
	    }

	    Collections.sort(females, Comparator.comparingInt(Werewolf::getStrength).reversed());
	    Werewolf strongestFemale = females.get(0);

	    for (int i = 1; i < females.size(); i++) {
	        Werewolf currentFemale = females.get(i);

	        if (currentFemale.getStrength() == strongestFemale.getStrength()) {
	            if (currentFemale.getLevel() > strongestFemale.getLevel()) {
	                strongestFemale = currentFemale;
	            } else if (currentFemale.getLevel() == strongestFemale.getLevel()) {
	            	if (Math.random() < 0.5) {
	                    strongestFemale = currentFemale;	
	                }
	            }
	        }
	    }

	    return strongestFemale;
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
		
		/*for (Werewolf member : this.members )
			if (member.isMale() == false) {
	            if (strongestFemale == null || Utils.isDominant(member.getRank(), strongestFemale.getRank())) {
	                strongestFemale = member;
	            }
	        }*/
		strongestFemale = this.getStrongestFemale();
		
		
		// Constituer nouveau couple alpha
		if (strongestFemale != null) {
			maleAlpha.setRank('α');
			strongestFemale.setRank('α');
	        this.alphaCouple = new AlphaCouple(maleAlpha, strongestFemale, this);
	        this.alphaCouple.setPack(this);
        }
		else {
			System.out.println("Aucune femelle trouvée pour constituer le nouveau couple");
		}
	}
	
	/**
	 * Change the werewolves' rank to omega (lowest rank) for any werewolf with lower than pack average strength.
	 */
	public void declareOmegas() {
	    if (members.isEmpty()) {
	        System.out.println("La meute est vide.");
	        return;
	    }

	    int totalStrength = 0;
	    int countWolfs = 0;

	    for (Werewolf wolf : members) {
	        totalStrength += wolf.getStrength();
	        countWolfs++;
	    }

	    int averageStrength = totalStrength / countWolfs;

	    for (Werewolf wolf : members) {
	        if (wolf.getStrength() < averageStrength && wolf != this.alphaCouple.getMale() && wolf != this.alphaCouple.getFemale()) {
	            wolf.setRank('ω');
	        }
	    }
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
	
	public void launchDominations (){
	    for (Werewolf agressor : members) {
	        for (Werewolf target : members) {
	            if (agressor != target && agressor.canDominate(target)) {
	            	agressor.dominate(target);
	            }
	        }
	    }
	}
	
	
}
