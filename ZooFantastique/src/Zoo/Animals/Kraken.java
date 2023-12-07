package Zoo.Animals;

import Zoo.Enclosure;
import Zoo.Caracteristics.CanSwim;

public class Kraken extends Oviparous implements CanSwim {
	
	public static final int minHeight = 10;
	public static final int maxHeight = 20;
	public static final int minWeight = 6000;
	public static final int maxWeight = 10000;
	
	
	public Kraken(boolean isMale, int age, Enclosure enclosure) {
		super(null, isMale, age, enclosure, minHeight, maxHeight, minWeight, maxWeight);
		this.setSpecie(this.getClass().getName());
		
		this.setHeightMin(minHeight);
		this.setHeightMax(maxHeight);
		this.setWeightMin(minWeight);
		this.setWeightMax(maxWeight);
	}

	public Kraken(boolean isMale, int weight, int height, int age, Enclosure enclosure) {
		super(null, isMale, weight, height, age, enclosure);
		this.setSpecie(this.getClass().getName());
		
		this.setHeightMin(minHeight);
		this.setHeightMax(maxHeight);
		this.setWeightMin(minWeight);
		this.setWeightMax(maxWeight);
	}

	public Kraken(String name, boolean isMale, int weight, int height, int age, Enclosure enclosure) {
		super(null, name, isMale, weight, height, age, enclosure);
		this.setSpecie(this.getClass().getName());
		
		this.setHeightMin(minHeight);
		this.setHeightMax(maxHeight);
		this.setWeightMin(minWeight);
		this.setWeightMax(maxWeight);
	}

}
