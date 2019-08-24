import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

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
            } else {
                System.out.println(s);
            }
        }
    }
}
