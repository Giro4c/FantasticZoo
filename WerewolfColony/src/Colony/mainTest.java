package Colony;

public class mainTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	
		// test constituteCoupleAlpha
        Werewolf alphaMale = new Werewolf("Wolf", "AlphaMale", true, 50, 120, 3, "Young", false, 100, 'α', 5, 8, null);
        Werewolf female1 = new Werewolf("Wolf", "Female1", false, 44, 100, 2, "Young", false, 81, 'δ', 4, 8, null);
        Werewolf female2 = new Werewolf("Wolf", "Female2", false, 45, 110, 3, "Young", false, 81, 'γ', 5, 8, null);
      /*  Territory territory = new Territory();
        Pack packtest = new Pack(territory);
        packtest.getMembers().add(alphaMale);
        packtest.getMembers().add(female1);
        packtest.getMembers().add(female2);
        packtest.setTerritory(territory);
        packtest.constituteAlphaCouple(alphaMale);
        System.out.println(packtest.getAlphaCouple().getFemale().getRank());
        System.out.println(packtest.getAlphaCouple().getPack()); **/
       
        
        System.out.println(female1.canDominate(female2));
        System.out.println(female1.getStrength());
        System.out.println(female1.getRank());
        System.out.println(female2.getStrength());
        System.out.println(female2.getRank());

        
        
	}
}
