import java.util.Scanner;

public class TaskManagment {
	
	public static void UpdateTasks() {
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
		            
		            Task.Tasks.get(elem).setTitleTask(titlenew);
		            
		            break;

		          case 2:  
		            
		              System.out.println("You choose to update the date of the task\n" );
		              
			            Scanner in1 = new Scanner(System.in);
			            System.out.println("Enter the index Element to change his date: ");
			         	int elem1 = in1.nextInt();
			         	System.out.println("Enter the new date: ");
			         	String datenew = in1.next();
			            
			            Task.Tasks.get(elem1).setDateTask(datenew);
		            break;

		          
		            

		          case 3:
		        	System.out.println("You choose to update the project of the task\n");
		        	Scanner in11 = new Scanner(System.in);
		            System.out.println("Enter the index Element to change his project: ");
		         	int elem11 = in11.nextInt();
		         	System.out.println("Enter the new project: ");
		         	String projectnew = in11.next();
		            
		            Task.Tasks.get(elem11).setProjectTask(projectnew);
		            
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
	
	

	
		
		public static void editTasks() {
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
			            Task.Removal();
			            break;

			          
			            

			          case 3:
			        	System.out.println(" You choose to mark a task ");
			            Task.MarkAsDone();
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
			    }
			   
		   
		
	}

}
