import Exceptions.*;
import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;

/**
 * This class handles the logic of the commands
 * and decide which function to call
 */
public class DukeParser {
    private TaskList l;

    /**
     * Parser class has a constructor that takes in
     * a TaskList
     *
     * @param l is the list of task that gets parsed in
     */

    public DukeParser(TaskList l) {
        this.l = l;
    }

    /**
     * This function takes in a String Command and
     * determines what command is given before executing
     * the respective functions.
     *
     * @param Command is the raw command that is inputted by the user
     */
    public void Logic(String Command) {

        try {
            if (Command.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                System.exit(0);
            } else if (Command.equals("list")) {
                l.listTask();
            } else if (Command.startsWith("done")) {
                String[] data = Command.split(" ");
                if (data.length < 2) {
                    throw new InvalidTaskIndexException();
                } else {
                    l.markDone(Integer.parseInt(data[1]));
                }
            } else if (Command.contains("todo")) {
                String[] query = Command.split("todo ");
                if (query.length < 2) {
                    throw new InvalidToDoException();
                } else {
                    Task temp = new Todo(query[1], false);
                    l.addTask(temp);
                }
            } else if (Command.contains("deadline")) {
                String[] parts = Command.substring(8).split("/by ");
                if (parts[0].length() < 2) {
                    throw new InvalidDeadlineException();
                } else if (parts.length < 2) {
                    throw new InvalidDateException();
                } else {
                    Task temp = new Deadline(parts[0], parts[1], false);
                    l.addTask(temp);
                }
            } else if (Command.contains("event")) {
                String[] parts = Command.substring(6).split("/at ");
                if (parts[0].length() < 2) {
                    throw new InvalidEventException();
                } else if (parts.length < 2) {
                    throw new InvalidDateException();
                } else {
                    Task temp = new Event(parts[0], parts[1], false);
                    l.addTask(temp);
                }
            } else if (Command.startsWith("delete")) {
                String[] data = Command.split(" ");
                if (data.length < 2) {
                    throw new InvalidTaskIndexException();
                } else {
                    l.deleteTask(Integer.parseInt(data[1]) - 1);
                }
            } else if (Command.startsWith("find")) {
                String[] query = Command.split("find ");
                if (query.length < 2) {
                    throw new InvalidFindException();
                } else {
                    l.findTask(query[1]);
                }
            } else {
                throw new InvalidCommandException();
            }
        } catch (NumberFormatException e) {
            System.out.println("    \u2639 OOPS!! Please input a valid number");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
