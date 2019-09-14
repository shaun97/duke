import java.util.Scanner;

/**
 * Class that deals with the printing of the welcome message
 * and the interaction with the user.
 */
public class UI {
    private Parser P;
    private TaskList l;

    public UI() {
        DukeWelcome();
        Interaction();
    }

    /**
     * This function prints out the DUKE welcome message
     */
    public void DukeWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
    }

    /**
     * This function handles the interaction with the user and instantiates
     * the list of tasks
     */
    public void Interaction() {
        Scanner in = new Scanner(System.in);
        TaskList l = new TaskList();
        Parser P = new Parser(l);
        while (true) {
            String s = in.nextLine();
            P.Logic(s);
        }
    }
}
