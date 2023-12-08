package Zoo.Prompts;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Zoo.FantasticZoo;
import Zoo.ZooMaster;


/**
 * The class for all system outputs and inputs. Takes care of Player/Game interactions.
 * @author Camille Girodengo
 *
 */
public class Message {
	
	/* -------------------------------------------------------------------- *
	 * -----------------------------COLORS--------------------------------- *
	 * -------------------------------------------------------------------- */
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	
	
	/* -------------------------------------------------------------------- *
	 * ---------------------------START MESSAGES------------------------- *
	 * -------------------------------------------------------------------- */
	
	
	
	/* -------------------------------------------------------------------- *
	 * ----------------------PREDETERMINED MESSAGES------------------------ *
	 * -------------------------------------------------------------------- */
	
	public static String incorrectEntry() {
		return "Incorrect entry, please retry.";
	}
	public static String notRecognized(){
		return "Command not recognized.";
	}
	public static String notExists(String entity){
		return entity + " does not exist.";
	}
	public static String notSpecified(String entity){
		return entity + " not specified.";
	}
	
	
	/* -------------------------------------------------------------------- *
	 * --------------------------COMMANDS MESSAGES------------------------- *
	 * -------------------------------------------------------------------- */
	
	
	// Records the command and put it to lower case.
	// Does not support multiple spaces separation between words
	public static String[] registerCommand(int nbWords) {
		
		Scanner in = new Scanner(System.in);
		String action = in.nextLine();
		
		String[] command = action.split(" ", nbWords);
//		for (int i = 0; i < command.length; ++i) {
//			command[i] = command[i].toLowerCase();
//		}
		System.out.println();
//		in.close();
		return command;
	}
	
	public static FantasticZoo zooCreation() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please name your fantastic Zoo : ");
		String name = in.nextLine();
		ZooMaster master = Message.characterCreation();
		return new FantasticZoo(name, master, 15);
		
	}
	
	public static ZooMaster characterCreation() {
		Scanner in = new Scanner(System.in);
		System.out.print("Please name the ZooMaster character : ");
		String name = in.nextLine();
		System.out.println();
		System.out.print("Please give the age of the ZooMaster : ");
		int age = in.nextInt();
		if (age <= 0) {
			age = 10;
		}
		in.nextLine(); // If not used then gender will use age input as string for gender input
		System.out.print("Is the ZooMaster Male (M) or Female (F) : ");
		String gender = in.nextLine();
		boolean isMale;
		if (gender.startsWith("M")) {
			isMale = true;
		}
		else {
			isMale = false;
			if (!gender.startsWith("F")) {
				System.out.println("Input Error, resorting to default gender : Female");
			}
		}
//		in.close();
		return new ZooMaster(name, isMale, age);
	}
	
}
