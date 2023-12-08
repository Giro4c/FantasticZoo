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
		String genre;
		if(this.isMale==true) {genre = "Man";}
		else {genre= "Woman";}
		return "The ZooMaster " + name + " is a " + genre + " and " + age + " years old";
	}

	public void examineEnclosure(Enclosure enclosure) {
		System.out.println("The ZooMaster " + this.name + " examines the " + enclosure.getName() + enclosure.toString());
	}
	
	public void cleanEnclosure(Enclosure enclosure) {
		enclosure.clean();
		System.out.println("The ZooMaster " + this.name + " is cleaning the " + enclosure.getName());
	}
	
	public void feedCreaturesInEnclosure(Enclosure enclosure) {
		enclosure.feedCreatures();
		System.out.println("The ZooMaster " + this.name + " is feeding the creatures in " + enclosure.getName());
	}
	
	public void tranfertCreature(Enclosure prevEnclosure, int indexInEnclosure, Enclosure newEnclosure) {
		if ( newEnclosure.getMaxNumberCreatures() < newEnclosure.getCurrentNumberCreatures()) {
			newEnclosure.addCreature(prevEnclosure.getPresentCreatures().get(indexInEnclosure));
			prevEnclosure.getPresentCreatures().get(indexInEnclosure).delete();
		
			System.out.println("The ZooMaster " + this.name + " is moving a creature from " + 
					prevEnclosure.getName() + " to " + newEnclosure.getName());
		}
		else {
			System.out.println("You can't transfert a creature in this enclosure because it is full");
		}
	}
	
	

}
