package Zoo.Animals;

import Zoo.Enclosure;
import Zoo.Caracteristics.CanSwim;

public class Sirene extends Mammal implements CanSwim {

    public static final int minHeight = 120;
    public static final int maxHeight = 160;
    public static final int minWeight = 50;
    public static final int maxWeight = 80;
    public static final int GESTATION_TIME = 5;

    public Sirene(boolean isMale, int age, Enclosure enclosure) {
		super(null, isMale, age, enclosure, minHeight, maxHeight, minWeight, maxWeight, GESTATION_TIME, 0);
		this.setSpecie(this.getClass().getName());
	}

	public Sirene(boolean isMale, int weight, int height, int age, Enclosure enclosure) {
		super(null, isMale, weight, height, age, enclosure, GESTATION_TIME, 0);
		this.setSpecie(this.getClass().getName());
        
        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
	}

	public Sirene(String name, boolean isMale, int weight, int height, int age, Enclosure enclosure) {
		super(null, name, isMale, weight, height, age, enclosure, GESTATION_TIME, 0);
		this.setSpecie(this.getClass().getName());
        
        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);		
	}

}
