package Zoo.Animals;

public class Creature {
	
	public static final String[] HUNGER_STATES = {"Full", "Normal", "Hungry", "Famished", "Dead"};
	public static final String[] HEALTH_STATES = {"Perfect", "Normal", "Sick", "Very Sick", "Dead"};
	
	
	private String specie;
	private String name;
	private boolean isMale;
	private int weight;
	private int height;
	private int age;
	private String indicatorHunger;
	private boolean isSleeping;
	private String indicatorHealth;
	
	public Creature(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger,
		boolean isSleeping, String indicatorHealth) {
		super();
		this.specie = specie;
		this.name = name;
		this.isMale = isMale;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.indicatorHunger = indicatorHunger;
		this.isSleeping = isSleeping;
		this.indicatorHealth = indicatorHealth;
	}
	

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


	public String getIndicatorHunger() {
		return indicatorHunger;
	}


	public void setIndicatorHunger(String indicatorHunger) {
		this.indicatorHunger = indicatorHunger;
	}
	
	public void becomeMoreHungry() {
		if (this.indicatorHunger.equals("Full")) {
			this.indicatorHunger = "Normal";
		}
		else if (this.indicatorHunger.equals("Normal")) {
			
		}
		else if (this.indicatorHunger.equals("Hungry")) {
			
		}
		else if (this.indicatorHunger.equals("Famished")) {
			
		}
	}


	public boolean isSleeping() {
		return isSleeping;
	}


	public void setSleeping(boolean isSleeping) {
		this.isSleeping = isSleeping;
	}


	public String getIndicatorHealth() {
		return indicatorHealth;
	}


	public void setIndicatorHealth(String indicatorHealth) {
		this.indicatorHealth = indicatorHealth;
	}
	
	@Override
	public String toString() {
		return "Creature [specie=" + specie + ", isMale=" + isMale + ", weight=" + weight + ", height=" + height
				+ ", age=" + age + ", indicatorHunger=" + indicatorHunger + ", isSleeping=" + isSleeping
				+ ", indicatorHealth=" + indicatorHealth + "]";
	}


	public void eat() {
		System.out.println(this.getSpecie() + " " + this.getName() + " eats.");
		
	}
	
	public void emitSound() {
		System.out.println("The creature " + this.name + "emit a sound !");
	}
	
	public void heal() {
		System.out.println("The creature " + this.name + " is healing" );
	}
	
	public void sleep() {
		System.out.println("The creature " + this.name + " is sleeping" );
	}
	
	public void wake() {
		System.out.println("The creature " + this.name + " is awake" );
	}
	
	public void getOlder() {
		System.out.println("The creature " + this.name + " is getting older" );
	} // getOlder
	
	public void die() {
		System.out.println("The creature " + this.name + " is dead ahahahahaha he suck" );
	} // die

} // Creature
