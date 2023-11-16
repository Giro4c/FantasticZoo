package Zoo.Prompts;

import the_game.Entity;

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
	
	/**
	 * <p>Finds the index of the searched entity based on its name.<br>
	 * Considers that each entity's name is unique (no entity have the same name)</p>
	 * @param entities the array of Entity to search in
	 * @param nameEntityToFind the entity name to find
	 * @return the index of the first entity whose name is the String in the parameters
	 */
	public static int findIndexEntity(Entity[] entities, String nameEntityToFind) {
		for (int i = 0; i < entities.length; ++i) {
			if (nameEntityToFind.equals(entities[i].getName())) {
				return i;
			}
		}
		return entities.length;
	}
	
}
