/*package Colony;

import java.util.ArrayList;

public class mainTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	
		// test constituteCoupleAlpha
    /*  Werewolf alphaMale = new Werewolf(null);
        Werewolf female1 = new Werewolf(null);
        Werewolf female2 = new Werewolf(null);
        Territory territory = new Territory();
        Pack packtest = new Pack(territory);
        packtest.getMembers().add(alphaMale);
        packtest.getMembers().add(female1);
        packtest.getMembers().add(female2);
        packtest.setTerritory(territory);
        System.out.println(alphaMale.getLevel());
        System.out.println(alphaMale.getName());
        System.out.println(female2.getLevel());
        System.out.println(female2.getName());
        //System.out.println(packtest.getAlphaCouple().getPack()); */
		
		
		Territory territoire = new Territory();

		Werewolf wolf1 = new Werewolf(territoire);
		Werewolf wolf2 = new Werewolf(territoire);
		Werewolf wolf3 = new Werewolf(territoire);
		Werewolf wolf4 = new Werewolf(territoire);
		Werewolf wolf5 = new Werewolf(territoire);
		Werewolf wolf6 = new Werewolf(territoire);
		Werewolf wolf7 = new Werewolf(territoire);
		Werewolf wolf8 = new Werewolf(territoire);
		Werewolf wolf9 = new Werewolf(territoire);
		
		ArrayList<Werewolf> meute = new ArrayList<>();
		meute.add(wolf1);
		meute.add(wolf2);
		meute.add(wolf3);
		meute.add(wolf4);
		meute.add(wolf5);
		meute.add(wolf6);
		meute.add(wolf7);
		meute.add(wolf8);
		meute.add(wolf9);

		Pack pack = new Pack(meute, territoire);
		
	//	pack.showCharacteristics();
		
        pack.getAlphaCouple().showCharacteristics();
		
		/* System.out.println(wolf1.getStrength());
	     System.out.println(wolf1.getRank());
	     
		 System.out.println(wolf2.getStrength());
	     System.out.println(wolf2.getRank());
	     
		 System.out.println(wolf3.getStrength());
	     System.out.println(wolf3.getRank());
	     
		 System.out.println(wolf4.getStrength());
	     System.out.println(wolf4.getRank());
	     
		 System.out.println(wolf5.getStrength());
	     System.out.println(wolf5.getRank()); */
		
        
       /* System.out.println(female1.canDominate(female2));
        System.out.println(female1.getStrength());
        System.out.println(female1.getRank());
        System.out.println(female2.getStrength()); */
       // System.out.println(Math.round(Math.random()));
        
       /* public Werewolf(String name, boolean isMale, int weight, int height, int age, String ageRange,
    			boolean isSleeping, int strength, int arroganceFactor,
    			Pack pack) {
    		super(name, isMale, weight, height, age, ageRange, isSleeping);
    		this.strength = strength;
    		this.arroganceFactor = arroganceFactor;
    		this.pack = pack;
    		this.level = calculateLevel; 
    	}*/

        
        
	}
}*/
