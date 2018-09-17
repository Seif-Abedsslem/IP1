public class Task {

   String title;
   String status;
   String dateTask;
   String project;

   // This is the constructor of the class Task
   public Task(String title) {
      this.title = title;
   }

   // Assign the status of the task  to the variable status.
   public void taskStatus(String taskStatus) {
      status = taskStatus;
   }

   /* Assign the date to the variable dateTask.*/
   public void TaskDate(String taskDate) {
      dateTask = taskDate ;
   }

   /* Assign the name of the project which the task belongs to it to the variable project.*/
   public void taskProject(String taskProject) {
      project = taskProject;
   }

   /* Print the Task details */
   public void printTasks() {
      System.out.println("Title:"+ title );
      System.out.println("Status:" +status );
      System.out.println("Date of the Task:" + dateTask );
      System.out.println("Belong to this Project" + project);
      System.out.println("");
   }}
