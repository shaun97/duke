import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * This classes handles the logic of storing all the data
 * into a txt file. Data is stored in this format
 * {Task Type}~{Status}~{Description}
 */
public class Storage {
    List<Task> l;

    /**
     * Constructor function for this class
     *
     * @param l is the task list that gets parsed in
     */
    public Storage(List<Task> l) {
        this.l = l;
        this.loadData();
    }

    /**
     * This function opens the txt file and unpacks the data from the
     * txt file and loads it into the program. If the file does not exist,
     * it creates it for the program to store data there.
     */
    public void loadData() { //if no file
        try {
            File file = new File("data/duke.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            Scanner scanner = new Scanner(file);

            String line = null;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] w = line.split("~"); // | counts as well
                if (w[0].equals("T")) {
                    String description = w[2];
                    boolean isDone = (w[1].equals("1"));
                    l.add(new Todo(description, isDone));
                } else if (w[0].equals("E")) {
                    String[] parts = w[2].split("/at ");
                    boolean isDone = (w[1].equals("1"));
                    l.add(new Event(parts[0], parts[1], isDone));
                } else if (w[0].equals("D")) {
                    String[] parts = w[2].split("/by ");
                    boolean isDone = (w[1].equals("1"));
                    l.add(new Deadline(parts[0], parts[1], isDone));
                }
            }
        } catch (IOException ioe) {
        }
    }

    /**
     * This function updates the txt file data storage with the latest
     * list in the program. It rewrites the text file with the latest
     * data.
     */
    public void updateFile() {
        try {
            File file = new File("data/duke.txt");
            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < l.size(); i++) {
                bw.newLine();
                bw.write(l.get(i).toStore());
            }
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
