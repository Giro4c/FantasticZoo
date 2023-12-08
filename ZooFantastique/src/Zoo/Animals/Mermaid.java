package Zoo.Animals;

import Zoo.Enclosure;
import Zoo.Caracteristics.CanSwim;

public class Mermaid extends Mammal implements CanSwim {

    public static final int minHeight = 120;
    public static final int maxHeight = 160;
    public static final int minWeight = 50;
    public static final int maxWeight = 80;
    public static final int GESTATION_TIME = 5;

    public Mermaid(boolean isMale, int age, Enclosure enclosure) {
		super(Mermaid.class.getSimpleName(), isMale, age, enclosure, minHeight, maxHeight, minWeight, maxWeight, GESTATION_TIME, 0);
	}

	public Mermaid(boolean isMale, int weight, int height, int age, Enclosure enclosure) {
		super(Mermaid.class.getSimpleName(), isMale, weight, height, age, enclosure, GESTATION_TIME, 0);

        
        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
	}

	public Mermaid(String name, boolean isMale, int weight, int height, int age, Enclosure enclosure) {
		super(Mermaid.class.getSimpleName(), name, isMale, weight, height, age, enclosure, GESTATION_TIME, 0);
        
        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);		
	}

}
