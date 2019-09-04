import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;

public class Parser {
    private TaskList l;

    public Parser(TaskList l) {
        this.l = l;
    }

    public void Logic(String Command) {
        if (Command.equals("bye")) {
            System.out.println("Bye. Hope to see you again soon!");
            System.exit(0);
        } else if (Command.equals("list")) {
            l.listTask();
        } else if (Command.contains("done")) {
            try {
                int index = Integer.parseInt(Command.substring(5));
                l.markDone(index);
            } catch (Exception e) {
                System.out.println("    \u2639 OOPS!! Please specify what you did.");
            }
        } else if (Command.contains("todo")) {
            try {
                Task temp = new Todo(Command.substring(5), false);
                l.addTask(temp);
            } catch (Exception e) {
                System.out.println("    \u2639 OOPS!! The description of a todo cannot be empty.");
            }
        } else if (Command.contains("deadline")) {
            try {
                String[] parts = Command.substring(9).split("/by ");
                Task temp = new Deadline(parts[0], parts[1], false);
                l.addTask(temp);
            } catch (Exception e) {
                System.out.println("    \u2639 OOPS!! The description of a deadline cannot be empty.");
            }
        } else if (Command.contains("event")) {
            try {
                String[] parts = Command.substring(6).split("/at ");
                Task temp = new Event(parts[0], parts[1], false);
                l.addTask(temp);
            } catch (Exception e) {
                System.out.println("    \u2639 OOPS!! The description of a deadline cannot be empty.");
            }
        } else if (Command.contains("delete")) {
            try {
                int index = Integer.parseInt(Command.substring(7)) - 1;
                l.deleteTask(index);
            } catch (Exception e) {
                System.out.println("    \u2639 OOPS!! The description of a event cannot be empty.");
            }
        } else if (Command.contains("find")) {
            String query = Command.substring(5);
            l.findTask(query);
        } else {
            System.out.println("    \u2639 OOPS!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
