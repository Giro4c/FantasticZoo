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
	
	private Werewolf male;
	private Werewolf female;
	private Pack pack;
	private ArrayList<Werewolf> childrens;
	
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
		this.childrens = new ArrayList<>();
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
		if(this.male.getRank() == 'α' && this.female.getRank() == 'α') {
			if(!Colony.matingSeason()) {
				Random rand = new Random();
				int newWolfNb = rand.nextInt(1,7);
				for(int i=0; i<newWolfNb; i++) {
					boolean sex = ThreadLocalRandom.current().nextBoolean();
					Scanner sc = new Scanner(System.in);
		        	System.out.println("Veuillez saisir un nom pour le loup " + (i+1) + " : ");
		        	String str = sc.nextLine();
		        	int randomH = rand.nextInt(140, 150);
		        	int randomW = rand.nextInt(30, 45);
					Werewolf newWolf = new Werewolf(this.female.getSpecie(), str, sex, randomW, randomH, 1,
							"Young", false, this.male.getStrength()/2, this.male.getDominationFactor()/2, 
							'β', 0, this.male.getArroganceFactor()/2, this.pack);
					this.pack.packMemberJoins(newWolf);
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
