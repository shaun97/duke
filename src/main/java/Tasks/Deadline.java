package Tasks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {

    private String by;
    private Date date;

    public Deadline(String description, String by, boolean isDone) {
        super(description, isDone);
        this.by = by;
        storeDate(by);
    }

    public void storeDate(String by) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HHmm");
        Date convertedDate = new Date();
        try {
            date = df.parse(by);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        date = convertedDate;
    }

    @Override
    public String toStore() {
        return "D~" + (super.getIsDone() ? "1~" : "0~") + super.getDescription() + "/by " + by;
    }

    public String toString() {
        return "[D]" + super.getStatusIcon() + super.getDescription() + " (by: " + by + ")";
    }
}
