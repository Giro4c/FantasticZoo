package Zoo;

import java.util.Random;

public class Aviary extends Enclosure implements Runnable {

	public static final String[] CLEANNESS_STATES = {"Clean", "Normal", "Dirty", "Moundir's Room"};

	
	private int height;
	private int indexcleanness = 0;
	private String cleanness = CLEANNESS_STATES[indexcleanness];
	
	public Aviary(String name, int surface, int maxNumberCreatures, String cleanness, int height) {
		super(name, surface, maxNumberCreatures, cleanness);
		this.height = height;
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
					System.out.println("The avirary " + this.getName() + " gets dirty !");
				}
			}
		}
	}
	
	private void setIndexcleanness(int indexcleanness) {
		 this.indexcleanness = indexcleanness;
		 this.cleanness = CLEANNESS_STATES[indexcleanness];
	}

	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	@Override
	public void clean() {
		System.out.println("The aviary " + this.getName() + " was cleaned !");
	}
	
}
