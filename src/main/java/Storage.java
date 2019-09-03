import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    List<Task> l;

    public FileManager(List<Task> l) {
        this.l = l;
        this.loadData();
    }

    public void loadData() { //if no file
        try {
            File file = new File("data/duke.txt");
            Scanner scanner = new Scanner(file);

            if (!file.exists()) {
                file.createNewFile();
            }

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
            ioe.printStackTrace();
        }
    }

    public void insertToFile(Task t) {
        try {

            File file = new File("data/duke.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);


            bw.newLine();
            bw.write(t.toStore());

            bw.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

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
