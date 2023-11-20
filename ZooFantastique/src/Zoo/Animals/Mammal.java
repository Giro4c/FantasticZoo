package Zoo.Animals;

import java.util.Random;

import Zoo.Enclosure;

public class Mammal extends Creature {

	private final int gestationTime;
	private int gestationProgress;
	private Enclosure enclosure;
	
	
	public Mammal(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger,
			boolean isSleeping, String indicatorHealth, int gestationTime, int gestationProgress, Enclosure enclosure) {
		super(specie, name, isMale, weight, height, age, indicatorHunger, isSleeping, indicatorHealth);
		this.gestationTime = gestationTime;
		this.gestationProgress = gestationProgress;
		this.setEnclosure(enclosure);
	}



	public int getGestationProgress() {
		return gestationProgress;
	}



	public void setGestationProgress(int gestationProgress) {
		this.gestationProgress = gestationProgress;
	}



	public int getGestationTime() {
		return gestationTime;
	}



	public Creature giveBirth() {
		this.gestationProgress = 0;
		Random random = new Random();
		boolean randomBoolean = random.nextBoolean();
		int randomheight = random.nextInt(6) + 25;
		int randomWeight = random.nextInt(1001) + 1500;
		Creature newborn = new Creature(this.getSpecie(), "name", randomBoolean, randomWeight, randomheight, 0, "Full", false, "Perfect");
		this.enclosure.addCreature(newborn);
		return newborn;
	}
	
	public void reproduction(){
		if(isMale()==false){
			this.gestationProgress = 0;
		}
	}



	public Enclosure getEnclosure() {
		return enclosure;
	}



	public void setEnclosure(Enclosure enclosure) {
		this.enclosure = enclosure;
	}
}
