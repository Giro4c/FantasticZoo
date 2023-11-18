package Zoo.Animals;

import Zoo.Enclosure;

public class Egg {

	private Creature newBorn;
	private final int incubationTime;
	private int incubationProgress;
	private Enclosure enclosure;
	
	
	
	public Egg(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger, boolean isSleeping,
			String indicatorHealth, int incubationTime, int incubationProgress, Enclosure enclosure) {
		this.newBorn = new Creature(specie, name, isMale, weight, height, age, indicatorHunger, isSleeping, indicatorHealth);
		this.incubationTime = incubationTime;
		this.incubationProgress = incubationProgress;
		this.enclosure = enclosure;
	}

	public int getIncubationTime() {
		return incubationTime;
	}

	public int getIncubationProgress() {
		return incubationProgress;
	}

	public void setIncubationProgress(int incubationProgress) {
		this.incubationProgress = incubationProgress;
	}


	@Override
	public String toString() {
		return "Egg [incubationTime=" + incubationTime + ", incubationProgress=" + incubationProgress + "]";
	}
	
	public Enclosure getEnclosure(Egg egg) {
		return this.enclosure;
	}
	public Oviparous hatch(Egg egg) {
		if(egg.getIncubationProgress()==egg.getIncubationTime()) {
			Oviparous newoviparous = new Oviparous("test", "test", false, 0, 0, 0, "Full", false, "Perfect", this.enclosure);
			this.enclosure.removeEgg(egg);
			this.enclosure.addCreature(newoviparous);
			return newoviparous;	
		}
		return null;
	}
	
}
