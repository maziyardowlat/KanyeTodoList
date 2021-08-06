package persistance;

import model.Task;
import model.TodoList;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest{

    @Test
    void testWriterInvalidFile() {
        try {
            TodoList tl = new TodoList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyTodoList() {
        try {
            TodoList tl = new TodoList();
            JsonWriter writer = new JsonWriter("./data/testTodoListEmpty.json");
            writer.open();
            writer.write(tl);
            writer.close();
            JsonReader reader = new JsonReader("./data/testTodoListEmpty.json");
            tl = reader.read();
            List<Task> tasks = tl.getTasks();
            assertEquals(0, tasks.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralTodoList() {
        try {
            TodoList tl = new TodoList();
            tl.addTask("Science", "asdf","asdf", "asdf", "92");
            tl.addTask("Math", "asdf","asdf", "asdf", "92");
            JsonWriter writer = new JsonWriter("./data/testTodoListGeneral.json");
            writer.open();
            writer.write(tl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testTodoListGeneral.json");
            tl = reader.read();
            List<Task> tasks = tl.getTasks();
            assertEquals(2, tasks.size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
