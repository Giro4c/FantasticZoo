package Colony;

public class mainTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	
		// test constituteCoupleAlpha
        Werewolf alphaMale = new Werewolf("Wolf", "AlphaMale", true, 50, 120, 3, "Young", false, 100, 'α', 5, 8, null);
        Werewolf female1 = new Werewolf("Wolf", "Female1", false, 40, 100, 2, "Young", false, 85, 'ψ', 4, 7, null);
        Werewolf female2 = new Werewolf("Wolf", "Female2", false, 45, 110, 2, "Young", false, 80, 'γ', 4, 4, null);
        Territory territory = new Territory();
        Pack packtest = new Pack(territory);
        packtest.getMembers().add(alphaMale);
        packtest.getMembers().add(female1);
        packtest.getMembers().add(female2);
        packtest.setTerritory(territory);
        packtest.constituteAlphaCouple(alphaMale);
        System.out.println(packtest.getAlphaCouple().getFemale().getRank());
        System.out.println(packtest.getAlphaCouple().getPack());
       
        
        System.out.println(female2.canDominate(female1));
        
        
	}
}
