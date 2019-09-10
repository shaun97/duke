package Tasks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {

    private String at;
    private Date date;

    public Event(String description, String at, boolean isDone) {
        super(description, isDone);
        this.at = at;
        storeDate(at);

    }

    /**
     * This function takes in the date in string format and converts it into
     * a date class.
     *
     * @param by
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
     * This function converts the Event task into the format for storage.
     *
     * @return
     */
    @Override
    public String toStore() {
        return "E~" + (super.getIsDone() ? "1~" : "0~") + super.getDescription() + "/at " + at;
    }

    /**
     * This function prints out this Event task into the command line
     *
     * @return
     */
    public String toString() {
        return "[E]" + super.getStatusIcon() + super.getDescription() + " (at: " + at + ")";
    }
}
