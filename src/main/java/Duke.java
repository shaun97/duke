import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Task> l = new ArrayList<>();
        FileManager f = new FileManager(l);

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
                System.out.println("    Here are the tasks in your list:");
                for (int i = 1; i <= l.size(); i++) {
                    System.out.println("    " + i + "." + l.get(i - 1).toString());
                }
            } else if (s.contains("done")) {
                try {
                    int index = Integer.parseInt(s.substring(5));
                    l.get(index - 1).markDone();
                    f.updateFile();
                    System.out.println("    Nice! I've marked this task as done:");
                    System.out.println("      " + l.get(Integer.parseInt(s.substring(5)) - 1).toString());
                } catch (Exception e) {
                    System.out.println("    \u2639 OOPS!! Please specify what you did.");
                }
            } else if (s.contains("todo")) {
                try {
                    Task temp = new Todo(s.substring(5), false);
                    l.add(temp);
                    f.insertToFile(temp);
                    System.out.println("    Got it. I've added this task:");
                    System.out.println("      " + temp.toString());
                    System.out.println("    Now you have " + l.size() + ((l.size() == 1) ? " task" : " tasks") + " in the list.");
                } catch (Exception e) {
                    System.out.println("    \u2639 OOPS!! The description of a todo cannot be empty.");
                }

            } else if (s.contains("deadline")) {
                try {
                    String[] parts = s.substring(9).split("/by ");
                    Task temp = new Deadline(parts[0], parts[1], false);
                    l.add(temp);
                    f.insertToFile(temp);
                    System.out.println("    Got it. I've added this task:");
                    System.out.println("      " + temp.toString());
                    System.out.println("    Now you have " + l.size() + ((l.size() == 1) ? " task" : " tasks") + " in the list.");
                } catch (Exception e) {
                    System.out.println("    \u2639 OOPS!! The description of a deadline cannot be empty.");
                }
            } else if (s.contains("event")) {
                try {
                    String[] parts = s.substring(6).split("/at ");
                    Task temp = new Event(parts[0], parts[1], false);
                    l.add(temp);
                    f.insertToFile(temp);
                    System.out.println("    Got it. I've added this task:");
                    System.out.println("      " + temp.toString());
                    System.out.println("    Now you have " + l.size() + ((l.size() == 1) ? " task" : " tasks") + " in the list.");
                } catch (Exception e) {

                }
            } else if (s.contains("delete")) {
                try {
                    int index = Integer.parseInt(s.substring(7)) - 1;
                    System.out.println("    Noted. I've removed this task:");
                    System.out.println("      " + l.get(index).toString());
                    l.remove(index);
                    System.out.println("    Now you have " + l.size() + ((l.size() == 1) ? " task" : " tasks") + " in the list.");
                    f.updateFile();
                } catch (Exception e) {
                    System.out.println("    \u2639 OOPS!! The description of a event cannot be empty.");
                }
            } else{
                System.out.println("    \u2639 OOPS!! I'm sorry, but I don't know what that means :-(");
            }
        }
    }
}
