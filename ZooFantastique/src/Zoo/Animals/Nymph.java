package Zoo.Animals;

import Zoo.Enclosure;
import Zoo.Caracteristics.Revivable;

public class Nymph extends Mammal implements Revivable {

    public static final int minHeight = 30;
    public static final int maxHeight = 50;
    public static final int minWeight = 10;
    public static final int maxWeight = 20;
    public static final int GESTATION_TIME = 5;
    
    
    public Nymph(boolean isMale, int age, Enclosure enclosure) {
		super(Nymph.class.getSimpleName(), isMale, age, enclosure, minHeight, maxHeight, minWeight, maxWeight, GESTATION_TIME, 0);

	}

	public Nymph(boolean isMale, int weight, int height, int age, Enclosure enclosure) {
		super(Nymph.class.getSimpleName(), isMale, weight, height, age, enclosure, GESTATION_TIME, 0);
        
        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
	}

	public Nymph(String name, boolean isMale, int weight, int height, int age, Enclosure enclosure) {
		super(Nymph.class.getSimpleName(), name, isMale, weight, height, age, enclosure, GESTATION_TIME, 0);
        
        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
	}

	
}
