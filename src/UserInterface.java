import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {

	    java.util.Scanner keybd = new java.util.Scanner(System.in);
	    

	    int choice = 1;
	    while (choice != 4) {
	      
	      System.out.println();
	      

	      //print menu choices
	      System.out.println("*************************************************************************");
			System.out.println(">> Welcome to ToDoly                                                    *");
			System.out.println(">> You have X tasks todo and Y tasks are done!                          *");
			System.out.println(">> Pick an option:                                                      *");
			System.out.println(">> (1) Show Task List (by date or project)                              *");
			System.out.println(">> (2) Add New Task                                                     *");
			System.out.println(">> (3) Edit Task (update, mark as done, remove)                         *");
			System.out.println(">> (4) Save and Quit                                                    *");
			System.out.println(">>                                                                      *");
			System.out.println("*************************************************************************");

	      //process user's menu choice
	      try {
	        choice = keybd.nextInt();
	        keybd.nextLine();  //clear input stream
	        switch (choice) {
	          case 1:  
	            System.out.print("You choose to show all the tasks\n ");
	            
	            Task.printAllTasks();
	            break;

	          case 2:  
	            
	              System.out.println("You choose to add a new task " );
	            Task.addTask(keybd);
	            break;

	          case 3:  
	            System.out.print(" You choose to Edit Task (update, mark as done, remove) ");
	            
	            TaskManagment.editTasks();
	            break;
	            

	          case 4:
	        	System.out.println(" You choose to Save and Quit ");
	            System.out.println("Goodbye!");
	            break;

	          default:
	            System.out.println("Sorry, but " + choice + " is not one of " +
	                "the menu choices. Please try again.");
	            break;
	        }
	      }catch (java.util.InputMismatchException ime) {
	        System.out.println("Sorry, but you must enter a number.");
	        keybd.nextLine();  //clear bad input from stream
	      }
	    }//end while
	  }//end main
}
