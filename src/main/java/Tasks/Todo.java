package Tasks;

/**
 * To-do class extends task and overrides the
 * toString() function to something specific to to-do
 */
public class Todo extends Task {

    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    /**
     * This function converts the details of the class to the format to be
     * stored in the txt file.
     *
     * @return a string of the right format to be stored
     */
    public String toStore() {
        return "T~" + (super.getIsDone() ? "1~" : "0~") + super.getDescription();
    }

    /**
     * This function prints out the task onto the command line.
     *
     * @return a string to be printed out in the console
     */
    @Override
    public String toString() {
        return "[T]" + super.getStatusIcon() + super.getDescription();
    }
}
