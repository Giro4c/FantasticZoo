package Zoo.Caracteristics;

import Zoo.Desease;
import Zoo.Animals.Creature;

public interface Revivable extends CreatureInfo {

	public void setSick(boolean isSick);
	public void setDesease(Desease desease);
	public Desease getDesease();
	public void setAge(int age);
	public void setIndicatorHunger(String indicatorHunger);
	public void setIndicatorHealth(String indicatorHealth);
	
	public default void die() {
		System.out.println("The creature "+ this.getName() +" is dead !");
		this.revive();
	}
	
	public default void revive() {
		this.setAge(1);
		this.setIndicatorHealth(Creature.HEALTH_STATES[0]);
		this.setIndicatorHunger(Creature.HUNGER_STATES[0]);
		this.setSick(false);
		if(this.getDesease()!=null) {
			this.getDesease().setAnimal(null);
		}
		this.setDesease(null);
		System.out.println(this.getSpecie() + " " + this.getName() + " is reborn !");
	}
	
}
