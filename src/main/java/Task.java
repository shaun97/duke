public class Task {
    private String task;
    private boolean isDone;

    public Task(String T) {
        this.task = T;
        this.isDone = false;
    }

    public String getStatus() {
        return isDone ? "\u2713" : "\u2717";
    }

    public String getTask() {
        return task;
    }

    public void markDone() {
        this.isDone = true;
        System.out.println("Nice! I've marked this task as done:");
        System.out.print(" [" + "\u2713" + "] " + task);
    }
}
