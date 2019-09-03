import Tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    List<Task> l = new ArrayList<>();
    Storage f = new Storage(l);

    public void addTask(Task t) {
        l.add(t);
        f.updateFile();
        System.out.println("    Got it. I've added this task:");
        System.out.println("      " + t.toString());
        System.out.println("    Now you have " + l.size() + ((l.size() == 1) ? " task" : " tasks") + " in the list.");
    }

    public void markDone(int index) {
        l.get(index - 1).markDone();
        f.updateFile();
        System.out.println("    Nice! I've marked this task as done:");
        System.out.println("      " + l.get(index - 1).toString());
    }

    public void listTask() {
        System.out.println("    Here are the tasks in your list:");
        for (int i = 1; i <= l.size(); i++) {
            System.out.println("    " + i + "." + l.get(i - 1).toString());
        }
    }

    public void deleteTask(int index) {
        System.out.println("    Noted. I've removed this task:");
        System.out.println("      " + l.get(index).toString());
        l.remove(index);
        System.out.println("    Now you have " + l.size() + ((l.size() == 1) ? " task" : " tasks") + " in the list.");
        f.updateFile();
    }

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
