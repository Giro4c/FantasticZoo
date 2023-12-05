package Zoo.Animals;

import Zoo.Enclosure;
import Zoo.Caracteristics.CanFly;
import Zoo.Caracteristics.Revivable;

public class Phenix extends Oviparous implements CanFly, Revivable {

    public static final int minHeight = 50;
    public static final int maxHeight = 100;
    public static final int minWeight = 5;
    public static final int maxWeight = 10;

    public Phenix(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger,
            boolean isSleeping, String indicatorHealth, Enclosure enclosure) {
        super(specie, name, isMale, weight, height, age, indicatorHunger, isSleeping, indicatorHealth, enclosure);

        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
    }
}
