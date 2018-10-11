package taskManager;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tmp-sda-1172
 *
 */
public class Task implements Serializable {

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

	/**
	 * @return title of task
	 */
	public String getTitleTask() {
		return title;
	}

	/**
	 * @return status of task
	 */
	public String getStatusTask() {
		return status;
	}

	/**
	 * @return project of task
	 */
	public String getProjectTask() {
		return project;
	}

	/**
	 * @return date of task
	 */
	public Date getDateTask() {
		return dateTask;
	}

	/**
	 * @param statusupdate
	 */
	public void setStatusTask(String statusupdate) {
		status = statusupdate;
	}

	/**
	 * @param titleupdate
	 */
	public void setTitleTask(String titleupdate) {
		title = titleupdate;
	}

	/**
	 * @param projectupdate
	 */
	public void setProjectTask(String projectupdate) {
		project = projectupdate;
	}

	/**
	 * @param datenew
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
