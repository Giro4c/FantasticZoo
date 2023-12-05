package Zoo.Animals;

import java.util.Random;
import java.util.Scanner;

import Zoo.Enclosure;

public class Mammal extends Creature {

	private final int gestationTime;
	private int gestationProgress;
	private Enclosure enclosure;
	private Thread incubationThread;
	
	public Mammal(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger,
			boolean isSleeping, String indicatorHealth, int gestationTime, int gestationProgress, Enclosure enclosure) {
		super(specie, name, isMale, weight, height, age, indicatorHunger, isSleeping, indicatorHealth, enclosure);
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
		this.enclosure.setCurrentNumberCreatures(enclosure.getCurrentNumberCreatures()-1);
		this.gestationProgress = 0;
		Random random = new Random();
		boolean randomBoolean = random.nextBoolean();
		int randomheight = random.nextInt(super.getHeightMin(), super.getHeightMax());
		int randomWeight = random.nextInt(super.getWeightMin(), super.getWeightMax());
		Scanner scanner = new Scanner(System.in);
	    System.out.print("Entrez un nom pour le nouveau née: ");
	    String newbornName = scanner.nextLine();
		Mammal newborn = new Mammal(this.getSpecie(), newbornName, randomBoolean, randomWeight, randomheight, 0, "Full", false, "Perfect", this.gestationTime , 0, this.enclosure);
		this.enclosure.addCreature(newborn);
		System.out.println("Un nouveau "+getSpecie()+ " est née !");
		System.out.println("Il y a maintenant "+ this.enclosure.getCurrentNumberCreatures()+" Animaux dans l'enclos !");
		return newborn;
	}
	
	public void reproduction(){
		if(isMale()==false){
			this.gestationProgress = 0;
			gestation();
		}
	}



	public Enclosure getEnclosure() {
		return enclosure;
	}



	public void setEnclosure(Enclosure enclosure) {
		this.enclosure = enclosure;
	}



	public Thread getIncubationThread() {
		return incubationThread;
	}



	public void setIncubationThread(Thread incubationThread) {
		this.incubationThread = incubationThread;
	}
}
