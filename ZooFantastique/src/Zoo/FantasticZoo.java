package Zoo;

import java.util.ArrayList;

public class FantasticZoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public FantasticZoo(String name, ZooMaster zooMaster, int maxNumberEnclosures) {
		super();
		this.name = name;
		this.zooMaster = zooMaster;
		this.maxNumberEnclosures = maxNumberEnclosures;
		this.existingEnclosures = new ArrayList<Enclosure>();
	}

	private String name;
	private ZooMaster zooMaster;
	private final int maxNumberEnclosures;
	private ArrayList<Enclosure> existingEnclosures;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ZooMaster getZooMaster() {
		return zooMaster;
	}

	public void setZooMaster(ZooMaster zooMaster) {
		this.zooMaster = zooMaster;
	}

	public int getMaxNumberEnclosures() {
		return maxNumberEnclosures;
	}
	
	public ArrayList<Enclosure> getExistingEnclosures() {
		return existingEnclosures;
	}

	public void setExistingEnclosures(ArrayList<Enclosure> existingEnclosures) {
		this.existingEnclosures = existingEnclosures;
	}

	
	
	@Override
	public String toString() {
		return "FantasticZoo [name=" + name + ", zooMaster=" + zooMaster + ", maxNumberEnclosures="
				+ maxNumberEnclosures + ", existingEnclosures=" + existingEnclosures + "]";
	}

	public void showTotalCreatures() {
		
	}
	
	public void showAllCreatures(){
		
	}
	
	public void addNewEnclosure(Enclosure newEnclosure) {
		
	}
	
	public void removeEnclosure(Enclosure oldEnclosure) {
		
	}

}