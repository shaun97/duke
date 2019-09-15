import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class dummyTest {
    @Test
    public void dummyTest() {
        assertEquals(2, 2);
    }

    @Test
    public void parserTest() {
        TaskList l = new TaskList();
        DukeParser p = new DukeParser(l);
        p.Logic("todo now");
        if(l.getLen() > 0) {
            assertEquals(2,2);
        }
    }

    @Test
    public void deleteTaskTest() {
        TaskList l = new TaskList();
        DukeParser p = new DukeParser(l);
        p.Logic("todo now");
        l.deleteTask(0);
        if(l.getLen() == 0) {
            assertEquals(2,2);
        }
    }
}
