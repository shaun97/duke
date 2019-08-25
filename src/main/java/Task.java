enum Status {
    Undone,
    Done,
}

public class Task {
    private String task;
    Status status;

    public Task(String T) {
        this.task = T;
        this.status = Status.Undone;
    }

    public String getStatus() {
        return (status == Status.Done) ? "\u2713" : "\u2717";
    }

    public String getTask() {
        return task;
    }

    public void markDone() {
        this.status = Status.Done;
        System.out.println("Nice! I've marked this task as done:");
        System.out.print(" [" + "\u2713" + "] " + task);
    }


}
