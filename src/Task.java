import java.util.Date;

public class Task {
	

  private String title;
  private String status;
  private Date dateTask = new Date();
  private String project;

   // This is the constructor of the class Task
    public Task(String title,String status, Date dateTask , String project) 
    {
		this.title=title;
		this.status=status;
		this.dateTask=dateTask;
		this.project=project;
		
		
	}
   public String getTitleTask()  
	   {
	       return title;
	   }
   public String getStatusTask() 
	   {
	       return status;
	   }
   public String getProjectTask() 
	   {
	       return project;
	   }
   public Date getDateTask() 
	   {
		   return dateTask;
	   }
   public void setStatusTask(String statusupdate)
       { 
	       status = statusupdate;
	   }
   public void setTitleTask(String titleupdate) 
       { 
	       title = titleupdate;
	   }
   public void setProjectTask(String projectupdate)
       { 
	       project = projectupdate;
	   }
   public void setDateTask(Date datenew) 
       { 
	       dateTask = datenew; 
	   }
   
   

   

   /* Print the Task details */
   public String toString() {
	   String s = "\n Title: "+ title + " Status: " +status + " Date: " + dateTask + " Project: " + project + "\n";
      return s;
   }
   
}
