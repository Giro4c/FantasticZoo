package Zoo.Animals;

import java.util.Random;

import Zoo.Enclosure;

public class Oviparous extends Creature {
	private Enclosure enclosure;

	public Oviparous(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger, boolean isSleeping, String indicatorHealth, Enclosure enclosure) {
		super(specie, name, isMale, weight, height, age, indicatorHunger, isSleeping, indicatorHealth, enclosure);
		this.enclosure = enclosure;
		// TODO Auto-generated constructor stub
	}

	public Egg layEgg() {
		if (!this.isMale()) {	
			Random random = new Random();
			boolean randomBoolean = random.nextBoolean();
			int randomheight = random.nextInt(6) + 25;
			int randomWeight = random.nextInt(1001) + 1500;
			return new Egg(this.getSpecie(), "name", randomBoolean, randomWeight, randomheight, 0, "Full", false, "Perfect", 2, 0, this.enclosure, this);
		}
		return null;
	}
}

