package Zoo.Animals;

import Zoo.Enclosure;
import Zoo.Caracteristics.Revivable;

public class Nymphe extends Mammal implements Revivable {

    public static final int minHeight = 30;
    public static final int maxHeight = 50;
    public static final int minWeight = 10;
    public static final int maxWeight = 20;
    public static final int GESTATION_TIME = 5;
    
    
    public Nymphe(boolean isMale, int age, Enclosure enclosure) {
		super(null, isMale, age, enclosure, minHeight, maxHeight, minWeight, maxWeight, GESTATION_TIME, 0);
		this.setSpecie(this.getClass().getName());
	}

	public Nymphe(boolean isMale, int weight, int height, int age, Enclosure enclosure) {
		super(null, isMale, weight, height, age, enclosure, GESTATION_TIME, 0);
		this.setSpecie(this.getClass().getName());
        
        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
	}

	public Nymphe(String name, boolean isMale, int weight, int height, int age, Enclosure enclosure) {
		super(null, name, isMale, weight, height, age, enclosure, GESTATION_TIME, 0);
		this.setSpecie(this.getClass().getName());
        
        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
	}

	
}
