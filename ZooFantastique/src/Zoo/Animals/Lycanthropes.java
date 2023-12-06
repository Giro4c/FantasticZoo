package Zoo.Animals;

import Zoo.Enclosure;
import Zoo.Caracteristics.CanRun;

public class Lycanthropes extends Mammal implements CanRun {

	public static final int minHeight = 60; 
    public static final int maxHeight = 200; 
    public static final int minWeight = 50;
    public static final int maxWeight = 100;
    public static final int GESTATION_TIME = 2;
	
	public Lycanthropes(boolean isMale, int age, Enclosure enclosure) {
		super(null, isMale, age, enclosure, minHeight, maxHeight, minWeight, maxWeight, GESTATION_TIME, 0);
		this.setSpecie(this.getClass().getName());
	}

	public Lycanthropes(boolean isMale, int weight, int height, int age, Enclosure enclosure) {
		super(null, isMale, weight, height, age, enclosure, GESTATION_TIME, 0);
		this.setSpecie(this.getClass().getName());
        
        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
	}

	public Lycanthropes(String name, boolean isMale, int weight, int height, int age,
			Enclosure enclosure) {
		super(null, name, isMale, weight, height, age, enclosure, GESTATION_TIME, 0);
		this.setSpecie(this.getClass().getName());
        
        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
	}

	
}
