package Colony;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {
	private static int index;
	 private static ArrayList<Character> listRankDomination = new ArrayList<>(Arrays.asList('α', 'β', 'γ', 'δ', 'ε', 'ζ', 'η', 'θ', 'ι', 'κ', 'λ',
	    		'μ', 'ν', 'ξ', 'ο', 'π', 'ρ', 'σ', 'τ', 'υ', 'φ', 'χ', 'ψ', 'ω'));
	 private static ArrayList<String> listMonth = new ArrayList<>(Arrays.asList("january", "february","march","april","may","june","july",
			 "august","september","october","november","december"));
	 private static ArrayList<String> meatingSeason = new ArrayList<>(Arrays.asList("february","march"));
	 
	 
	 public static boolean isDominant(char c1, char c2) {
		 if(listRankDomination.contains(c1) && listRankDomination.contains(c2)) {
	            if(listRankDomination.indexOf(c1) < listRankDomination.indexOf(c2)) {
	                return true;
	            }
	        }
	        return false;
	 }
	 
	 
	 public static void changeMonth() {
		    Thread monthThread = new Thread(() -> {
		        while (true) {
		            try {
		                Thread.sleep(10000);
		                index++;
		                if (index >= listMonth.size()) {
		                    index = 0;
		                }
		                System.out.println("Nous sommes au mois de " + listMonth.get(index));
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        }
		    });
		    monthThread.start();
		}
	 public static boolean isMeating() {
		 synchronized (Utils.class) {
	            return meatingSeason.contains(listMonth.get(index));
		 }
	 }

}
