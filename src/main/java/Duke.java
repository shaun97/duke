import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;

import java.util.*;

/**
 * The Duke program implements a CLI application that is
 * an assistant that supports to-do lists, events and deadlines.
 * Data is saved across sessions.
 *
 * @author Shaun
 * @version v1.0
 */
public class Duke {
    public static void main(String[] args) {
        new UI();
    }
}
