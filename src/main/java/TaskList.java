import Tasks.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the data structure of the tasks added to duke.
 * Uses an ArrayList to store the list.
 */
public class TaskList {
    List<Task> l = new ArrayList<>();
    Storage f = new Storage(l);

    /**
     * This function adds a task into the ArrayList of tasks, calls the function to update
     * the txt file and prints out the relevant reply.
     *
     * @param t is of task type of the task to add
     */
    public void addTask(Task t) {
        l.add(t);
        f.updateFile();
        System.out.println("    Got it. I've added this task:");
        System.out.println("      " + t.toString());
        System.out.println("    Now you have " + l.size() + ((l.size() == 1) ? " task" : " tasks") + " in the list.");
    }

    /**
     * This program takes in an index and marks the corresponding task as done,
     * it then updates the file and prints out the relevant reply
     *
     * @param index is the index of the task that is completed
     */

    public void markDone(int index) {
        l.get(index - 1).markDone();
        f.updateFile();
        System.out.println("    Nice! I've marked this task as done:");
        System.out.println("      " + l.get(index - 1).toString());
    }

    /**
     * This function prints out all the tasks in the list. Calls the
     * toString() of each task to print out the relevant details
     *
     */
    public void listTask() {
        System.out.println("    Here are the tasks in your list:");
        for (int i = 1; i <= l.size(); i++) {
            System.out.println("    " + i + "." + l.get(i - 1).toString());
        }
    }

    /**
     * This function takes in an index and deletes the respective task from the list,
     * updates the storage and prints out the relevant reply.
     *
     * @param index
     */
    public void deleteTask(int index) {
        System.out.println("    Noted. I've removed this task:");
        System.out.println("      " + l.get(index).toString());
        l.remove(index);
        System.out.println("    Now you have " + l.size() + ((l.size() == 1) ? " task" : " tasks") + " in the list.");
        f.updateFile();
    }

    /**
     * This function takes in a String query and searches through the tasklist and prints out the matching
     * tasks.
     *
     * @param query
     */
    public void findTask(String query) {
        int index = 1;
        boolean haveMatch = false;
        System.out.println("    Here are the matching tasks in your list:");
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).toString().contains(query)) {
                System.out.println("    " + index + "." + l.get(i).toString());
                haveMatch = true;
                index++;
            }
        }
        if (!haveMatch) {
            System.out.println("    Sorry... there are no tasks matching your query");
        }
    }
}
