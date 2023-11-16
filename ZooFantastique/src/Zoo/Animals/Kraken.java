package Zoo.Animals;

import Zoo.Caracteristics.CanSwim;

public class Kraken extends Oviparous implements CanSwim {
	
	public Kraken(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger,
			boolean isSleeping, String indicatorHealth) {
		super(specie, name, isMale, weight, height, age, indicatorHunger, isSleeping, indicatorHealth);
		this.setHeightMin(1);
	}

	
	
}
