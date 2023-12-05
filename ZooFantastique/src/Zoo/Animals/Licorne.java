package Zoo.Animals;

import Zoo.Enclosure;
import Zoo.Caracteristics.CanRun;

public class Licorne extends Mammal implements CanRun {

    public static final int minHeight = 150; 
    public static final int maxHeight = 200; 
    public static final int minWeight = 500; 
    public static final int maxWeight = 800; 

    public Licorne(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger,
            boolean isSleeping, String indicatorHealth, int gestationTime, int gestationProgress, Enclosure enclosure) {
        super(specie, name, isMale, weight, height, age, indicatorHunger, isSleeping, indicatorHealth, gestationTime,
                gestationProgress, enclosure);
        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
    }
}
