package Zoo.Animals;

import Zoo.Enclosure;
import Zoo.Caracteristics.CanSwim;

public class Kraken extends Oviparous implements CanSwim {
	public int minHeight = 10;
	public int maxHeight = 20;
	public int minWeight = 6000;
	public int maxWeight = 10000;
	
	public Kraken(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger,
			boolean isSleeping, String indicatorHealth, Enclosure enclosure) {
		super(specie, name, isMale, weight, height, age, indicatorHunger, isSleeping, indicatorHealth,enclosure);
		this.setHeightMin(minHeight);
		this.setHeightMax(maxHeight);
		this.setWeightMin(minWeight);
		this.setWeightMax(maxWeight);
	}

	
	
}
