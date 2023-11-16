package Zoo.Animals;

public class Mammal extends Creature {

	private final int gestationTime;
	private int gestationProgress;
	
	
	
	public Mammal(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger,
			boolean isSleeping, String indicatorHealth, int gestationTime, int gestationProgress) {
		super(specie, name, isMale, weight, height, age, indicatorHunger, isSleeping, indicatorHealth);
		this.gestationTime = gestationTime;
		this.gestationProgress = gestationProgress;
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
		
	}
	
	public void reproduction(){
		if(isMale()==false){
			this.gestationProgress = 0;
		}
	}
}
