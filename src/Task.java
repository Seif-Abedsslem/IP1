import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Task {

  private String title;
  private String status;
  private String dateTask;
  private String project;

   // This is the constructor of the class Task
    public Task(String title,String status , String project) {
		this.title=title;
		this.status=status;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		this.dateTask=sdf.format(new Date()); 
		this.project=project;
		
	}
   public String getTitleTask() {
       return title;
   }
   public String getStatusTask() {
       return status;
   }
   public String getProjectTask() {
       return project;
   }

   // Assign the status of the task  to the variable status.
   public void taskStatus(String taskStatus) {
      status = taskStatus;
   }

   /* Assign the date to the variable dateTask.*/
   public void TaskDate() {
	   SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
	    dateTask = sdf.format(new Date()); 
      
   }

   /* Assign the name of the project which the task belongs to it to the variable project.*/
   public void taskProject(String taskProject) {
      project = taskProject;
   }

   /* Print the Task details */
   public void printTasks() {
      System.out.println("Title of the task: "+ title );
      System.out.println("Status of the task: " +status );
      System.out.println("Date of the Task: " + dateTask );
      System.out.println("This task belong to this Project: " + project);
      System.out.println("");
   }
   
   public static void addTask(Scanner scanner) 
	{
			
			System.out.println("adding a new task");
			System.out.println("Please Enter the Title of the Task:");
			
			String title = scanner.nextLine();
			System.out.println("Please Enter the Status of the Task:");
			
			String status = scanner.nextLine();
			System.out.println("Please Enter the Project of the Task:");
			
			
			String project = scanner.nextLine();
			
			Task taskone = new Task (title,status,project);
			taskone.printTasks();
			System.out.println("Task Created");
	}
   
   public static void printAllTasks() {
	   
       List<Task> Tasks = new ArrayList<>();
       Tasks.add(new Task("Rajeev", "done","project1"));
       Tasks.add(new Task("John", "done","project1"));
       Tasks.add(new Task("Steve", "done","project1"));

       Tasks.forEach(task -> {
           System.out.println(task.getTitleTask());});
   }
   
   
   
   
}
