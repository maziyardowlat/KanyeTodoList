package persistance;

import model.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkName(String name, String title, Task tasks, String dueDate, String startDate) {
        assertEquals(name, tasks.getName());
        assertEquals(title, tasks.getTitle());
        assertEquals(dueDate, tasks.getDueDate());
        assertEquals(startDate, tasks.getStartDate());
    }
}
