public class Deadline extends Task {

    private String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public String toString() {
        return "[D]" + super.getStatusIcon() + super.getDescription() + " (by:" + by.substring(2) + ")";
    }
}
