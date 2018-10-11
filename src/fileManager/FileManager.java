package fileManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import taskManager.Task;

/**
 * @author tmp-sda-1172
 *
 */
public class FileManager {

	private static final String FILE_PATH = "/Users/tmp-sda-1172/Desktop/IP1/src/test.txt";

	/**
	 * @param tasks
	 */
	public void saveTasksToFile(List<Task> tasks) {
		try {
			// List<Task> tasksList = tasks.subList(0, tasks.size()-1);
			saveCollectionToFile(tasks);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * @param collection
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void saveCollectionToFile(List<Task> collection) throws FileNotFoundException, IOException {
		FileOutputStream fos = new FileOutputStream(FILE_PATH);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(collection);
		oos.close();
		fos.close();
	}

	/**
	 * @param task
	 */
	public void saveTaskToFile(Task task) {
		try {
			FileOutputStream fos = new FileOutputStream(FILE_PATH);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(task);
			oos.close();
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Task> readTaskFromFile() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = getObjectInputStream();
		ArrayList<Task> readObject = (ArrayList<Task>) ois.readObject();
		ois.close();
		ArrayList<Task> result = new ArrayList<Task>(readObject);
		return result;
	}

	/**
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public ObjectInputStream getObjectInputStream() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream(FILE_PATH);
		ObjectInputStream ois = new ObjectInputStream(fis);
		return ois;
	}

	/**
	 * @return An ArrayList of {@link Task}
	 */
	public ArrayList<Task> loadTasksFromFile() {
		ArrayList<Task> result = new ArrayList<>();
		try {
			result = readTaskFromFile();
		} catch (ClassNotFoundException | IOException e1) {

			e1.printStackTrace();
		} finally {
			System.out.println("Tasks loaded from file.");
		}
		return result;
	}

}
