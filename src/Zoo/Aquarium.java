package Zoo;

public class Aquarium extends Enclosure {
	
	private int depth;
	private int salinity;
	
	
	public Aquarium(String name, int surface, int maxNumberCreatures, String cleanness, int depth, int salinity) {
		super(name, surface, maxNumberCreatures, cleanness);
		this.depth = depth;
		this.salinity = salinity;
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
		
	}

}
