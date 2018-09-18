import java.util.Scanner;



public class UserInterface {

	public static void main(String[] args)
	  {
	    
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
			
			
		     
		     
		     Scanner scanner = new Scanner(System.in);
		     int choice ;
		    
			
			do {
				choice = scanner.nextInt();
		     
		      switch(choice) {
		         case 1 :
		        	 System.out.println(">>you choose to Show Task List (by date or project)");
		        	 
		        	
		            break;
		         case 2 :
		        	 System.out.println(">>you choose to Add New Task");
		        	
		         	break;
		         case 3 :
		        	 System.out.println(">>you choose to dit Task (update, mark as done, remove)");
		        	 
		            break;
		         case 4 :
		        	 System.out.println(">>you choose to save and Quit");
		        	 
		            break;
		         
		         default :
		        	 System.out.println("***********************************************************************"); 
		             System.out.println("You have chosen an invalid option");
		             System.out.println("***********************************************************************");
		             System.out.println("Please insert a number between 1 and 4");
		             System.out.println("***********************************************************************");
		             
		      }}
		      while(choice != 1 ||choice != 2 ||choice != 3 ||choice != 4 );
			
			
				scanner.close();
				
		      
	}

}
