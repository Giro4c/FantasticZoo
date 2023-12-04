package Zoo.Animals;

import Zoo.Enclosure;
import Zoo.Caracteristics.CanFly;
import Zoo.Caracteristics.CanRun;
import Zoo.Caracteristics.CanSwim;
import Zoo.Caracteristics.Revivable;

public class Dragon extends Oviparous implements CanRun, CanSwim, CanFly, Revivable {

	public Dragon(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger,
			boolean isSleeping, String indicatorHealth, Enclosure enclosure) {
		super(specie, name, isMale, weight, height, age, indicatorHunger, isSleeping, indicatorHealth, enclosure);
		// TODO Auto-generated constructor stub
	}
	
	
}
