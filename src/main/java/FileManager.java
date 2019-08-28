import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileManager {
    List<Task> l;

    public FileManager(List<Task> l) {
        this.l = l;
        System.out.println(l.size());
    }

    public void insertToFile (Task t) {
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
}
