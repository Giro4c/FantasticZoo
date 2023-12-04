package Zoo.Animals;

import Zoo.Enclosure;
import Zoo.Caracteristics.CanRun;

public class Licorne extends Mammal implements CanRun {

	public Licorne(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger,
			boolean isSleeping, String indicatorHealth, int gestationTime, int gestationProgress, Enclosure enclosure) {
		super(specie, name, isMale, weight, height, age, indicatorHunger, isSleeping, indicatorHealth, gestationTime,
				gestationProgress, enclosure);
		// TODO Auto-generated constructor stub
	}


	
}
