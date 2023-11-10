package Zoo;

public class Aviary extends Enclosure {

	private int height;
	
	
	public Aviary(String name, int surface, int maxNumberCreatures, String cleanness, int height) {
		super(name, surface, maxNumberCreatures, cleanness);
		this.height = height;
	}

	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	@Override
	public void clean() {
		 
	}
	
}
