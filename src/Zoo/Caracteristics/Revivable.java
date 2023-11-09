package Zoo.Caracteristics;

public interface Revivable extends CreatureInfo {

	public default void revive() {
		System.out.println(this.getSpecie() + " " + this.getName() + " is reborn.");
	}
	
}
