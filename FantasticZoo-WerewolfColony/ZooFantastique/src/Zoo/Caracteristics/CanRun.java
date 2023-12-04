package Zoo.Caracteristics;

public interface CanRun extends CreatureInfo {

	public default void run() {
		System.out.println(this.getSpecie() + " " + this.getName() + " is running.");
	}
	
}
