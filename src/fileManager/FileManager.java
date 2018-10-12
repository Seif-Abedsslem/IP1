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

/** this Class called FileManager is responsible of traking tasks from file and saving them 
 * @author Seifeddine Abedsslem
 *
 */
public class FileManager {
    // this is a private static varibale type String that contain the path of the file in the computer
	private static final String FILE_PATH = "/Users/tmp-sda-1172/Desktop/IP1/src/test.txt";
    
	// this method take an arrayList as param and save it into the file
	/**
	 * @param tasks ArrayList
	 */
	public void saveTasksToFile(List<Task> tasks) {
		try {
			// List<Task> tasksList = tasks.subList(0, tasks.size()-1);
			saveCollectionToFile(tasks);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	// this method take an arrayList as param and save it into the file
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
    // this method read tasks from a file and store them into an arraylist
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
    // this method store the tasks readed from file to an arraylist called result
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
