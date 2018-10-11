package taskManager;

import java.util.Date;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import fileManager.FileManager;

/**
 * @author tmp-sda-1172
 *
 */
public class TaskManagment {
	private FileManager fileManager = new FileManager();
	public List<Task> tasks = new ArrayList<>();

	/**
	 * 
	 */
	public TaskManagment() {
		tasks = fileManager.loadTasksFromFile();
	}

	/**
	 * @param tasks
	 * @return
	 */
	private static int doneTask(List<Task> tasks) {
		int done = 0;
		for (Task t : tasks) {
			if (t.getStatusTask().equals("done"))
				done = done + 1;
		}
		return done;
	}

	/**
	 * 
	 */
	public void MenuDisplay() {
		Scanner keybd = new java.util.Scanner(System.in);
		int choice = 1;
		while (choice != 4) {
			printMainMenu();
			// process user's menu choice
			try {
				choice = keybd.nextInt();
				keybd.nextLine(); // clear input stream
				handleMainMenuInput(choice);
			} catch (java.util.InputMismatchException ime) {
				System.out.println("Sorry, but you must enter a number.");
				keybd.nextLine(); // clear bad input from stream
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end while
	}// end main

	public void printMainMenu() {
		System.out.format(
				"+-----------------------------------------------------------------------------------------------------+%n");
		System.out.format(
				"|                                        Welcome ToDo List                                            |%n");
		System.out.format(
				"+-----------------------------------------------------------------------------------------------------+%n");
		System.out.format("|                          You have " + (tasks.size() - doneTask(tasks))
				+ " tasks todo and " + doneTask(tasks) + " tasks are done!                               |%n");
		System.out.format(
				"+-----------------------------------------------------------------------------------------------------+%n");
		System.out.format(
				"|     Pick an option:                                                                                 |%n");
		System.out.format(
				"+-----------------------------------------------------------------------------------------------------+%n");
		System.out.format(
				"|               (1) Show Task List (by date or project)                                               |%n");
		System.out.format(
				"+-----------------------------------------------------------------------------------------------------+%n");
		System.out.format(
				"|               (2) Add New Task                                                                      |%n");
		System.out.format(
				"+-----------------------------------------------------------------------------------------------------+%n");
		System.out.format(
				"|               (3) Edit Task (update, mark as done, remove)                                          |%n");
		System.out.format(
				"+-----------------------------------------------------------------------------------------------------+%n");
		System.out.format(
				"|               (4) Save and Quit                                                                     |%n");
		System.out.format(
				"+-----------------------------------------------------------------------------------------------------+%n");
		System.out.format(
				"|                                              Please Enter your Choice    |                          |%n");
		System.out.format(
				"+-----------------------------------------------------------------------------------------------------+%n");
	}

	private void handleMainMenuInput(int choice) throws ParseException {
		switch (choice) {
		case 1:
			System.out.print("You choose to show all the tasks\n ");

			PrintTasks();
			break;

		case 2:
			System.out.println("You choose to add a new task ");
			addTask();
			break;

		case 3:
			System.out.print(" You choose to Edit Task (update, mark as done, remove) ");
			editTasks();
			break;

		case 4:
			fileManager.saveTasksToFile(tasks);
			System.out.println(" You choose to Save and Quit ");
			System.out.println("Goodbye!");
			break;

		default:
			System.out.println(
					"Sorry, but " + choice + " is not one of " + "the menu choices. Please try again.");
			break;
		}
	}

	/**
	 * @throws ParseException
	 */
	private void addTask() throws ParseException {
		Scanner scanner = new java.util.Scanner(System.in);
		System.out.println("adding a new task");
		System.out.println("Please Enter the Title of the Task:");
		String title = scanner.nextLine();
		System.out.println("Please Enter the Status of the Task:");
		String status = scanner.nextLine();
		System.out.println("Please Enter the Date of the Task:");

		String date1 = getDateFromUser();
		Date datetask = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
		System.out.println("Please Enter the Project of the Task:");
		String project = scanner.nextLine();

		tasks.add(new Task(title, status, datetask, project));
		// FileManager.saveTasksToFile(Tasks);
		System.out.println("Task Created");
	}

	private String getDateFromUser() {
		String date1;
		do {
			Scanner scanner1 = new java.util.Scanner(System.in);
			System.out.println("Please Enter the Date with this format (yyyy-MM-dd) ");
			date1 = scanner1.nextLine();
		} while ((isValidDate(date1)) == false);
		return date1;
	}

	/**
	 * @param inDate
	 * @return
	 */
	private static boolean isValidDate(String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 */
	private void PrintTasks() {
		java.util.Scanner keybd = new java.util.Scanner(System.in);

		int choice = 1;
		while (choice != 4) {

			System.out.println(">> Pick an option:  ");
			System.out.println(">> (1) Print all tasks ");
			System.out.println(">> (2) Print all tasks sorted by date ");
			System.out.println(">> (3) Print all tasks sorted by Project ");
			System.out.println(">> (4) Exit   ");

			try {
				choice = keybd.nextInt();
				keybd.nextLine(); // clear input stream
				switch (choice) {
				case 1:
					System.out.print("You choose to print all tasks\n");
					printAllTasks();
					break;

				case 2:
					System.out.println("You choose to print all tasks sorted by date ");
					printAllTasksSortedByDate();
					break;

				case 3:
					System.out.println(" You choose to print all tasks sorted by project ");
					PrintAllTasksSortByProject();
					break;

				case 4:
					System.out.println(" You choose to exit ");
					break;

				default:
					System.out.println(
							"Sorry, but " + choice + " is not one of " + "the menu choices. Please try again.");
					break;
				}
			} catch (java.util.InputMismatchException ime) {
				System.out.println("Sorry, but you must enter a number.");
				keybd.nextLine(); // clear bad input from stream

			}
		}
	}

	/**
	 * 
	 */
	private void printAllTasks() {

		String AlignFormat = "| %-11d | %-16s |%-18s |%-29s |%-16s |%n";
		System.out.format(
				"+-------------+------------------+-------------------+------------------------------+-----------------+%n");
		System.out.format(
				"| Task Index  |     Tiltle       |        Status     |                Date          |      Project    |%n");
		System.out.format(
				"+-------------+------------------+-------------------+------------------------------+-----------------+%n");
		tasks.forEach(user1 -> {
			System.out.format(AlignFormat, tasks.indexOf(user1), user1.getTitleTask(), user1.getStatusTask(),
					user1.getDateTask(), user1.getProjectTask());
		});
		System.out.format(
				"+-------------+------------------+-------------------+------------------------------+-----------------+%n");

	}

	/**
	 * 
	 */
	private void printAllTasksSortedByDate() {
		String AlignFormat = "| %-11d | %-16s |%-18s |%-30s |%-16s |%n";
		System.out.format(
				"+-------------+------------------+-------------------+-------------------------------+-----------------+%n");
		System.out.format(
				"| Task Index  |     Tiltle       |        Status     |       Date                    |      Project    |%n");
		System.out.format(
				"+-------------+------------------+-------------------+-------------------------------+-----------------+%n");

		Collections.sort(tasks, new Comparator<Task>() {
			public int compare(Task p1, Task p2) {
				return Long.valueOf(p1.getDateTask().getTime()).compareTo(p2.getDateTask().getTime());
			}
		});

		for (Task task : tasks) {
			System.out.format(AlignFormat, tasks.indexOf(task), task.getTitleTask(), task.getStatusTask(),
					task.getDateTask(), task.getProjectTask());
		}
		;

		System.out.format(
				"+-------------+------------------+-------------------+-------------------------------+-----------------+%n");

	}

	/**
	 * 
	 */
	private void editTasks() {
		java.util.Scanner keybd = new java.util.Scanner(System.in);

		int choice = 1;
		while (choice != 4) {

			System.out.println(">> Pick an option:  ");
			System.out.println(">> (1) Update a Task ");
			System.out.println(">> (2) Remove a Task ");
			System.out.println(">> (3) Mark a task   ");
			System.out.println(">> (4) Exit   ");

			try {
				choice = keybd.nextInt();
				keybd.nextLine(); // clear input stream
				switch (choice) {
				case 1:
					System.out.print("You choose to update a task\n ");
					UpdateTasks();
					break;

				case 2:
					System.out.println("You choose to remove a task ");
					Removal();
					break;

				case 3:
					System.out.println(" You choose to mark a task ");
					MarkAsDone();
					break;

				case 4:
					System.out.println(" You choose to exit ");
					break;

				default:
					System.out.println(
							"Sorry, but " + choice + " is not one of " + "the menu choices. Please try again.");
					break;
				}
			} catch (java.util.InputMismatchException ime) {
				System.out.println("Sorry, but you must enter a number.");
				keybd.nextLine(); // clear bad input from stream

			}
		}
	}

	/**
	 * 
	 */
	private void PrintAllTasksSortByProject() {
		Scanner project = new Scanner(System.in);
		System.out.println("Enter the project : ");
		String elem = project.nextLine();

		ArrayList<Task> filteredtasks = filterByProject(tasks, elem);
		String AlignFormat1 = "| %-11d | %-16s |%-18s |%-25s |%-16s |%n";
		System.out.format(
				"+-------------+------------------+-------------------+-----------------------------+-----------------+%n");
		System.out.format(
				"| Task Index  |     Project      |        Status     |       Date                  |      Title      |%n");
		System.out.format(
				"+-------------+------------------+-------------------+-----------------------------+-----------------+%n");
		for (Task task : filteredtasks) {
			System.out.format(AlignFormat1, tasks.indexOf(task), task.getProjectTask(), task.getStatusTask(),
					task.getDateTask(), task.getTitleTask());
		}
		;

		System.out.format(
				"+-------------+------------------+-------------------+-----------------------------+-----------------+%n");
	}

	/**
	 * @param tasks2
	 * @param projectName
	 * @return
	 */
	private static ArrayList<Task> filterByProject(List<Task> tasks2, String projectName) {
		ArrayList<Task> filterdTask = (ArrayList<Task>) tasks2.stream()
				.filter(x -> x.getProjectTask().equals(projectName)).collect(Collectors.toList());
		return filterdTask;
	}

	/**
	 * 
	 */
	private void Removal() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the index Element to be deleted : ");
		int elem = in.nextInt();
		tasks.remove(elem);
	}

	/**
	 * 
	 */
	private void MarkAsDone() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the index Element to be Masked as done : ");
		int elem = in.nextInt();
		tasks.get(elem).setStatusTask("done");
	}

	/**
	 * 
	 */
	private void UpdateTasks() {
		java.util.Scanner keybd = new java.util.Scanner(System.in);
		int choice = 1;
		while (choice != 4) {
			System.out.println(">> Pick an option for updating a task:  ");
			System.out.println(">> (1) Update the title Task ");
			System.out.println(">> (2) Update the date Task ");
			System.out.println(">> (3) Update the project Task ");
			System.out.println(">> (4) Exit   ");

			try {
				choice = keybd.nextInt();
				keybd.nextLine(); // clear input stream
				switch (choice) {
				case 1:
					System.out.print("You choose to update the title of the task\n ");
					Scanner in = new Scanner(System.in);
					System.out.println("Enter the index Element to change his title: ");
					int elem = in.nextInt();
					System.out.println("Enter the new title: ");
					String titlenew = in.next();
					tasks.get(elem).setTitleTask(titlenew);
					break;

				case 2:
					System.out.println("You choose to update the date of the task\n");
					Scanner in1 = new Scanner(System.in);
					System.out.println("Enter the index Element to change his date: ");
					int elem1 = in1.nextInt();
					System.out.println("Enter the new date: ");
					String datenew = in1.next();
					String pattern = "yyyy-MM-dd";
					SimpleDateFormat format = new SimpleDateFormat(pattern);
					Date date = null;
					try {
						date = format.parse(datenew);
						tasks.get(elem1).setDateTask(date);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				case 3:
					System.out.println("You choose to update the project of the task\n");
					Scanner in11 = new Scanner(System.in);
					System.out.println("Enter the index Element to change his project: ");
					int elem11 = in11.nextInt();
					System.out.println("Enter the new project: ");
					String projectnew = in11.next();
					tasks.get(elem11).setProjectTask(projectnew);
					break;

				case 4:
					System.out.println("You choose to exit the update ");
					break;

				default:
					System.out.println(
							"Sorry, but " + choice + " is not one of " + "the menu choices. Please try again.");
					break;
				}
			} catch (java.util.InputMismatchException ime) {
				System.out.println("Sorry, but you must enter a number.");
				keybd.nextLine(); // clear bad input from stream
			}
		}
	}

}
