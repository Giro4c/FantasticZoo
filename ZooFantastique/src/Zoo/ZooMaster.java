package Zoo;

public class ZooMaster {
	
	private String name;
	private boolean isMale;
	private int age;
	
	public ZooMaster(String name, boolean isMale, int age) {
		super();
		this.name = name;
		this.isMale = isMale;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "ZooMaster [name=" + name + ", isMale=" + isMale + ", age=" + age + "]";
	}

	public void examineEnclosure(Enclosure enclosure) {
		System.out.println("The ZooMaster " + this.name + " examine the " + enclosure.getName() + enclosure.toString());
	}
	
	public void cleanEnclosure(Enclosure enclosure) {
		System.out.println("The ZooMaster " + this.name + " is cleaning the " + enclosure.getName());
	}
	
	public void feedCreaturesInEnclosure(Enclosure enclosure) {
		System.out.println("The ZooMaster " + this.name + " is feeding the creatures in the" + enclosure.getName());
	}
	
	public void tranfertCreature(Enclosure prevEnclosure, int indexInEnclosure, Enclosure newEnclosure) {
		System.out.println("The ZooMaster " + this.name + " is mooving a creature of the " + 
				prevEnclosure.getName() + " to the " + newEnclosure.getName());
	}
	
	

}
