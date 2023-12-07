package Zoo.Animals;


import Zoo.Enclosure;

public class Oviparous extends Creature {
	public int incubationTime;
	
	public Oviparous(String specie, String name, boolean isMale, int weight, int height,int age, Enclosure enclosure) {
		super(specie, name, isMale, weight, height, age, enclosure);
	}
	
	public Oviparous(String specie, boolean isMale, int age, Enclosure enclosure, int heightMin, int heightMax,
			int weightMin, int weightMax) {
		super(specie, isMale, age, enclosure, heightMin, heightMax, weightMin, weightMax);
	}

	public Oviparous(String specie, boolean isMale, int weight, int height, int age, Enclosure enclosure) {
		super(specie, isMale, weight, height, age, enclosure);
	}
	

	public Egg layEgg() {
		if (!this.isMale()) {	
			return new Egg(incubationTime, this.getEnclosure(), this);
		}
		return null;
	}
}

