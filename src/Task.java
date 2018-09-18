import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {

   String title;
   String status;
   String dateTask;
   String project;

   // This is the constructor of the class Task
   public Task(String title) {
      this.title = title;
   }
   
   public Task(String title,String status , String project) {
		this.title=title;
		this.status=status;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		this.dateTask=sdf.format(new Date()); 
		this.project=project;
		
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
   
   
   
   
}
