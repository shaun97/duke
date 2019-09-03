import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;

import java.util.*;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TaskList l = new TaskList();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");

        while (true) {
            String s = in.nextLine();
            if (s.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                System.exit(0);
            } else if (s.equals("list")) {
                l.listTask();
            } else if (s.contains("done")) {
                try {
                    int index = Integer.parseInt(s.substring(5));
                    l.markDone(index);
                } catch (Exception e) {
                    System.out.println("    \u2639 OOPS!! Please specify what you did.");
                }
            } else if (s.contains("todo")) {
                try {
                    Task temp = new Todo(s.substring(5), false);
                    l.addTask(temp);
                } catch (Exception e) {
                    System.out.println("    \u2639 OOPS!! The description of a todo cannot be empty.");
                }

            } else if (s.contains("deadline")) {
                try {
                    String[] parts = s.substring(9).split("/by ");
                    Task temp = new Deadline(parts[0], parts[1], false);
                    l.addTask(temp);
                } catch (Exception e) {
                    System.out.println("    \u2639 OOPS!! The description of a deadline cannot be empty.");
                }
            } else if (s.contains("event")) {
                try {
                    String[] parts = s.substring(6).split("/at ");
                    Task temp = new Event(parts[0], parts[1], false);
                    l.addTask(temp);
                } catch (Exception e) {
                    System.out.println("    \u2639 OOPS!! The description of a deadline cannot be empty.");
                }
            } else if (s.contains("delete")) {
                try {
                    int index = Integer.parseInt(s.substring(7)) - 1;
                    l.deleteTask(index);
                } catch (Exception e) {
                    System.out.println("    \u2639 OOPS!! The description of a event cannot be empty.");
                }
            } else if (s.contains("find")) {
                String query = s.substring(5);
                l.findTask(query);
            } else {
                System.out.println("    \u2639 OOPS!! I'm sorry, but I don't know what that means :-(");
            }
        }
    }
}
