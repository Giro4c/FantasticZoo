package Zoo;

import java.util.Random;

import Zoo.Animals.Creature;
import Zoo.Caracteristics.CanFly;
import Zoo.Caracteristics.CanSwim;

/**
 * Represents an Aviary enclosure.
 */
public class Aviary extends Enclosure implements Runnable {

    public static final String[] CLEANNESS_STATES = {"Clean", "Normal", "Dirty", "Moundir's Room"};

    private int height;

    /**
     * Constructor for the Aviary class.
     *
     * @param name              The name of the aviary.
     * @param surface           The surface area of the aviary.
     * @param maxNumberCreatures The maximum number of creatures the aviary can hold.
     * @param cleanness         The initial cleanliness state of the aviary.
     * @param height            The height of the aviary.
     */
    public Aviary(String name, int surface, int maxNumberCreatures, String cleanness, int height) {
        super(name, surface, maxNumberCreatures, cleanness);
        this.height = height;
    }

    /**
     * Thread for aviaries where dirtiness may increase.
     */
    @Override
    public void run() {
        Random random = new Random();
        while(true) {
            try {
                synchronized (this) {
                    int randomNumberSleep = random.nextInt(10001) + 10000;
                    this.wait(randomNumberSleep);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int RandomNumber = random.nextInt(100);
            if ( RandomNumber < 5) { // 5% chance that the aviary gets dirty 
                if(this.getIndexcleanness() < CLEANNESS_STATES.length-1) {
                    this.setIndexcleanness(this.getIndexcleanness()+1);
                    System.out.println("The aviary " + this.getName() + " gets dirty !");
                }
            }
        }
    }

    
    /**
     * Get the height of the aviary.
     *
     * @return The height of the aviary.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set the height of the aviary.
     *
     * @param height The new height of the aviary.
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    @Override 
    public boolean checkCompatibilité(Creature creature) {
    	if (creature instanceof CanFly) {
    		return super.checkCompatibilité(creature);
    	}
    	else {
    		return false;
    	}
    }

    /**
     * Clean the aviary to maintain hygiene.
     */
    @Override
    public void clean() {
        System.out.println("The aviary " + this.getName() + " was cleaned !");
    }
}
