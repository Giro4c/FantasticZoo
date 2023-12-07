package Zoo.Animals;

import Zoo.Enclosure;
import Zoo.Caracteristics.CanFly;
import Zoo.Caracteristics.Revivable;

public class Phenix extends Oviparous implements CanFly, Revivable {

    public static final int minHeight = 50;
    public static final int maxHeight = 100;
    public static final int minWeight = 5;
    public static final int maxWeight = 10;

    public Phenix(boolean isMale, int age, Enclosure enclosure) {
		super(Phenix.class.getSimpleName(), isMale, age, enclosure, minHeight, maxHeight, minWeight, maxWeight);
		this.setSpecie(this.getClass().getName());
        
        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
	}

	public Phenix(boolean isMale, int weight, int height, int age, Enclosure enclosure) {
		super(Phenix.class.getSimpleName(), isMale, weight, height, age, enclosure);
		this.setSpecie(this.getClass().getName());
        
        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
	}

	public Phenix(String name, boolean isMale, int weight, int height, int age, Enclosure enclosure) {
		super(Phenix.class.getSimpleName(), name, isMale, weight, height, age, enclosure);
		this.setSpecie(this.getClass().getName());
        
        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
	}

}
