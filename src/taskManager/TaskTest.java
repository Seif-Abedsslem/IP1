/**
 * 
 */
package taskManager;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tmp-sda-1172
 *
 */
class TaskTest {

	private static final String PROJECT_NAME = "project name";
	private static final String DONE = "Done";
	private static final String TASK_TITLE = "task title";
	private static Date datetask;
	private static Task task;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		datetask = new SimpleDateFormat("yyyy-MM-dd").parse("2014-09-15");
		task = new Task(TASK_TITLE, DONE, datetask, PROJECT_NAME);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link taskManager.Task#Task(java.lang.String, java.lang.String, java.util.Date, java.lang.String)}.
	 */
	@Test
	void testTask() {
		assertNotNull(task);
	}

	/**
	 * Test method for {@link taskManager.Task#getTitleTask()}.
	 */
	@Test
	void testGetTitleTask() {
		assertEquals(0,task.getTitleTask().compareTo(TASK_TITLE));
	}

	/**
	 * Test method for {@link taskManager.Task#getStatusTask()}.
	 */
	@Test
	void testGetStatusTask() {
		assertEquals(0,task.getStatusTask().compareTo(DONE));
	}

	/**
	 * Test method for {@link taskManager.Task#getProjectTask()}.
	 */
	@Test
	void testGetProjectTask() {
		assertEquals(0,task.getProjectTask().compareTo(PROJECT_NAME));
	}

	/**
	 * Test method for {@link taskManager.Task#getDateTask()}.
	 */
	@Test
	void testGetDateTask() {
		assertEquals(0,task.getDateTask().compareTo(datetask));
	}

	/**
	 * Test method for {@link taskManager.Task#setStatusTask(java.lang.String)}.
	 */
	@Test
	void testSetStatusTask() {
		String statusupdate = "Not done";
		task.setStatusTask(statusupdate);
		assertEquals(0,task.getStatusTask().compareTo(statusupdate));
	}

	/**
	 * Test method for {@link taskManager.Task#setTitleTask(java.lang.String)}.
	 */
	@Test
	void testSetTitleTask() {
		String titleupdate = "new title";
		task.setTitleTask(titleupdate);
		assertEquals(0,task.getTitleTask().compareTo(titleupdate));
	}

	/**
	 * Test method for {@link taskManager.Task#setProjectTask(java.lang.String)}.
	 */
	@Test
	void testSetProjectTask() {
		String projectupdate = "New project";
		task.setProjectTask(projectupdate);
		assertEquals(0,task.getProjectTask().compareTo(projectupdate));
	}

	/**
	 * Test method for {@link taskManager.Task#setDateTask(java.util.Date)}.
	 * @throws ParseException 
	 */
	@Test
	void testSetDateTask() throws ParseException {
		String dateupdate = "2015-01-20";
		Date dateupdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateupdate);
		task.setDateTask(dateupdate1);
		assertEquals(0,task.getDateTask().compareTo(dateupdate1));
	}

}
