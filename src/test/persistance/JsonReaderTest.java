package persistance;

import model.Task;
import model.TodoList;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest{
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            TodoList tl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // passes
        }
    }

    @Test
    void testReaderEmptyTodoList() {
        JsonReader reader = new JsonReader("./data/testTodoListEmpty.json");
        try {
            TodoList tl = reader.read();
            assertEquals(0, tl.getTasks().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testGeneralTodoList() {
        JsonReader reader = new JsonReader("./data/testTodoListGeneral.json");
        try {
            TodoList tl = reader.read();
            TodoList todolist = new TodoList();
            tl = reader.read();
            List<Task> tasks = tl.getTasks();
            todolist.addTask("Science", "asdf","asdf", "asdf", 92);
            todolist.addTask("Math>", "asdf","asdf", "asdf", 92);
            assertEquals(2, tasks.size());

        } catch (IOException e) {
            fail("Could not read from the given file");
        }
    }

}

