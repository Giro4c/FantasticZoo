package Zoo.Animals;

import Zoo.Enclosure;
import Zoo.Caracteristics.CanRun;
import Zoo.Caracteristics.CanSwim;
import Zoo.Caracteristics.CanFly;
import Zoo.Caracteristics.Revivable;

public class Dragon extends Oviparous implements CanRun, CanSwim, CanFly, Revivable {

	
    public static final int minHeight = 200;
    public static final int maxHeight = 300;
    public static final int minWeight = 200;
    public static final int maxWeight = 500;

    public Dragon(boolean isMale, int age, Enclosure enclosure) {
		super(Dragon.class.getSimpleName(), isMale, age, enclosure, minHeight, maxHeight, minWeight, maxWeight);
		
	}

	public Dragon(boolean isMale, int weight, int height, int age, Enclosure enclosure) {
		super(Dragon.class.getSimpleName(), isMale, weight, height, age, enclosure);
		
		
        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
	}

	public Dragon(String name, boolean isMale, int weight, int height, int age, Enclosure enclosure) {
		super(Dragon.class.getSimpleName(), name, isMale, weight, height, age, enclosure);
	
		
        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
	}
	

}
