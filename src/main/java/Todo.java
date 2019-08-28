public class Todo extends Task {

    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    public String toStore() {
        return "T~" + (super.getIsDone() ? "1~" : "0~") + super.getDescription();
    }

    @Override
    public String toString() {
        return "[T]" + super.getStatusIcon() + super.getDescription();
    }
}
