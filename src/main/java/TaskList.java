import java.util.*;

public class TaskList {
    private List<Task> l = new ArrayList<>();
    public void storeTasks(String s) {
        l.add(new Task(s));
    }

    public void markTasks(int n) {
        l.get(n).markDone();
    }

    public void getTasks() {
        System.out.println("Here are tasks in your list:");
        for (int i = 0; i < l.size(); i++) {
            System.out.print(i + 1 + ".[" + l.get(i).getStatus() + "] ");
            System.out.println(l.get(i).getTask());
        }
    }
}
