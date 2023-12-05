package Zoo.Animals;


import Zoo.Enclosure;

public class Oviparous extends Creature {
	private Enclosure enclosure;
	public Oviparous(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger, boolean isSleeping, String indicatorHealth, Enclosure enclosure) {
		super(specie, name, isMale, weight, height, age, indicatorHunger, isSleeping, indicatorHealth, enclosure);
		this.enclosure = enclosure;
		// TODO Auto-generated constructor stub
	}

	public Egg layEgg() {
		if (!this.isMale()) {	
			return new Egg(2,this.enclosure, this);
		}
		return null;
	}
}

