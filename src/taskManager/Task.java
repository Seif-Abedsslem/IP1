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
	 * @param title
	 * @param status
	 * @param dateTask
	 * @param project
	 */
	public Task(String title, String status, Date dateTask, String project) {
		this.title = title;
		this.status = status;
		this.dateTask = dateTask;
		this.project = project;

	}

	/**
	 * @return
	 */
	public String getTitleTask() {
		return title;
	}

	/**
	 * @return
	 */
	public String getStatusTask() {
		return status;
	}

	/**
	 * @return
	 */
	public String getProjectTask() {
		return project;
	}

	/**
	 * @return
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
	
	
	public String toString() {
		String s = "\n Title: " + title + " Status: " + status + " Date: " + dateTask + " Project: " + project + "\n";
		return s;
	}

}
