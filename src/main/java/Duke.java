import java.util.*;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Task> l = new ArrayList<>();

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
                System.out.print("Bye. Hope to see you again soon!");
                System.exit(0);
            } else if (s.equals("list")) {
                System.out.println("    Here are the tasks in your list:");
                for (int i = 1; i <= l.size(); i++) {
                    System.out.println("    " + i + "." + l.get(i - 1).toString());
                }
            } else if (s.contains("done")) {
                l.get(Integer.parseInt(s.substring(5)) - 1).markDone();
                System.out.println("    Nice! I've marked this task as done:");
                System.out.println("      " + l.get(Integer.parseInt(s.substring(5)) - 1).toString());
            } else if (s.contains("todo")) {
                Task temp = new Todo(s.substring(5));
                l.add(temp);
                System.out.println("    Got it. I've added this task:");
                System.out.println("      " + temp.toString());
                System.out.println("    Now you have " + l.size() + ((l.size() == 1) ? " task" : " tasks") + " in the list.");
            } else if (s.contains("deadline")) {
                String[] parts = s.substring(9).split("/");
                Task temp = new Event(parts[0], parts[1]);
                l.add(temp);
                System.out.println("    Got it. I've added this task:");
                System.out.println("      " + temp.toString());
                System.out.println("    Now you have " + l.size() + ((l.size() == 1) ? " task" : " tasks") + " in the list.");
            }  else if (s.contains("event")) {
                String[] parts = s.substring(6).split("/");
                Task temp = new Event(parts[0], parts[1]);
                l.add(temp);
                System.out.println("    Got it. I've added this task:");
                System.out.println("      " + temp.toString());
                System.out.println("    Now you have " + l.size() + ((l.size() == 1) ? " task" : " tasks") + " in the list.");
            }
        }
    }
}
