package Zoo;

import java.util.Random;

import Zoo.Animals.Creature;
import Zoo.Caracteristics.CanFly;
import Zoo.Caracteristics.CanSwim;

/**
 * Represents an Aquarium enclosure.
 */
public class Aquarium extends Enclosure implements Runnable {
    
    private int depth;
    private int salinity;
    private int startSalinity;
    
    /**
     * Constructor for the Aquarium class.
     *
     * @param name              The name of the aquarium.
     * @param surface           The surface area of the aquarium.
     * @param maxNumberCreatures The maximum number of creatures the aquarium can hold.
     * @param cleanness         The initial cleanliness state of the aquarium.
     * @param depth             The depth of the aquarium.
     * @param salinity          The salinity level of the aquarium.
     */
    public Aquarium(String name, int surface, int maxNumberCreatures, String cleanness, int depth, int salinity) {
        super(name, surface, maxNumberCreatures, cleanness);
        this.depth = depth;
        this.salinity = salinity;
        startSalinity = salinity;
    }
    
    /**
     * Thread for aquariums where dirtiness and salinity increase.
     */
    @Override
    public void run() {
        Random random = new Random();
        while(true) {
            try {
                synchronized (this) {
                    int randomNumberSleep = random.nextInt(10001) + 10000;
                    this.wait(randomNumberSleep); // Sleep the thread for a duration of 10 to 20s
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int RandomNumber = random.nextInt(100);
            if ( RandomNumber < 5) { // 5% chance that the aquarium gets dirty 
                if(this.getIndexcleanness() < CLEANNESS_STATES.length-1) {
                    this.setIndexcleanness(this.getIndexcleanness()+1);
                    System.out.println("The aquarium " + this.getName() + " gets dirty !");
                }
            }
            if ( RandomNumber > 95) { // 5% chance that the salinity of the aquarium increases
                salinity += 1;
                System.out.println("The salinity of the aquarium " + this.getName() + " increases!");
            }
        }
    }
    
    public String toString () {
    	return super.toString()+" salinity level is " + salinity + " G/L";
    }

    /**
     * Get the depth of the aquarium.
     *
     * @return The depth of the aquarium.
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Set the depth of the aquarium.
     *
     * @param depth The new depth of the aquarium.
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Get the salinity of the aquarium.
     *
     * @return The salinity level of the aquarium.
     */
    public int getSalinity() {
        return salinity;
    }

    /**
     * Set the salinity of the aquarium.
     *
     * @param salinity The new salinity level of the aquarium.
     */
    public void setSalinity(int salinity) {
        this.salinity = salinity;
    }
    
    @Override 
    public boolean checkCompatibility(Creature creature) {
    	if (creature instanceof CanSwim) {
    		return super.checkCompatibility(creature);
    	}
    	else {
    		return false;
    	}
    }

    /**
     * Clean the aquarium to remove dirtiness.
     */
    @Override
    public void clean() {
        this.setIndexcleanness(0);
        this.setSalinity(startSalinity);
        System.out.println("The aquarium " + this.getName() + " was cleaned !");
    }
}
