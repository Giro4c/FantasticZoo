package Zoo.Animals;

public class Egg {

	private Creature newBorn;
	private final int incubationTime;
	private int incubationProgress;
	
	
	
	public Egg(String specie, String name, boolean isMale, int weight, int height, int age, int indicatorHunger, boolean isSleeping,
			int indicatorHealth, int incubationTime, int incubationProgress) {
		this.newBorn = new Creature(specie, name, isMale, weight, height, age, indicatorHunger, isSleeping, indicatorHealth);
		this.incubationTime = incubationTime;
		this.incubationProgress = incubationProgress;
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

	public Creature hatch() {
		
	}
	
}
