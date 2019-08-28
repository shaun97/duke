public class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return ("[" + (isDone ? "\u2713" : "\u2717") + "] ");
    }

    public String getDescription() {
        return description;
    }
    public boolean getIsDone() { return isDone; }

    public void markDone() {
        this.isDone = true;
    }

    public String toStore() {
        return isDone ? "1|" : "0|" + description;
    }
}
