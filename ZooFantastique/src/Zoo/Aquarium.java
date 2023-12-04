package Zoo;

import java.util.Random;

public class Aquarium extends Enclosure implements Runnable {
	
	public static final String[] CLEANNESS_STATES = {"Clean", "Normal", "Dirty", "Moundir's Room"};
	
	private int depth;
	private int salinity;
	
	private int indexcleanness = 0;
	private String cleanness = CLEANNESS_STATES[indexcleanness];
	
	
	public Aquarium(String name, int surface, int maxNumberCreatures, String cleanness, int depth, int salinity) {
		super(name, surface, maxNumberCreatures, cleanness);
		this.depth = depth;
		this.salinity = salinity;
	}
	
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
			if ( RandomNumber < 5) {
				if(this.getIndexcleanness() < CLEANNESS_STATES.length-1) {
					this.setIndexcleanness(this.getIndexcleanness()+1);
					System.out.println("The aquarium " + this.getName() + " gets dirty !");
				}
			}
			if ( RandomNumber > 95) {
				salinity += 1;
				System.out.println("The salinity of the aquarium " + this.getName() + " gets dirty !");
			}
		}
	}
	
	private void setIndexcleanness(int indexcleanness) {
		 this.indexcleanness = indexcleanness;
		 this.cleanness = CLEANNESS_STATES[indexcleanness];
	}


	public int getDepth() {
		return depth;
	}


	public void setDepth(int depth) {
		this.depth = depth;
	}


	public int getSalinity() {
		return salinity;
	}


	public void setSalinity(int salinity) {
		this.salinity = salinity;
	}


	@Override
	public void clean() {
		System.out.println("The aquarium " + this.getName() + " was cleaned !");
	}


}
