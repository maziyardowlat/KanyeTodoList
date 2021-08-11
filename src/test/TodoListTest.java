import model.Messing;
import model.Task;
import model.TodoList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class TodoListTest {
    private Task task1;
    private TodoList todoList;
    private Task task2;
    private Task tasky;
    private Task tasky2;
    private Task task3;
    private HashMap<Task, ArrayList<TodoList>> tasks;
    private TodoList todo1;

    @BeforeEach
    public void setup() {
        task1 = new Task("task", "The Title", "Tomorrow", "Today", "93");
        task2 = new Task("task", "Douye", "Tomorrow", "Today", "91");
        todoList = new TodoList();
        Task tasky = new Task("asdf", "asdf", "asdf", "asdf", "93");
        Task tasky2 = new Task("Ulf", "Nick", "Perth", "Tomorrow", "91");
        Task task3 = new Task("Kanye", "Donda", "Esta", "Bibliotecha", "91");
        tasks = new HashMap<>();
        TodoList todo1 = new TodoList();

    }

    @Test
    public void testAddOneTask() {
        todoList.addTask("asdf", "asdf", "asdf", "asdf", "93");
        List<Task> tasks = todoList.getTasks();
        assertEquals(1, tasks.size());
    }

    @Test
    public void testAddTwoTask() {
        todoList.addTask("asdf", "asdf", "asdf", "asdf", "92");
        todoList.addTask("assdfdfa", "asdf", "asdf", "asdf",  "92");
        List<Task> tasks = todoList.getTasks();
        assertEquals(2, tasks.size());
    }

    @Test
    public void testRemoveATask() {
        todoList.addTask("asdf", "asdf", "asdf", "asdf",  "91");
        todoList.addTask("assdfdfa", "asdf", "asdf", "asdf", "91");
        todoList.removeTask("assdfdfa", "asdf");
        List<Task> tasks = todoList.getTasks();
        assertEquals(1, tasks.size());
    }

    @Test
    public void testRemoveTwoTasks() {
        todoList.addTask("asdf", "asdf", "asdf", "asdf",  "31");
        todoList.addTask("assdfdfa", "asdf", "asdf", "asdf",  "32");
        todoList.removeTask("assdfdfa", "asdf");
        todoList.removeTask("asdf", "asdf");
        List<Task> tasks = todoList.getTasks();
        assertEquals(0, tasks.size());
    }

    @Test
    public void testSpecificRemoval() {
        todoList.addTask("name", "title", "name", "title",  "65");
        todoList.removeTask("name","title");
        List<Task> tasks = todoList.getTasks();
        assertEquals(0, tasks.size());
    }

    @Test
    public void testConstructor(){
        assertEquals("task", task1.getName());
        assertEquals("The Title", task1.getTitle());
        assertEquals("Tomorrow", task1.getDueDate());
        assertEquals("Today", task1.getStartDate());
        assertEquals("93", task1.getGrade());
    }

    @Test
    public void testSetFinished(){
        task1.setFinished(true);
        assertTrue(task1.isFinished());
    }

    @Test
    public void testSetStrings(){
        task1.setDueDate("9/4/29");
        assertEquals("9/4/29", task1.getDueDate());
        task1.setName("The First Task");
        assertEquals("The First Task", task1.getName());
        task1.setStartDate("3/4/4");
        assertEquals("3/4/4", task1.getStartDate());
        task1.setTitle("This is a good book");
        assertEquals("This is a good book", task1.getTitle());
        task1.setGrade("92");
        assertEquals("92", task1.getGrade());

    }

    @Test
    public void testRemoveFails() {
        todoList.addTask("Science","Biology", "Tomorrow", "Today", "67");
        todoList.removeTask("Science", "Math");
        assertEquals(1, todoList.getTasks().size());
    }

    @Test
    public void testRemovefailsName(){
        todoList.addTask("Kanye", "West", "Monday", "Today", "43");
        todoList.removeTask("West", "Kanye");
        assertEquals(1, todoList.getTasks().size());
    }

    @Test
    public void testMessing() {
        tasks.put(tasky, new ArrayList<TodoList>());
        ArrayList<TodoList> firstTodo = tasks.get(todo1);
        assertFalse(firstTodo.contains(todo1));
    }


}

