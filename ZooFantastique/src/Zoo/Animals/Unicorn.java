package Zoo.Animals;

import Zoo.Enclosure;
import Zoo.Caracteristics.CanRun;

public class Unicorn extends Mammal implements CanRun {

    public static final int minHeight = 150; 
    public static final int maxHeight = 200; 
    public static final int minWeight = 500; 
    public static final int maxWeight = 800; 
    public static final int GESTATION_TIME = 4;

    public Unicorn(boolean isMale, int age, Enclosure enclosure) {
		super(Unicorn.class.getSimpleName(), isMale, age, enclosure, minHeight, maxHeight, minWeight, maxWeight, GESTATION_TIME, 0);
	}

	public Unicorn(boolean isMale, int weight, int height, int age, Enclosure enclosure) {
		super(Unicorn.class.getSimpleName(), isMale, weight, height, age, enclosure, GESTATION_TIME, 0);
        
        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
	}

	public Unicorn(String name, boolean isMale, int weight, int height, int age, Enclosure enclosure) {
		super(Unicorn.class.getSimpleName(), name, isMale, weight, height, age, enclosure, GESTATION_TIME, 0);
        
        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
	}

}
