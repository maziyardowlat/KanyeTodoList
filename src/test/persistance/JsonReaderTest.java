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
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testTodoListEmpty.json");
        try {
            TodoList tl = reader.read();
            assertEquals(0, tl.getTasks().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}

