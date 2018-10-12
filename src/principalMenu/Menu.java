package principalMenu;

import taskManager.TaskManagment;

/**
 * 
 * @author Seifeddine Abedsslem
 *
 */
public class Menu {

	
	private static TaskManagment taskManagment = new TaskManagment();

	/** This is the main class that allowed to print the method MenuDisplay that belongs to the class TaskMnangment 
	 * @param args
	 */
	public static void main(String[] args) {
		taskManagment.MenuDisplay();
	}
}