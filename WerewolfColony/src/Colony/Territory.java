package Colony;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Territory {

	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					   ATTRIBUTES
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	private static int idTerritory = 0;
	private Pack currentPack;
	private ArrayList<Werewolf> loners;
	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					GETTERS / SETTERS
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	public int getId() {
		return this.idTerritory;
	}
	
	public void setId(int id) {
		this.idTerritory = id; }
	
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
		this.idTerritory += 1;
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
	
	public void addWolf(Werewolf wolf) {
        if (wolf.getPack() == null) {
            this.loners.add(wolf);
        } else {
            this.currentPack.packMemberJoins(wolf);
        }
    }

    public void removeWolf(Werewolf wolf) {
        if (wolf.getPack() == null) {
            this.loners.remove(wolf);
            wolf.setTerritory(null);
        } else {
            this.currentPack.packMemberLeaves(wolf);
            wolf.setTerritory(null);
        }
    }

	
	
	
	public Werewolf getStrongestLonerMale() {
	    if (loners.isEmpty()) {
	    	System.out.print("Aucun solitaire trouvé ici");
	        return null; 
	    }

	    ArrayList<Werewolf> males = new ArrayList<>();
	    for (Werewolf member : loners) {
	        if (member.isMale()) {
	            males.add(member);
	        }
	    }

	    if (males.isEmpty()) {
	    	System.out.print("Aucun male trouvé ici");
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
	
	
	
	
	public Werewolf getStrongestLonerFemale() {
	    if (loners.isEmpty()) {
	    	System.out.print("Aucun solitaire trouvé ici");
	        return null; 
	    }

	    ArrayList<Werewolf> females = new ArrayList<>();
	    for (Werewolf member : loners) {
	        if (!member.isMale()) {
	            females.add(member);
	        }
	    }

	    if (females.isEmpty()) {
	    	System.out.print("Aucune femelle trouvée ici");
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
	
	

	
	
	
}
