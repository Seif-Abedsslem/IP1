import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class TaskManagment {
	public static  List<Task> Tasks = new ArrayList<>();
	public static void MenuDisplay() 
	{
        Scanner keybd = new java.util.Scanner(System.in);
	    int choice = 1;
	    while (choice != 4) {
	    System.out.println();
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
	            printAllTasks();
	            break;

	          case 2:  
	              System.out.println("You choose to add a new task " );
	              addTask();
	            break;

	          case 3:  
	            System.out.print(" You choose to Edit Task (update, mark as done, remove) ");
	            editTasks();
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
	      } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }//end while
	  }//end main
	
	public static void addTask() throws ParseException 
	{
		Scanner scanner = new java.util.Scanner(System.in);
			System.out.println("adding a new task");
			System.out.println("Please Enter the Title of the Task:");
			String title = scanner.nextLine();
			System.out.println("Please Enter the Status of the Task:");
			String status = scanner.nextLine();
			System.out.println("Please Enter the Date of the Task:");
			String dateTask = scanner.nextLine();
			System.out.println("Please Enter the Project of the Task:");
			String project = scanner.nextLine();
			
			SimpleDateFormat td = new SimpleDateFormat("yyyy-MM-dd");
			Date datetask = td.parse(dateTask);
		    Tasks.add(new Task(title,status,datetask,project));
			System.out.println("Task Created");
	}
	public static  void printAllTasks()
	{
		   System.out.println("------------------------------------------------------------------");
	       Tasks.forEach(task -> {
	    	   System.out.println("Title of the task: "+task.getTitleTask() );
	    	      System.out.println("Status of the task: " +task.getStatusTask() );
	    	      System.out.println("Date of the Task: " +task.getDateTask() );
	    	      System.out.println("This task belong to this Project: " + task.getProjectTask());
	    	      System.out.println("Index of the task :" +Tasks.indexOf(task) );
	    	      System.out.println("");
	    	   
	       });
	       System.out.println("------------------------------------------------------------------");
	   }
	public static void editTasks()  {
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
		        keybd.nextLine();  //clear input stream
		        switch (choice) {
		          case 1:  
		            System.out.print("You choose to update a task\n ");
		            UpdateTasks();
		            break;

		          case 2:  
		            System.out.println("You choose to remove a task " );
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
		            System.out.println("Sorry, but " + choice + " is not one of " +
		                "the menu choices. Please try again.");
		            break;
		        }
		      }catch (java.util.InputMismatchException ime) {
		        System.out.println("Sorry, but you must enter a number.");
		        keybd.nextLine();  //clear bad input from stream
		      
		    }
	    }}
	public static  void Removal()
	{
		Scanner in = new Scanner(System.in);
	    System.out.println("Enter the index Element to be deleted : ");
	    int elem = in.nextInt();
	    Tasks.remove(elem);
	    }
	               
	           
	  public static  void MarkAsDone() 
	  {
		  Scanner in = new Scanner(System.in);
	      System.out.println("Enter the index Element to be Masked as done : ");
	      int elem = in.nextInt();
	      Tasks.get(elem).setStatusTask("done");
	      }
	  public static void UpdateTasks()  {
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
			        keybd.nextLine();  //clear input stream
			        switch (choice) {
			          case 1:  
			            System.out.print("You choose to update the title of the task\n ");
			            Scanner in = new Scanner(System.in);
			            System.out.println("Enter the index Element to change his title: ");
			         	int elem = in.nextInt();
			         	System.out.println("Enter the new title: ");
			         	String titlenew = in.next();
			            Tasks.get(elem).setTitleTask(titlenew);
			            break;

			          case 2:  
		            System.out.println("You choose to update the date of the task\n" );
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
							Tasks.get(elem1).setDateTask(date);
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
			            Tasks.get(elem11).setProjectTask(projectnew);
			            break;
			            
			          case 4:
				        System.out.println("You choose to exit the update ");
				        break;

			          default:
			            System.out.println("Sorry, but " + choice + " is not one of " +
			                "the menu choices. Please try again.");
			            break;
			        }
			      }catch (java.util.InputMismatchException ime) {
			        System.out.println("Sorry, but you must enter a number.");
			        keybd.nextLine();  //clear bad input from stream
			      }}
		}
	
	
		   
	   
	
}


