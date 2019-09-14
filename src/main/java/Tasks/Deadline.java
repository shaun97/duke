package Tasks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Deadline is the subclass of task representing a
 * deadline task
 */
public class Deadline extends Task {

    private String by;
    private Date date;

    /**
     * The constructor of deadline, takes in the description and
     * time that it is to be done by
     *
     * @param description string of the description
     * @param by          string of the time to be done by
     * @param isDone      boolean of the status of the product
     */
    public Deadline(String description, String by, boolean isDone) {
        super(description, isDone);
        this.by = by;
        storeDate(by);
    }

    /**
     * This function takes in the string of the date and converts it into
     * a date class.
     *
     * @param by the date that the task is done by
     */
    public void storeDate(String by) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HHmm");
        Date convertedDate = new Date();
        try {
            date = df.parse(by);
        } catch (ParseException e) {
        }
        date = convertedDate;
    }

    /**
     * This function converts the Deadline task into the format for storage.
     *
     * @return a string in the format to store in the txt file
     */
    @Override
    public String toStore() {
        return "D~" + (super.getIsDone() ? "1~" : "0~") + super.getDescription() + "/by " + by;
    }

    /**
     * This function prints out this task to the command line.
     *
     * @returna a string to be printed out in the command
     */
    public String toString() {
        return "[D]" + super.getStatusIcon() + super.getDescription() + " (by: " + by + ")";
    }
}
