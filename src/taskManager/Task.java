package taskManager;

import java.io.Serializable;
import java.util.Date;

/**This is the class task that contain 4 fields and constrator and the getters and the setters 
 * @author Seifeddine Abedsslem
 *
 */
public class Task implements Serializable {
    // this is the fields of the class task
	private String title;
	private String status;
	private Date dateTask = new Date();
	private String project;

	// This is the constructor of the class Task
	/**
	 * @param title Task title
	 * @param status Task status
	 * @param dateTask Task date 
	 * @param project Task project
	 */
	public Task(String title, String status, Date dateTask, String project) {
		this.title = title;
		this.status = status;
		this.dateTask = dateTask;
		this.project = project;

	}
	// This is the method getTiltleTask of the class Task that return the title of the task
	/**
	 * @return title of task type String
	 */
	public String getTitleTask() {
		return title;
	}
	// This is the method getStatusTask of the class Task that return the status of the task
	/**
	 * @return status of task type String
	 */
	public String getStatusTask() {
		return status;
	}
	// This is the method getProjectTask of the class Task that return the project of the task
	/**
	 * @return project of task type String
	 */
	public String getProjectTask() {
		return project;
	}
	// This is the method getDateTask of the class Task that return the date of the task
	/**
	 * @return date of task type Date
	 */
	public Date getDateTask() {
		return dateTask;
	}
	//This is the method setStatusTask of the class Task that set the Status of the task
	/**
	 * @param statusupdate type String
	 */
	public void setStatusTask(String statusupdate) {
		status = statusupdate;
	}
	//This is the method setTitleTask of the class Task that set the Title of the task
	/**
	 * @param titleupdate type String
	 */
	public void setTitleTask(String titleupdate) {
		title = titleupdate;
	}
	//This is the method setProjectTask of the class Task that set the Project of the task
	/**
	 * @param projectupdate type String
	 */
	public void setProjectTask(String projectupdate) {
		project = projectupdate;
	}
	//This is the method setDateTask of the class Task that set the Date of the task
	/**
	 * @param datenew type Date
	 */
	public void setDateTask(Date datenew) {
		dateTask = datenew;
	}

	/* Print the Task details */
	
	
	@Override
	public String toString() {
		String s = "\n Title: " + title + " Status: " + status + " Date: " + dateTask + " Project: " + project + "\n";
		return s;
	}

}
