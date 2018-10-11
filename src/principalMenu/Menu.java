package principalMenu;

import taskManager.TaskManagment;

public class Menu {

	private static TaskManagment taskManagment = new TaskManagment();

	public static void main(String[] args) {
		taskManagment.MenuDisplay();
	}
}