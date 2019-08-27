public class Event extends Task {

    private String at;

    public Event(String description, String by) {
        super(description);
        this.at = by;
    }

    public String toString() {
        return "[E]" + super.getStatusIcon() + super.getDescription() + " (at:" + at.substring(2) + ")";
    }
}
