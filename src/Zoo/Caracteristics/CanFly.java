package Zoo.Caracteristics;

public interface CanFly extends CreatureInfo {

	public default void fly() {
		System.out.println(this.getSpecie() + " " + this.getName() + " is flying.");
	}
	
}
