package Colony;

import java.util.Random;

public class Creature {
	
	public static final String[] AGE_RANGES = {"Young", "Adult", "Elder"};
	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					   ATTRIBUTES
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	/**
	 * The name of the creature's species.
	 */
	private String specie = "Lycanthrope";
	
	/**
	 * The name of the creature.
	 * No creature has the same name.
	 */
	private String name;
	
	/**
	 * The gender of the creature :<br>
	 * <ul>
	 * <li>Is true if creature is a male.</li>
	 * <li>Is false if creature is a female.</li>
	 * </ul>
	 */
	private boolean isMale;
	
	/**
	 * The weight of the creature.
	 */
	private int weight;
	
	/**
	 * The height of a creature.
	 */
	private int height;
	
	/**
	 * The age of the creature.
	 */
	private int age;
	
	/**
	 * The age category to which belong the werewolf. Depends on the age.
	 */
	private String ageRange;
	
	/**
	 * Indicates whether the creature is sleeping or not.
	 */
	private boolean isSleeping = false;
	
	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					GETTERS / SETTERS
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}

	public boolean isSleeping() {
		return isSleeping;
	}

	public void setSleeping(boolean isSleeping) {
		this.isSleeping = isSleeping;
	}

	public static String[] getAgeRanges() {
		return AGE_RANGES;
	}

	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					  CONSTRUCTORS
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */
	
	
	public Creature() {
		super();
		
        this.name = Utils.randomWolfName();
		
		Random randomage = new Random();
        this.age = randomage.nextInt(101);
		
        Random randomsex = new Random();
        this.isMale = randomsex.nextBoolean();
        
		Random randomweight = new Random();
		int randomWeight = randomweight.nextInt(151) + 50;
		this.weight = randomWeight;
		

	    Random random = new Random();
		int randomHeight = random.nextInt(151) + 100;
		this.height = randomHeight;
		
		
		if (this.age < 20) 
			this.ageRange = "Young";
		else if (this.age >= 30 || this.age < 70)
			this.ageRange = "Adult";
		else
			this.ageRange = "Elder";
	}

	/* ------------------------------------------------- *
	 * ------------------------------------------------- *
	 * 					   TO_STRING
	 * ------------------------------------------------- *
	 * ------------------------------------------------- */


	@Override
	public String toString() {
		return "specie=" + specie + ", name=" + name + ", isMale=" + isMale + ", weight=" + weight
				+ ", height=" + height + ", age=" + age + ", ageRange=" + ageRange + ", isSleeping=" + isSleeping + "]";
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
	
	public void sleep() {
		System.out.println("The creature " + this.name + " is sleeping" );
	}
	
	public void wake() {
		System.out.println("The creature " + this.name + " is awake" );
	}
	
	public void getOlder() {
		this.age += 1;
	}
	


}
