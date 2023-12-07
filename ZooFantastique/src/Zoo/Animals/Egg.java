package Zoo.Animals;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.Scanner;

import Zoo.Enclosure;

public class Egg {
	private final int incubationTime;
	private int incubationProgress = 0;
	private Enclosure enclosure;
	private Thread incubationThread;
	private Oviparous mother;
	
	public Egg(int incubationTime, Enclosure enclosure, Oviparous mother) {
	    this.incubationTime = incubationTime;
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
                        ++incubationProgress;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                hatch();
            }
        });
		incubationThread.start();
	}
	public void hatch() {
		synchronized (this) {
			if(getIncubationProgress()==getIncubationTime()) {
				Random random = new Random();
				boolean randomGender = random.nextBoolean();
				// To change
				Class<? extends Oviparous> classMere = this.mother.getClass();

		        try {
		            Constructor<? extends Oviparous> constructeur = classMere.getConstructor(boolean.class, int.class, Enclosure.class);

		            Oviparous newBorn = constructeur.newInstance(randomGender, 0, enclosure);

		        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
		            e.printStackTrace();
		        }
			    //Mammal newborn = new Mammal(this.getSpecie(), randomGender, 0, this.getEnclosure(), this.getHeightMin(), this.getHeightMax(), this.getWeightMin(), this.getWeightMax(), this.gestationTime, 0);
				//Oviparous newoviparous = new Oviparous(mother.getSpecie(), randomGender, 1, this.enclosure, mother.getHeightMin(), mother.getHeightMax(), mother.getWeightMin(), mother.getWeightMax());
				this.enclosure.removeEgg(this);
				System.out.println("An eggs as hatch a new creature is born !");
				System.out.println("There is now : " + this.enclosure.getCurrentNumberCreatures() + " creatures in the enclosure !");	
			}
		}
	}
	
}
