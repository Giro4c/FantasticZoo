package Zoo.Animals;

import java.util.Random;
import java.util.Scanner;

import Zoo.Enclosure;

public class Egg {
	private Creature newBorn;
	private final int incubationTime;
	private int incubationProgress;
	private Enclosure enclosure;
	private Thread incubationThread;
	private Oviparous mother;
	
	public Egg(String specie, String name, boolean isMale, int weight, int height, int age, String indicatorHunger, boolean isSleeping,
	        String indicatorHealth, int incubationTime, int incubationProgress, Enclosure enclosure, Oviparous mother) {
	    this.newBorn = new Oviparous(specie, name, isMale, weight, height, age, indicatorHunger, isSleeping, indicatorHealth, enclosure);
	    this.incubationTime = incubationTime;
	    this.incubationProgress = incubationProgress;
	    this.enclosure = enclosure;
	    this.mother = mother;
	    incubation(this);
	}
	public Thread getIncubationThread() {
		return this.incubationThread;
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
	public void setEnclosure(Enclosure enclosure) {
		this.enclosure = enclosure;
	}
	public void incubation(Egg egg) {
		 incubationThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (incubationProgress < incubationTime) {
                    try {
                        Thread.sleep(1000);
                        incubationProgress++;
                        System.out.println("L'oeuf est à : "+incubationProgress+" temps d'incubation");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                hatch();
            }
        });
		incubationThread.start();
	}
	public Oviparous hatch() {
		synchronized (this) {
			if(getIncubationProgress()==getIncubationTime()) {
				enclosure.setCurrentNumberCreatures(enclosure.getCurrentNumberCreatures()-1);
				Random random = new Random();
				boolean randomBoolean = random.nextBoolean();
				int randomHeight = random.nextInt(mother.getHeightMin(), mother.getHeightMax());
				int randomWeight = random.nextInt(mother.getWeightMin(), mother.getWeightMax());
				Scanner scanner = new Scanner(System.in);
			    System.out.print("Entrez un nom pour le nouveau née: ");
			    String newbornName = scanner.nextLine();
				Oviparous newoviparous = new Oviparous(mother.getSpecie(), newbornName, randomBoolean, randomWeight, randomHeight, 0, "Full", false, "Perfect", this.enclosure);
				this.enclosure.removeEgg(this);
				this.enclosure.addCreature(newoviparous);
				System.out.println("Un nouveau ovipare apparait !");
				System.out.println("Il y a maintenant :"+this.enclosure.getCurrentNumberCreatures()+" Animaux dans l'enclos !");
				return newoviparous;	
			}
			return null;
		}
	}
	
}
