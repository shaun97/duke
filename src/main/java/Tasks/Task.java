package Tasks;

/**
 * This class is the superclass for all the different tasks
 */
public class Task {
    private String description;
    private boolean isDone;

    /**
     * This is the constructor for the task class
     *
     * @param description is the description of the task
     * @param isDone      is the boolean variable that determines the status
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * This function returns the icon reflecting the status of the task
     */
    public String getStatusIcon() {
        return ("[" + (isDone ? "\u2713" : "\u2717") + "] ");
    }

    /**
     * This function returns the description
     * of the task
     *
     * @return the string, description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This function returns the status of the task
     *
     * @return a boolean isDone
     */
    public boolean getIsDone() {
        return isDone;
    }

    /**
     * This function marks the task as done
     */
    public void markDone() {
        this.isDone = true;
    }

    /**
     * This function returns the state of the task for storage.
     *
     * @return a string of the right format to store
     */
    public String toStore() {
        return isDone ? "1|" : "0|" + description;
    }
}
