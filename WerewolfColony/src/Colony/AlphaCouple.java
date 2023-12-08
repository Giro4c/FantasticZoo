package Colony;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class AlphaCouple {

	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					   ATTRIBUTES
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	private ArrayList<Werewolf> couple;
	private Werewolf male;
	private Werewolf female;
	private Pack pack;
	private ArrayList<Werewolf> childrens;
	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					GETTERS / SETTERS
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	public ArrayList<Werewolf> getCouple (){
		return this.couple;
	}
	
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
		this.childrens = new ArrayList<>();
		this.couple = new ArrayList<>();
		this.couple.add(male);
		this.couple.add(female);
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
	    return "AlphaCouple [male=" + male + ", female=" + female;
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
		if(this.male.getRank() == 'α' && this.female.getRank() == 'α') {
			if(Colony.matingSeason()) {
				Random rand = new Random();
				int newWolfNb = rand.nextInt(1,7);
				for(int i=0; i<newWolfNb; i++) {
					Werewolf newWolf = new Werewolf(this.getPack());
					newWolf.setAge(0);
					childrens.add(newWolf);
				}
				System.out.println(newWolfNb+ " nouveaux loups sont nées !");
			}
		}
	}
	
	/**
	 * Shows the characteristics of the alpha couple
	 */
	public void showCharacteristics() {
		System.out.println(this.toString());
	}
	public void showChildren() {
		System.out.println("Le couple " + this.male.getName() +" et " + this.female.getName()+ " à "+ childrens.size() + " enfants :");
		for (int i = 0; i<childrens.size(); i++) {
			System.out.println("Loup[nom= "+childrens.get(i).getName()+", rank= "+ childrens.get(i).getRank()+
					", niveau= "+ childrens.get(i).getLevel()+ ", meute= "+ childrens.get(i).getPack());
		}
	}
	
}
