package test;

import model.Task;
import model.TodoList;
import org.junit.Before;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;

public class TodoListTest {
    private Task task1;
    private TodoList todoList;

    @Before
    public void setup() {
        task1 = new Task("task", "task", "task", "task", "task");
        todoList = new TodoList();
    }

    @Test
    public void testAddOneTask() {
        todoList.addTask("asdf", "asdf", "asdf", "asdf", "asdf");
        List<Task> tasks = todoList.getTasks();
        assertEquals(1, tasks.size());
    }

    @Test
    public void testAddTwoTask() {
        todoList.addTask("asdf", "asdf", "asdf", "asdf", "asdf");
        todoList.addTask("assdfdfa", "asdf", "asdf", "asdf", "asdf");
        List<Task> tasks = todoList.getTasks();
        assertEquals(2, tasks.size());
    }

    @Test
    public void testRemoveATask() {
        todoList.addTask("asdf", "asdf", "asdf", "asdf", "asdf");
        todoList.addTask("assdfdfa", "asdf", "asdf", "asdf", "asdf");
        todoList.removeTask("assdfdfa", "asdf", "asdf", "asdf", "asdf");
        List<Task> tasks = todoList.getTasks();
        assertEquals(1, tasks.size());
    }

    @Test
    public void testRemoveTwoTasks() {
        todoList.addTask("asdf", "asdf", "asdf", "asdf", "asdf");
        todoList.addTask("assdfdfa", "asdf", "asdf", "asdf", "asdf");
        todoList.removeTask("assdfdfa", "asdf", "asdf", "asdf", "asdf");
        todoList.removeTask("asdf", "asdf", "asdf", "asdf", "asdf");
        List<Task> tasks = todoList.getTasks();
        assertEquals(0, tasks.size());
    }
}

