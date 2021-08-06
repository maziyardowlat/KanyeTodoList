package persistence;

import model.TodoList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads the TodoList that is stored in the file from the JSON data
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader that can read from the source files
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads todoList from the file and returns it;
    // throws IOException if an error occurs reading data from file
    public TodoList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseTodoList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses TodoList from JSON object and returns it
    private TodoList parseTodoList(JSONObject jsonObject) {
        TodoList tl = new TodoList();
        addTasks(tl, jsonObject);
        return tl;
    }

    // MODIFIES: tl
    // EFFECTS: parses tasks from JSON object and adds them to TodoList
    private void addTasks(TodoList tl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("tasks");
        for (Object json : jsonArray) {
            JSONObject nextTasks = (JSONObject) json;
            addToTodoList(tl, nextTasks);
        }
    }

    // MODIFIES: tl
    // EFFECTS: parses tasks from JSON object and adds it to todoList
    private void addToTodoList(TodoList tl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String title = jsonObject.getString("title");
        String dueDate = jsonObject.getString("dueDate");
        String startDate = jsonObject.getString("startDate");
        String grade = jsonObject.getString("grade");
        tl.addTask(name, title, dueDate, startDate, grade);
    }
}

