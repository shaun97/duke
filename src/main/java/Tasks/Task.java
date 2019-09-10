package Tasks;

public class Task {
    private String description;
    private boolean isDone;

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


    public String getDescription() {
        return description;
    }
    public boolean getIsDone() {
        return isDone;
    }

    public void markDone() {
        this.isDone = true;
    }

    /**
     * This function returns the state of the task for storage.
     * @return
     */
    public String toStore() {
        return isDone ? "1|" : "0|" + description;
    }
}
