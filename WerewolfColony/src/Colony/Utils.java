package Colony;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Utils {
	private static int index;
	 private static ArrayList<Character> listRankDomination = new ArrayList<>(Arrays.asList('α', 'β', 'γ', 'δ', 'ε', 'ζ', 'η', 'θ', 'ι', 'κ', 'λ',
	    		'μ', 'ν', 'ξ', 'ο', 'π', 'ρ', 'σ', 'τ', 'υ', 'φ', 'χ', 'ψ', 'ω'));
	 
	 private static ArrayList<String> listMonth = new ArrayList<>(Arrays.asList("january", "february","march","april","may","june","july",
			 "august","september","october","november","december"));
	 
	 private static ArrayList<String> meatingSeason = new ArrayList<>(Arrays.asList("february","march"));
	 
	 private static ArrayList<String> WolfsName = new ArrayList<>(Arrays.asList(
             "Fenrir", "Lycan", "Shadowclaw", "Bloodmoon", "Nightfang", "Moonhowl", "Darkfur", "Razorclaw",
             "Stormpelt", "Silverback", "Moonshadow", "Wolfsbane", "Swiftclaw", "Blackheart", "Thornstrike",
             "Ironjaw", "Grimmclaw", "Thunderhowl", "Darkfang", "Nightstalker", "Steelclaw", "Baneblade",
             "Savageheart", "Blacksoul", "Moonblade", "Shadowpelt", "Stormfang", "Silvershadow", "Ravenshadow",
             "Steelheart", "Moonbreaker", "Lunarhowl", "Frostfang", "Shadowscar", "Dreadpelt", "Blackmane",
             "Ravenclaw", "Bloodpelt", "Darkhowl", "Nightshade", "Wolfheart", "Frostclaw", "Thunderstrike",
             "Ironfur", "Ghostfang", "Stormclaw", "Silvermoon", "Nightwind", "Steelshadow", "Dreadhowl",
             "Lunarclaw", "Darkmoon", "Ravenstrike", "Shadowheart", "Bloodclaw", "Ironmoon", "Stormsoul",
             "Dreadshadow", "Blazeclaw", "Moonrider", "Blackthorn", "Silentpaw", "Shadowrunner", "Boulderclaw",
             "Frostmane", "Razorback", "Moonpelt", "Thunderclaw", "Vortexfang", "Sableclaw", "Frostheart",
             "Darkrider", "Swiftshadow", "Ravenheart", "Silentmoon", "Blazefur", "Thunderheart", "Sablemoon",
             "Stormrunner", "Frostblade", "Nightscythe", "Silvershade", "Lunarblade", "Dreadmane", "Stormblade",
             "Ravensoul", "Silentclaw", "Steelmane", "Darkblade", "Bloodheart", "Thundermane", "Moonraven",
             "Razorstrike", "Silentshadow", "Lunarwind", "Steelclaw"
     ));
	 
	 public static String randomWolfName() {
		 String randomnamereturn;
		 Random randomname = new Random();
	     int indexNom = randomname.nextInt(WolfsName.size());
	     randomnamereturn = WolfsName.get(indexNom);
	     return randomnamereturn;
	 }
	 
	 
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
	 
	 public static int calculateLevel(String ageRange, int strength, int dominationFactor, Character rank) {
		    double ageCoefficient = 1.50;
		    double strengthCoefficient = 0.35;
		    double dominationCoefficient = 0.2;
		    double rankCoefficient = 0.2;

		    double ageFactor;
		    switch (ageRange) {
		        case "Young":
		            ageFactor = 2;
		            break;
		        case "Adult":
		            ageFactor = 3;
		            break;
		        default:
		            ageFactor = 1;
		    }

		    double rawLevel = ageFactor * ageCoefficient + strength * strengthCoefficient
		                     + dominationFactor * dominationCoefficient + ( listRankDomination.size() - listRankDomination.indexOf(rank)) * rankCoefficient;

		    int level = (int) Math.max(0, Math.min(20, rawLevel));

		    return level;
		}
	 
	 /** 
	  * Check if members have at least 1 male and 1 female for creating a pack
	  * @param members
	  * @return
	  */
	 public static boolean containsMaleAndFemale(ArrayList<Werewolf> members) {
		    boolean containsMale = false;
		    boolean containsFemale = false;

		    for (Werewolf member : members) {
		        if (member.isMale()) {
		            containsMale = true;
		        } else {
		            containsFemale = true;
		        }

		        if (containsMale && containsFemale) {
		            return true;
		        }
		    }

		    return false;
		}


}
