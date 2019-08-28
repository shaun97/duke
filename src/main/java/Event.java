public class Event extends Task {

    private String at;

    public Event(String description, String by) {
        super(description);
        this.at = by;
    }

    @Override
    public String toStore() {
        return "E|" + (super.getIsDone() ? "1|" : "0|") + super.getDescription();
    }


    public String toString() {
        return "[E]" + super.getStatusIcon() + super.getDescription() + " (at:" + at.substring(2) + ")";
    }
}
