package Zoo.Prompts;


public class UtilsAction {

	/**
	 * Finds if a String equals another String in array of String
	 * @param arrayStr the String array in which a String must be found
	 * @param strToFind the String to find in an array
	 * @return true if the String is in the array
	 */
	public static boolean isInStringArray(String[] arrayStr, String strToFind) {
		for (String str : arrayStr) {
			if (str != null && str.equals(strToFind)) {
				return true;
			}
		}
		return false;
	}

	
}
