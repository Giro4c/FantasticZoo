package Zoo.Animals;

import java.util.Random;
import Zoo.Enclosure;
import ZooFantastique.src.Zoo.Desease;

public class Creature implements Runnable{
	
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
	private boolean isSick;
	private Enclosure enclosure;
	private Desease hasDesease;
	// Height
	private int heightMin = 0;

	public void setHeightMin(int min){
		heightMin = min;
	}
	
	public Creature(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger,
		boolean isSleeping, String indicatorHealth, Enclosure enclosure) {
		super();
		this.specie = specie;
		this.name = name;
		this.isMale = isMale;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.indicatorHunger = indicatorHunger;
		this.isSleeping = false;
		this.indicatorHealth = indicatorHealth;
		this.isSick = false;
		this.enclosure = enclosure;
	}
	
	@Override 
	public void run() {
		
		Random random = new Random();
		while(true) {
			
			if ( HUNGER_STATES.equals("Dead") || HEALTH_STATES.equals("Dead") ) {
				this.die();
			}
			
			try {
				synchronized (this) {
					int randomNumberSleep = random.nextInt(15001) + 10000;
					this.wait(randomNumberSleep);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			int RandomNumber = random.nextInt(100);
			
			if ( RandomNumber > (1 - this.percentageSick()) && !(this.isSick)) {
				this.isSick = true;
			}
			
			if ( RandomNumber < 5) {
				this.getOlder();
			}
				
			if ( this.isSleeping ) {
				if ( RandomNumber < 15) {
					this.wake();
				}
			}
			else {
				if ( RandomNumber < 10) {
					this.sleep();
				}
				if ( RandomNumber > 10 && RandomNumber < 18) {
					this.eat();
				}
				if ( RandomNumber > 18 && RandomNumber < 20) {
					this.emitSound();
				}
				if ( RandomNumber > 20 && RandomNumber < 25) {
					this.becomeMoreHungry();
				}
			}
		}
	}
	

	public String getSpecie() {
			return specie;
	}
	public void setDesease(Desease d){
		this.hasDesease = d;
	}


	public void setSpecie(String specie) {
		this.specie = specie;
	}


	public boolean isSick() {
		return isSick;
	}

	public void setSick(boolean isSick) {
		this.isSick = isSick;
	}
	
	public int percentageSick () {
		int percentage = 1;
		
		if (this.indicatorHunger.equals("Normal")) {
			percentage += 1;
		}
		else if (this.indicatorHunger.equals("Hungry")) {
			percentage += 2;
		}
		else if (this.indicatorHunger.equals("Famished")) {
			percentage += 3;
		}
		
		if (this.getEnclosure().getCleanness().equals("Normal")) {
			percentage += 1;
		}
		else if (this.getEnclosure().getCleanness().equals("Dirty")) {
			percentage += 2;
		}
		else if (this.getEnclosure().getCleanness().equals("Moundir's Room")) {
			percentage += 3;
		}
		
		for (Creature crea : this.getEnclosure().getPresentCreatures()) {
			if ( crea.isSick ) {
				percentage += 1;
			}
		}
		
		return percentage;		
	}

	public String getName() {
		return name;
	}

	public void setEnclosure(Enclosure enclosure) {
		this.enclosure = enclosure;
		
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


	public Enclosure getEnclosure() {
		return enclosure;
	}

	public void setEnclosure(Enclosure enclosure) {
		this.enclosure = enclosure;
	}

	public void setIndicatorHunger(String indicatorHunger) {
		this.indicatorHunger = indicatorHunger;
	}
	
	public void becomeMoreHungry() {
		if (this.indicatorHunger.equals("Full")) {
			this.indicatorHunger = "Normal";
		}
		else if (this.indicatorHunger.equals("Normal")) {
			this.indicatorHunger = "Hungry";
		}
		else if (this.indicatorHunger.equals("Hungry")) {
			this.indicatorHunger = "Famished";
		}
		else if (this.indicatorHunger.equals("Famished")) {
			this.indicatorHunger = "Dead";
		}
	}
	
	public void becomeMoreSick(){
		if(this.indicatorHealth.equals("Perfect")){this.indicatorHealth="Normal";}
		if (this.indicatorHealth.equals("Normal")){this.indicatorHealth="Sick";}
		if (this.indicatorHealth.equals("Sick")){this.indicatorHealth="Very Sick";}
		if (this.indicatorHealth.equals("Very Sick")){
			this.indicatorHealth="Dead";
			this.die();
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

	public void treat(){
		this.hasDesease.remove(this);
	}

	public void eat() {
		if (this.indicatorHunger.equals("Normal")) {
			this.indicatorHunger = "Full";
		}
		else if (this.indicatorHunger.equals("Hungry")) {
			this.indicatorHunger = "Normal";
		}
		else if (this.indicatorHunger.equals("Famished")) {
			this.indicatorHunger = "Hungry";
		}
		//System.out.println(this.getSpecie() + " " + this.getName() + " eats.");
	}
	
	public void emitSound() {
		System.out.println("The creature " + this.name + "emit a sound !");
	}
	
	public void heal() {
		if (this.indicatorHunger.equals("Very Sick")) {
			this.indicatorHunger = "Sick";
		}
		else if (this.indicatorHunger.equals("Sick")) {
			this.indicatorHunger = "Normal";
		}
		else if (this.indicatorHunger.equals("Normal")) {
			this.indicatorHunger = "Perfect";
		}
		System.out.println("The creature "+ this.getName() + " has been healed, its health is now : "+ this.indicatorHealth);
	}
	
	public void sleep() {
		this.isSleeping = true;
	}
	
	public void wake() {
		this.isSleeping = false;
	}
	
	public void getOlder() {
		this.setAge(this.getAge()+ 1);
	}
	
	public void die() {
		// a faire
	}


}