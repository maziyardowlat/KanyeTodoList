package persistence;

import model.TodoList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
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

    // EFFECTS: parses workroom from JSON object and returns it
    private TodoList parseTodoList(JSONObject jsonObject) {
        TodoList tl = new TodoList();
        addTasks(tl, jsonObject);
        return tl;
    }

    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addTasks(TodoList tl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("tasks");
        for (Object json : jsonArray) {
            JSONObject nextTasks = (JSONObject) json;
            addToTodoList(tl, nextTasks);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addToTodoList(TodoList tl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String title = jsonObject.getString("title");
        String dueDate = jsonObject.getString("dueDate");
        String startDate = jsonObject.getString("startDate");
        Integer grade = jsonObject.getInt("grade");
        tl.addTask(name, title, dueDate, startDate, grade);
    }
}

