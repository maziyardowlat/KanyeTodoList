package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private ArrayList<Task> tasks;

    //Constructor, makes a new TodoList
    public TodoList() {
        tasks = new ArrayList<>();
    }

    //EFFECTS: returns the todolist items
    public List<Task> getTasks() {
        return tasks;
    }

    //MODIFIES: this
    //EFFECTS: adds a new task to the todolist
    public void addTask(String name, String title, String dueDate, String startDate, Integer grade) {
        Task task1 = new Task(name, title, dueDate, startDate, grade);
        tasks.add(task1);
    }

    // MODIFIES: this
    // EFFECTS: removes this task from the todolist if the name of the task and the title of the task matches.
    public void removeTask(String name, String title) {
        for (int i = 0; i < tasks.size(); i++) {
            if ((tasks.get(i).getName().equals(name)) && (tasks.get(i).getTitle().equals(title))) {
                tasks.remove(tasks.indexOf(tasks.get(i)));
            }
        }
    }


    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("tasks", tasksToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray tasksToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Task t : tasks) {
            jsonArray.put(t.toJson());
        }
        return jsonArray;
    }



}
