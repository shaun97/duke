package Tasks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Event is a subclass of Task
 * and represents events
 */
public class Event extends Task {

    private String at;
    private Date date;

    /**
     * This is the constructor of Event
     *
     * @param description a string of the event
     * @param at          a string denoting the time of the event
     * @param isDone      is the boolean determining the status of the event
     */
    public Event(String description, String at, boolean isDone) {
        super(description, isDone);
        this.at = at;
        storeDate(at);

    }

    /**
     * This function takes in the date in string format and converts it into
     * a date class.
     *
     * @param by is the string that this deadline is done by
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
     * @return a string in the format for storage in a txt file
     */
    @Override
    public String toStore() {
        return "E~" + (super.getIsDone() ? "1~" : "0~") + super.getDescription() + "/at " + at;
    }

    /**
     * This function prints out this Event task into the command line
     *
     * @return a string in the format to be printed out
     */
    public String toString() {
        return "[E]" + super.getStatusIcon() + super.getDescription() + " (at: " + at + ")";
    }
}
