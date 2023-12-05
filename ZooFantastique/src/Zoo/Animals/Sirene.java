package Zoo.Animals;

import Zoo.Enclosure;
import Zoo.Caracteristics.CanSwim;

public class Sirene extends Mammal implements CanSwim {

    public static final int minHeight = 120;
    public static final int maxHeight = 160;
    public static final int minWeight = 50;
    public static final int maxWeight = 80;

    public Sirene(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger,
            boolean isSleeping, String indicatorHealth, int gestationTime, int gestationProgress, Enclosure enclosure) {
        super(specie, name, isMale, weight, height, age, indicatorHunger, isSleeping, indicatorHealth, gestationTime,
                gestationProgress, enclosure);

        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
    }
}
