package Zoo.Caracteristics;

public interface CanSwim extends CreatureInfo {

	public default void swim() {
		System.out.println(this.getSpecie() + " " + this.getName() + " is swimming.");
	}
	
}
