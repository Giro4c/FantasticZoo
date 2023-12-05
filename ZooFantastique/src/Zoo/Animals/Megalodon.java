package Zoo.Animals;

import Zoo.Enclosure;
import Zoo.Caracteristics.CanSwim;

public class Megalodon extends Oviparous implements CanSwim {

    public static final int minHeight = 400; 
    public static final int maxHeight = 600; 
    public static final int minWeight = 5000;
    public static final int maxWeight = 10000;

    public Megalodon(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger,
            boolean isSleeping, String indicatorHealth, Enclosure enclosure) {
        super(specie, name, isMale, weight, height, age, indicatorHunger, isSleeping, indicatorHealth, enclosure);

        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
    }
}
