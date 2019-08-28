public class Event extends Task {

    private String at;

    public Event(String description, String at, boolean isDone) {
        super(description, isDone);
        this.at = at;
    }

    @Override
    public String toStore() {
        return "E~" + (super.getIsDone() ? "1~" : "0~") + super.getDescription() + "/" + at;
    }


    public String toString() {
        return "[E]" + super.getStatusIcon() + super.getDescription() + " (at:" + at.substring(2) + ")";
    }
}
