package Zoo.Animals;

import Zoo.Enclosure;
import Zoo.Caracteristics.Revivable;

public class Nymphe extends Mammal implements Revivable {

    public static final int minHeight = 30;
    public static final int maxHeight = 50;
    public static final int minWeight = 10;
    public static final int maxWeight = 20;

    public Nymphe(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger,
            boolean isSleeping, String indicatorHealth, int gestationTime, int gestationProgress, Enclosure enclosure) {
        super(specie, name, isMale, weight, height, age, indicatorHunger, isSleeping, indicatorHealth, gestationTime,
                gestationProgress, enclosure);

        this.setHeightMin(minHeight);
        this.setHeightMax(maxHeight);
        this.setWeightMin(minWeight);
        this.setWeightMax(maxWeight);
    }
}
