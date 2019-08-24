import java.util.*;

public class Commands {
    private List<String> l = new ArrayList<>();

    public void storeCommands(String s) {
        l.add(s);
    }

    public void getCommands() {
        for (int i = 0; i < l.size(); i++) {
            System.out.println(i + 1 + ". " + l.get(i));
        }
    }
}
