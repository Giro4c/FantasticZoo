package Zoo.Animals;

import java.util.Random;
import java.util.Scanner;

import Zoo.Enclosure;

public class Mammal extends Creature {

	private final int gestationTime;
	private int gestationProgress;
	private Thread incubationThread;
	
	public Mammal(String specie, boolean isMale, int age, Enclosure enclosure, int heightMin, int heightMax,
			int weightMin, int weightMax, int gestationTime, int gestationProgress) {
		super(specie, isMale, age, enclosure, heightMin, heightMax, weightMin, weightMax);
		this.gestationTime = gestationTime;
		this.gestationProgress = gestationProgress;
	}



	public Mammal(String specie, boolean isMale, int weight, int height, int age, Enclosure enclosure, int gestationTime, int gestationProgress) {
		super(specie, isMale, weight, height, age, enclosure);
		this.gestationTime = gestationTime;
		this.gestationProgress = gestationProgress;
	}



	public Mammal(String specie, String name, boolean isMale, int weight, int height, int age, Enclosure enclosure, int gestationTime, int gestationProgress) {
		super(specie, name, isMale, weight, height, age, enclosure);
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
	
	public void gestation() {
		 incubationThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (getGestationProgress() <= getGestationTime()) {
                    try {
                        Thread.sleep(1000);
                        setGestationProgress(getGestationProgress()+1);
                        System.out.println(getName()+" est ensceinte depuis "+getGestationProgress()+ " secondes");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                giveBirth();
            }
        });
		incubationThread.start();
	}


	public Creature giveBirth() {
		this.getEnclosure().setCurrentNumberCreatures(this.getEnclosure().getCurrentNumberCreatures()-1);
		this.gestationProgress = 0;
		Random random = new Random();
		boolean randomGender = random.nextBoolean();
		// A changer
	    Mammal newborn = new Mammal(this.getSpecie(), randomGender, 0, this.getEnclosure(), this.getHeightMin(), this.getHeightMax(), this.getWeightMin(), this.getWeightMax(), this.gestationTime, 0);
		this.getEnclosure().addCreature(newborn);
		System.out.println("A new "+ this.getSpecie()+ " is born !");
		System.out.println("There is now "+ this.getEnclosure().getCurrentNumberCreatures() + " creatures in the enclosure !");
		return newborn;
	}
	
	public void reproduction(){
		if(isMale()==false){
			this.gestationProgress = 0;
			gestation();
		}
	}


	public Thread getIncubationThread() {
		return incubationThread;
	}


	public void setIncubationThread(Thread incubationThread) {
		this.incubationThread = incubationThread;
	}
}
