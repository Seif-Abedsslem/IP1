package fileManager;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import taskManager.TaskManagment;
import taskManager.Task;

class FileManagerTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSaveTasksToFile() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testReadTaskFromFile() throws ClassNotFoundException, IOException, ParseException {
		
		List<Task> tasks = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sf.parse(String.format("2020-09-%s", i));
			tasks.add(new Task("my title"+i,"to do",date,"Mega project"));
		}
		
		FileManager fileManager = new FileManager();
		fileManager .saveTasksToFile(tasks);
		
		
		// Act
		ArrayList<Task> readTasks = fileManager.readTaskFromFile();
		
		// Assert
		readTasks.forEach(readTask->{
			assertEquals(readTask.getTitleTask(), tasks.get(readTasks.indexOf(readTask)).getTitleTask());
		});
	}

}
