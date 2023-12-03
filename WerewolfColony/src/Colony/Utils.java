package Colony;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {
	 private static ArrayList<Character> listRankDomination = new ArrayList<>(Arrays.asList('α', 'β', 'γ', 'δ', 'ε', 'ζ', 'η', 'θ', 'ι', 'κ', 'λ',
	    		'μ', 'ν', 'ξ', 'ο', 'π', 'ρ', 'σ', 'τ', 'υ', 'φ', 'χ', 'ψ', 'ω'));

	 public static boolean isDominant(char c1, char c2) {
		 if(listRankDomination.contains(c1) && listRankDomination.contains(c2)) {
	            if(listRankDomination.indexOf(c1) > listRankDomination.indexOf(c2)) {
	                return true;
	            }
	        }
	        return false;
	 }
}
