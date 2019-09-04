import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;

import java.util.Scanner;

public class UI {
    private Parser P;
    private TaskList l;

    public UI() {
        Scanner in = new Scanner(System.in);
        DukeWelcome();
        Interaction(in);
    }

    public void DukeWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
    }

    public void Interaction(Scanner in) {
        TaskList l = new TaskList();
        Parser P = new Parser(l);
        while (true) {
            String s = in.nextLine();
            P.Logic(s);
        }
    }
}
