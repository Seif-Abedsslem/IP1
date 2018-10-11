package principalMenu;

import taskManager.TaskManagment;

/**
 * @author tmp-sda-1172
 *
 */
public class Menu {

	
	private static TaskManagment taskManagment = new TaskManagment();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		taskManagment.MenuDisplay();
	}
}