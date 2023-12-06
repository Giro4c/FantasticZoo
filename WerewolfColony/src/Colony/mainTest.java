package Colony;

public class mainTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	
		// test constituteCoupleAlpha
        Werewolf alphaMale = new Werewolf("Wolf", true, 50, 120, 3, "Elder", false, 10, 10, null);
        Werewolf female1 = new Werewolf("Wolf", false, 44, 100, 2, "Young", false, 7, 8, null);
        Werewolf female2 = new Werewolf("femelleforte", false, 45, 110, 3, "Young", false, 6, 9, null);
        Territory territory = new Territory();
        Pack packtest = new Pack(territory);
        packtest.getMembers().add(alphaMale);
        packtest.getMembers().add(female1);
        packtest.getMembers().add(female2);
        packtest.setTerritory(territory);
        packtest.constituteAlphaCouple(alphaMale);
        System.out.println(packtest.getAlphaCouple().getFemale().getLevel());
        System.out.println(packtest.getAlphaCouple().getFemale().getName());
        System.out.println(female2.getLevel());
        System.out.println(packtest.getAlphaCouple().getPack()); 
       
        
       /* System.out.println(female1.canDominate(female2));
        System.out.println(female1.getStrength());
        System.out.println(female1.getRank());
        System.out.println(female2.getStrength()); */
        System.out.println(Math.round(Math.random()));
        
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
}
