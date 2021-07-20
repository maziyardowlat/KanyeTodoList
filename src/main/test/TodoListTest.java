package test;

import model.Task;
import model.TodoList;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class TodoListTest {
    private Task task1;
    private TodoList list1;

    @Before
    public void setup() {
        task1 = new Task("task", "task", "task", "task", "task");
    }

    @Test
    public void testGetters() {
        assertEquals(task1.getDueDate(), "task");
    }
}
