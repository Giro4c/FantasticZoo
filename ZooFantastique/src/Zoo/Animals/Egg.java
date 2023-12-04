package Zoo.Animals;

public class Egg {

	private Creature newBorn;
	private final int incubationTime;
	private int incubationProgress;
	
	
	
	public Egg(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger, boolean isSleeping,
			String indicatorHealth, int incubationTime, int incubationProgress) {
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
		System.out.println("An eggs as hatch a new creature is born !");
		System.out.println("Creature caractèristique : " + newBorn.toString());
	}
	
}
