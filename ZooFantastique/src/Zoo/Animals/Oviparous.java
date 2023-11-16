package Zoo.Animals;

import java.util.Random;

public class Oviparous extends Creature {
	
	public Oviparous(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger, boolean isSleeping, String indicatorHealth) {
		super(specie, name, isMale, weight, height, age, indicatorHunger, isSleeping, indicatorHealth);
		// TODO Auto-generated constructor stub
	}

	public Egg layEgg() {
		Random random = new Random();
		boolean randomBoolean = random.nextBoolean();
		int randomheight = random.nextInt(6) + 25;
		int randomWeight = random.nextInt(1001) + 1500;
		Egg egg = new Egg(this.getSpecie(), "name", randomBoolean, randomWeight, randomheight, 0, "Full", false, "Perfect", this.incubationTime, null);
	}
	public void reproduction(){
		if (this.isMale()==False) {	
			layEgg(null);
		}
	}
}
