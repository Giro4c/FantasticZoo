package Zoo.Animals;

import java.util.Random;

public class Oviparous extends Creature {
	
	public Oviparous(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger, boolean isSleeping, String indicatorHealth) {
		super(specie, name, isMale, weight, height, age, indicatorHunger, isSleeping, indicatorHealth);
		// TODO Auto-generated constructor stub
	}

	public Egg layEgg() {
		if (this.isMale()==False) {	
			Random random = new Random();
			boolean randomBoolean = random.nextBoolean();
			int randomheight = random.nextInt(6) + 25;
			int randomWeight = random.nextInt(1001) + 1500;
			return new Egg(this.getSpecie(), "name", randomBoolean, randomWeight, randomheight, 0, "Full", false, "Perfect", this.incubationTime, null);
		}
		return null;
	}
	
}
